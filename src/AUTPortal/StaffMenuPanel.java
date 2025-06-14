/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ronak
 */
public class StaffMenuPanel extends JPanel {

    public StaffMenuPanel(String networkLogin, JFrame parentFrame) {
        setLayout(new BorderLayout());
        add(new JLabel("Welcome, Staff " + networkLogin), BorderLayout.CENTER);
    }
}
