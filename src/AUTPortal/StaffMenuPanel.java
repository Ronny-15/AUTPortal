/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

import java.sql.Connection;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ronak
 */
public class StaffMenuPanel extends JPanel {

    private final JPanel panel;
    private final JLabel labelTitle;
    private final JLabel labelUser;
    private final JButton buttonViewStudentInfo;
    private final JButton buttonStudentCourses;
    private final JButton buttonUpdateGrade;
    private final JButton buttonLogout;
    private JFrame parentFrame;
    Connection conn;

    public StaffMenuPanel(String networkLogin, JFrame parentFrame, Connection conn) {
        this.conn = conn;
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());
        labelTitle = new JLabel("Staff Menu");
        labelTitle.setFont(new Font("SansSerif", Font.BOLD, 25));
        labelUser = new JLabel("Logged in as " + networkLogin);
        buttonLogout = new JButton("Logout");
        buttonLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.setContentPane(new LoginPanel(conn, parentFrame));
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
        buttonViewStudentInfo = new JButton("View Student Info");
        buttonViewStudentInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonStudentCourses = new JButton("Student Courses");
        buttonUpdateGrade = new JButton("Update Student Grade");

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());

        labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelTitle);
        panel.add(Box.createVerticalStrut(20));

        buttonViewStudentInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonViewStudentInfo);
        panel.add(Box.createVerticalStrut(10));

        buttonStudentCourses.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonStudentCourses);
        panel.add(Box.createVerticalStrut(10));

        buttonUpdateGrade.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonUpdateGrade);
        panel.add(Box.createVerticalStrut(10));
        panel.add(Box.createVerticalGlue());

        JPanel rowTopRight = new JPanel(new BorderLayout());
        JPanel rowLogout = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        rowLogout.add(buttonLogout);
        rowTopRight.add(rowLogout, BorderLayout.EAST);
        add(rowTopRight, BorderLayout.NORTH);

        JPanel rowlabelUser = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rowlabelUser.add(labelUser);
        rowTopRight.add(rowlabelUser, BorderLayout.WEST);
        add(rowTopRight, BorderLayout.NORTH);

        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panel);

    }
}
