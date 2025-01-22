/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.shiro.egzamininisdarbasclient;

/**
 *
 * @author Snake
 */
public class darbas extends javax.swing.JFrame {
    static String serverName;
    static int port;
    /**
     * Creates new form Main
     */
    public darbas() {
        initComponents();
    }

    /**
     * Šis darbas nėra pats egzaminas. Šis kodas buvo reikalingas dėl viso pikto, kad jei prireiktų egzaminui serverio sujungimo pradmenų.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
     public static void main(String args[]) {
        
         System.out.println(args[0] + " " + args[1]);
         
        serverName = args[0];
        port = Integer.parseInt(args[1]);
        
        new darbas().setVisible(true);
        
        sujungimas sujungti  = new sujungimas();
        sujungti.serveris(serverName, port);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {}
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
