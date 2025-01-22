/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shiro.egzamininisdarbasclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class sujungimas {
    public void serveris(String serverName, int port) {
        DatagramSocket client = null;

        try {
            client = new DatagramSocket();

            String message = "Hello, Server!";
            String message2 = "It is a nice day!";
            byte[] sendData = message.getBytes();
            byte[] sendData2 = message2.getBytes();
            InetAddress serverAddress = InetAddress.getByName(serverName);

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, port);
            DatagramPacket sendPacket2 = new DatagramPacket(sendData2, sendData2.length, serverAddress, port);
            
            client.send(sendPacket);
            client.send(sendPacket2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (client != null && !client.isClosed()) {
                client.close();
            }
        }
    }
}
