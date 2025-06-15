/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ronak
 */
public class LoginPanel extends JPanel {

    private final JPanel panel;
    private final JLabel labelTitle;
    private final JLabel labelNetworkLogin;
    private final JLabel labelPassword;
    private final JTextField textNetworkLogin;
    private final JPasswordField textPassword;
    private final JButton buttonLogin;
    private final JLabel labelStatus;
    private JFrame parentFrame;
    Connection conn;

    public LoginPanel(Connection conn, JFrame parentFrame) {
        this.conn = conn;
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());
        labelTitle = new JLabel("AUT Portal");
        labelTitle.setFont(new Font("SansSerif", Font.BOLD, 25));
        labelStatus = new JLabel(" ");
        labelNetworkLogin = new JLabel("NetworkLogin: ");
        labelPassword = new JLabel("Password: ");
        textNetworkLogin = new JTextField("", 25);
        textPassword = new JPasswordField("", 25);
        buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String networkLogin = new String(textNetworkLogin.getText().trim());
                    String password = new String(textPassword.getPassword()).trim();
                    LoginUsersDB loginUsers = new LoginUsersDB(conn);

                    String role = loginUsers.verifyLogin(networkLogin, password);

                    if (networkLogin.isEmpty() || password.isEmpty()) {
                        labelStatus.setText("Please enter in both fields.");
                    } else if (role == null) {
                        labelStatus.setText("NetworkLogin or Password is incorrect.");
                    } else if (role.equalsIgnoreCase("Student")) {
                        parentFrame.setContentPane(new StudentMenuPanel(networkLogin, parentFrame, conn));
                        parentFrame.revalidate();
                        parentFrame.repaint();
                    } else if (role.equalsIgnoreCase("Staff")) {
                        parentFrame.setContentPane(new StaffMenuPanel(networkLogin, parentFrame, conn));
                        parentFrame.revalidate();
                        parentFrame.repaint();
                    }

                } catch (Exception ex) {
                }
            }
        });
        textNetworkLogin.setPreferredSize(new Dimension(0, 25));
        textPassword.setPreferredSize(new Dimension(0, 25));

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel rowTitle = new JPanel();
        rowTitle.add(labelTitle);
        JPanel rowNetworkLogin = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        rowNetworkLogin.add(labelNetworkLogin);
        rowNetworkLogin.add(textNetworkLogin);
        JPanel rowPassword = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        rowPassword.add(labelPassword);
        rowPassword.add(textPassword);
        JPanel rowStatus = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        rowStatus.add(labelStatus);
        JPanel rowButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        rowButton.add(buttonLogin);
        panel.add(rowTitle);
        panel.add(rowNetworkLogin);
        panel.add(rowPassword);
        panel.add(rowButton);
        panel.add(rowStatus);

        setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));
        add(panel, BorderLayout.CENTER);

    }
}
