/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

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
public class StudentMenuPanel extends JPanel {

    private final JPanel panel;
    private final JLabel labelTitle;
    private final JLabel labelUser;
    private final JButton buttonViewDetails;
    private final JButton buttonViewGrades;
    private final JButton buttonViewCourse;
    private final JButton buttonLogout;

    public StudentMenuPanel(String networkLogin, JFrame parentFrame) {
        setLayout(new BorderLayout());
        labelTitle = new JLabel("Student Menu");
        labelTitle.setFont(new Font("SansSerif", Font.BOLD, 25));
        labelUser = new JLabel("Logged in as " + networkLogin);
        buttonLogout = new JButton("Logout");
        buttonViewDetails = new JButton("Edit/View Details");
        buttonViewDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonViewGrades = new JButton("View Grades");
        buttonViewCourse = new JButton("View Course options");

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());

        labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelTitle);
        panel.add(Box.createVerticalStrut(20));

        buttonViewDetails.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonViewDetails);
        panel.add(Box.createVerticalStrut(10));

        buttonViewGrades.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonViewGrades);
        panel.add(Box.createVerticalStrut(10));
        
        buttonViewCourse.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonViewCourse);
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
