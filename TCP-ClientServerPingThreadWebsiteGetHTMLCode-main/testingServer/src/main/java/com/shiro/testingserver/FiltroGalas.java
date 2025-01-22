/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shiro.testingserver;

/**
 *
 * @author Snake
 */
public class FiltroGalas {
    public static String filtroGalas(String filtrasPradzia){ //filtro pabaigos sukurimas
        String finalFiltras = "";
        for (int i = 0; i < filtrasPradzia.length(); i++) {
            char symbol = filtrasPradzia.charAt(i);
            
            if (i == 1){
                finalFiltras = finalFiltras + '/';
            }
            finalFiltras = finalFiltras + symbol;
            
            if (finalFiltras == "</a") finalFiltras = finalFiltras + ">";
        }
        
        return finalFiltras;
    }
}
