/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shiro.testingserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Snake
 */


public class WriteFile {
    public static void Write(String line, int kelintas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output" + kelintas + ".html", true))) {
            writer.write(line + "\n"); //raso simbolius su tarpais
            
            writer.flush(); //užtikrina, kad duomenys būtų įrašyti į faila nedelsiant
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void WriteSymbol(char symbol, int kelintas) { //raso simbolius be tarpo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output" + kelintas + ".html", true))) {
            writer.write(symbol);
            
            writer.flush(); //užtikrina, kad duomenys būtų įrašyti į faila nedelsiant
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void PasteLines(BufferedWriter writer, String filePath) { //greitam failu sujungimui
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {}
    }
    
    public static void start (int kelintas) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output" + kelintas + ".html"));
        writer.write("");
    }
}
