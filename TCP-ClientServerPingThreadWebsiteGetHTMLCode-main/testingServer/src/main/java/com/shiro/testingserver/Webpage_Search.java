/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shiro.testingserver;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author Snake
 */
public class Webpage_Search {
    public static void webpage (String siuntinys, String filtrasPradzia, String filtrasPabaiga, int kelintas) {
        DataInputStream is = null;
        try {
            URL url = new URL(siuntinys);
            is = new DataInputStream(new BufferedInputStream(url.openStream()));
            
            System.out.println(siuntinys);
            
            String line;
            int contain = 0;
            
            WriteFile.start(kelintas);
            
            while ((line = is.readLine()) != null) {
                if (filtrasPradzia.contains("viskas")) {
                    WriteFile.Write(line, kelintas);
                } else if (filtrasPradzia.charAt(0) == '<' && line.contains(filtrasPradzia) || contain > 0) {
                    for (int i = 0; i < line.length(); i++) {
                        char symbol = line.charAt(i);
                        if (line.contains(filtrasPradzia)) {
                            try {
                                if (line.charAt(i) == filtrasPradzia.charAt(0) && line.charAt(i + 1) == filtrasPradzia.charAt(1) && line.charAt(i + 2) == filtrasPradzia.charAt(2) && line.charAt(i + 3) == filtrasPradzia.charAt(3)){
                                    contain++;
                                }
                            } catch (IndexOutOfBoundsException e){ //jei randa <a>
                                contain++;
                            }
                        }
                        if (line.contains(filtrasPabaiga)) {
                            try {
                                if (line.charAt(i) == filtrasPabaiga.charAt(0) && line.charAt(i + 1) == filtrasPabaiga.charAt(1) && line.charAt(i + 2) == filtrasPabaiga.charAt(2) && line.charAt(i + 3) == filtrasPabaiga.charAt(3)){
                                    
                                    //System.out.print(filtrasPabaiga);
                                    WriteFile.Write(filtrasPabaiga, kelintas);
                                    contain--;
                                    break;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                contain--;
                                //System.out.println(filtrasPabaiga + ">");
                                WriteFile.WriteSymbol('>', kelintas);
                                break;
                            }
                            
                        }
                        
                        WriteFile.WriteSymbol(symbol, kelintas);
                    }
                    WriteFile.Write("", kelintas);
                } else if (filtrasPradzia.charAt(0) != '<' && line.indexOf(filtrasPradzia) != -1) {
                    WriteFile.Write(line, kelintas);
                }
                
            }
        }
        catch (Exception e){
            System.exit(1);
        }
        finally {
        /*Close the input stream*/
            try {
                is.close();
            } catch (IOException ioe){
                System.exit(1);
            }
        }
    }
    
}
