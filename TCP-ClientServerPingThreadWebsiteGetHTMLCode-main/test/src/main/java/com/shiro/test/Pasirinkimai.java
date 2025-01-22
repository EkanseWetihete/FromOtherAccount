/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shiro.test;

/**
 *
 * @author Snake
 */
public class Pasirinkimai {
    public static String select = "";
    
    public void pasirinkimas() {
        if (Testing.Pasirinkimas1.getSelectedItem() == "Kodas") kodas();
        if (Testing.Pasirinkimas1.getSelectedItem() == "Turinys") turinys();
    }
    
    public void filtruPasirinkimas() { //baigta
        select = (String) Testing.filtruPasirinkimas.getSelectedItem();
    }
    
    public void kodas() { //baigta
        Testing.filtruPasirinkimas.removeAllItems();
        Testing.filtruPasirinkimas.addItem("viskas");
        Testing.filtruPasirinkimas.addItem("<script>");
        Testing.filtruPasirinkimas.addItem("<a>"); //<a href="">
        Testing.filtruPasirinkimas.addItem("<head>");
        Testing.filtruPasirinkimas.addItem("<body>");
    }
    public void turinys() { //turinio filtrus daryk dabar ---------------------------------------------------------------------------------
        Testing.filtruPasirinkimas.removeAllItems();
        Testing.filtruPasirinkimas.addItem("automobilis");
        Testing.filtruPasirinkimas.addItem("Kaina");
    }
}
