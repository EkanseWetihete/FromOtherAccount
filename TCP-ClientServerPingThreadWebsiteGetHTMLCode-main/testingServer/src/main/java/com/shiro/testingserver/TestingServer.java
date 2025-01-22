package com.shiro.testingserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class TestingServer {
    private ServerSocket serverSocket;
    
    
    public TestingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(1000000);
    }
    
    public void run() {
        while (true) {
            try {
                
                System.out.println("Laukiama kliento prisijungimo...");
                Socket server = serverSocket.accept();
                System.out.println("");
                System.out.println("Siunciama uzklausa adreso: " + server.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(server.getInputStream());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                
                String siuntinys1 = in.readUTF(); //svetaine 1
                String siuntinys2 = in.readUTF(); //svetaine 2
                String siuntinys3 = in.readUTF(); //svetaine 3
                String filtrasPradzia = in.readUTF(); //filtro pradzios gavimas
                String filtrasPabaiga = FiltroGalas.filtroGalas(filtrasPradzia);
                
                boolean a1 = false;
                boolean a2 = false;
                boolean a3 = false;
                
                if (basicPing(siuntinys1)) a1 = true;
                if (basicPing(siuntinys2)) a2 = true;
                if (basicPing(siuntinys3)) a3 = true;
                
                Thread gija1 = new Thread(() -> { //gijos
                    if (basicPing(siuntinys1)) {
                        Webpage_Search.webpage(siuntinys1, filtrasPradzia, filtrasPabaiga, 1);
                    } else {
                        System.out.println(siuntinys1 + " Nepasiekiamas");
                    }
                });
                
                Thread gija2 = new Thread(() -> {
                    if (basicPing(siuntinys2)) {
                        Webpage_Search.webpage(siuntinys2, filtrasPradzia, filtrasPabaiga, 2);
                    } else {
                        System.out.println(siuntinys2 + " Nepasiekiamas");
                    }
                });

                Thread gija3 = new Thread(() -> {
                   if (basicPing(siuntinys3)) {
                       Webpage_Search.webpage(siuntinys3, filtrasPradzia, filtrasPabaiga, 3);
                   } else {
                        System.out.println(siuntinys3 + " Nepasiekiamas");
                    }
                });
                
                gija1.start();
                gija2.start();
                gija3.start();
                
                try {
                    gija1.join();
                    gija2.join();
                    gija3.join();
                } catch (InterruptedException e) {}
                
                System.out.println(a1);
                
                out.writeBoolean(a1);
                out.writeBoolean(a2);
                out.writeBoolean(a3);
                
                String inputFilePath1 = "output1.html";
                String inputFilePath2 = "output2.html";
                String inputFilePath3 = "output3.html";
                String outputFilePath = "Final.html";
                
                Html.failuSujungimas(inputFilePath1, inputFilePath2, inputFilePath3, outputFilePath);
                Html.htmlPersiuntimas("Final.html", server);
                
                } catch (SocketTimeoutException s) {
                System.out.println("Sujungimas baigtas!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            } 
        }
    }
    
    public boolean basicPing(String svetaine) {
    String svetaineFix = svetaine.substring(12, svetaine.length() - 10); //palieka tik www. ... .lt dalis
    try {
        InetAddress adresas = InetAddress.getByName(svetaineFix);
        if (adresas.isReachable(5000)) { 
            //System.out.println("veikia");
            return true;
        } else {
            //System.out.println("Nepasiekiamas: ");
            return false;
        }
    } catch (IOException e) {
        //System.out.println("Nepasiekiamas: " + svetaine);
        return false;
    }
    }
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java com.shiro.testingserver.TestingServer <port>");
            return;
        }

        int port = Integer.parseInt(args[0]);
        try {
            TestingServer server = new TestingServer(port);
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
