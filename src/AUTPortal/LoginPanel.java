/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ronak
 */
public class LoginPanel extends JPanel {

    private JPanel panel;
    private JLabel labelTitle;
    private JLabel labelNetworkLogin;
    private JLabel labelPassword;
    private JTextField textNetworkLogin;
    private JPasswordField textPassword;
    private JButton buttonLogin;

    public LoginPanel() {
        labelTitle = new JLabel("AUT Portal");
        labelTitle.setFont(new Font("SansSerif", Font.BOLD, 25));
        labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelNetworkLogin = new JLabel("NetworkLogin: ");
        labelPassword = new JLabel("Password: ");
        textNetworkLogin = new JTextField("", 25);
        textPassword = new JPasswordField("", 25);
        buttonLogin = new JButton("Login");
        textNetworkLogin.setPreferredSize(new Dimension(200, 30));
        textPassword.setPreferredSize(new Dimension(200, 30));

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel rowTitle = new JPanel();
        rowTitle.add(labelTitle);
        JPanel rowNetworkLogin = new JPanel(new FlowLayout(FlowLayout.LEFT, 45, 0));
        rowNetworkLogin.add(labelNetworkLogin);
        rowNetworkLogin.add(textNetworkLogin);
        JPanel rowPassword = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        rowPassword.add(labelPassword);
        rowPassword.add(textPassword);
        JPanel rowButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, -5));
        rowButton.add(buttonLogin);
        panel.add(rowTitle);
        panel.add(rowNetworkLogin);
        panel.add(rowPassword);
        panel.add(rowButton); 
        
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

    }
}
