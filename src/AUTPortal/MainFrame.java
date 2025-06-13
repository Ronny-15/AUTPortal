/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

import javax.swing.JFrame;

/**
 *
 * @author ronak
 */
public class MainFrame {
    public static void main(String[] args) {
        DBManager dbManager = new DBManager();
        System.out.println(dbManager.getConnection());
        dbManager.createLoginUsersTable();
        JFrame frame = new JFrame("AUTPortal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginPanel panel = new LoginPanel();
        frame.add(panel);
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }
}
