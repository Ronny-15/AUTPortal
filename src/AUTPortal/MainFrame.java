/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

import java.sql.Connection;
import javax.swing.JFrame;

/**
 *
 * @author ronak
 */
public class MainFrame {

    public static void main(String[] args) {
        DBManager dbManager = new DBManager();
        System.out.println(dbManager.getConnection());

        Connection conn = dbManager.getConnection();
        DBTableCreator tables = new DBTableCreator(conn);
        tables.createAllTables();

        JFrame frame = new JFrame("AUTPortal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);

        LoginPanel panel = new LoginPanel(conn, frame);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }
}
