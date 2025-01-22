/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shiro.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
/**
 *
 * @author Snake
 */
public class StartButtonClass {
    public void Start(String serverName, int Port, String button) {
        try {
            String filtroPasirinkimas;
            if (button == "Button") {
                filtroPasirinkimas = Pasirinkimai.select;
            } else {
                filtroPasirinkimas = button;
            }
            
            Socket client = new Socket(serverName, Port);
            String siuntinys1 = new String("https://www.autoplius.lt/index.php");
            String siuntinys2 = new String("https://www.autoaaaabilis.lt/index.php");
            String siuntinys3 = new String("https://www.polizinginiai.lt/index.php");

            String filtras = filtroPasirinkimas; 
            
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());
            
            out.writeUTF(siuntinys1);
            out.writeUTF(siuntinys2);
            out.writeUTF(siuntinys3);
            out.writeUTF(filtras);
            
            System.out.println("Waiting for data...");
            
            boolean a1 = in.readBoolean(); //1 svetaines info
            boolean a2 = in.readBoolean(); //2 svetaines info
            boolean a3 = in.readBoolean(); //3 svetaines info
            
            //System.out.println(a1 + " " + a2 + " " + a3);
            
            if (!a1) System.out.println(siuntinys1 + " adresas buvo nerastas.");
            if (!a2) System.out.println(siuntinys2 + " adresas buvo nerastas.");
            if (!a3) System.out.println(siuntinys3 + " adresas buvo nerastas.");
            
            if (!a1 && !a2 && !a3){
                System.out.println("Atsiprasome, pabandykite dar karta.");
            } else {
                Html.htmlGavimas(in, "Final.html");
            }
            
            client.close();
        } catch(IOException e) {}
    }
    
    
}
