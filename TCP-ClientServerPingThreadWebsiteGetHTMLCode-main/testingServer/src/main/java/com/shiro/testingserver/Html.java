/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shiro.testingserver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Snake
 */
public class Html {
    public static void htmlPersiuntimas(String filePath, Socket clientSocket) {
        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            OutputStream out = clientSocket.getOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            
            fileInputStream.close();
            } catch (IOException e) { //meta klaida
                e.printStackTrace();
        }
    }
    
    public static void failuSujungimas(String inputFilePath1, String inputFilePath2, String inputFilePath3, String outputFilePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            WriteFile.PasteLines(writer, inputFilePath1); //persiuncia duomenis apie 3 output failus i WriteFile, kad juos sujungu
            WriteFile.PasteLines(writer, inputFilePath2);
            WriteFile.PasteLines(writer, inputFilePath3);
        }
    }
}
