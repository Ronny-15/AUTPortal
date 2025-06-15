/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

import java.sql.Connection;
import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ronak
 */
public class StudentMenuPanel extends JPanel {

    private final JPanel panelCards;
    private final CardLayout cardLayout;
    JLabel labelTitle;
    JLabel labelUser;
    JButton buttonViewDetails;
    JButton buttonViewGrades;
    JButton buttonViewCourse;
    JButton buttonLogout;

    private JFrame parentFrame;
    Connection conn;

    public StudentMenuPanel(String networkLogin, JFrame parentFrame, Connection conn) {
        this.conn = conn;
        this.parentFrame = parentFrame;

        setLayout(new BorderLayout());
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

        JPanel Top = new JPanel(new BorderLayout());
        JPanel logout = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        logout.add(buttonLogout);
        Top.add(logout, BorderLayout.EAST);
        JPanel user = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        user.add(labelUser);
        Top.add(labelUser, BorderLayout.WEST);
        add(Top, BorderLayout.NORTH);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        cardLayout = new CardLayout();
        panelCards = new JPanel(cardLayout);

        panelCards.add(mainMenuPanel(networkLogin), "Menu");
        panelCards.add(detailsMenuPanel(networkLogin), "Details");
        add(panelCards, BorderLayout.CENTER);
        cardLayout.show(panelCards, "Menu");

    }

    private JPanel mainMenuPanel(String networkLogin) {

        labelTitle = new JLabel("Student Menu");
        labelTitle.setFont(new Font("SansSerif", Font.BOLD, 25));
        buttonViewDetails = new JButton("Edit/View Details");
        buttonViewDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCards, "Details");
            }
        });
        buttonViewGrades = new JButton("View Grades");
        buttonViewCourse = new JButton("View Course options");

        JPanel panel = new JPanel();
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

        return panel;
    }

    private JPanel detailsMenuPanel(String networkLogin) {
        StudentDB studentDB = new StudentDB(conn);
        Student student = studentDB.getStudentInfo(networkLogin);
        labelTitle = new JLabel("Student Menu (Details)");
        labelTitle.setFont(new Font("SansSerif", Font.BOLD, 25));

        JLabel labelName = new JLabel("Current name: " + student.getStudentName());
        JLabel labalID = new JLabel("Current Student ID: " + student.getStudentID());
        JLabel labelEmail = new JLabel("Current Student Email: " + student.getStudentEmail());
        JLabel labelStatus = new JLabel(" ");

        JButton buttonEditName = new JButton("Edit name");
        buttonEditName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newName = JOptionPane.showInputDialog(null, "Enter new full name:");

                if (!newName.isEmpty()) {
                    if (student != null) {
                        studentDB.updateStudentName(student.getStudentID(), newName); 
                        Student updatedStudent = studentDB.getStudentInfo(networkLogin);
                        labelName.setText("Current name: "+ updatedStudent.getStudentName());
                        labelStatus.setText("Name updated!");
                        
                    }

                } else {
                    labelStatus.setText("Name can't be empty!");

                }

            }
        });
        JButton buttonStudentID = new JButton("Edit Student ID");
        buttonStudentID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelStatus.setText("You don't have permission to Edit StudentID!");
            }
        });
        JButton buttonStudentEmail = new JButton("Edit Student Email");
        buttonStudentEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelStatus.setText("You don't have permission to Edit Student Email!");

            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());
        labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelTitle);
        panel.add(Box.createVerticalStrut(20));

        labelName.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelName);
        panel.add(Box.createVerticalStrut(10));

        labalID.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labalID);
        panel.add(Box.createVerticalStrut(10));

        labelEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelEmail);
        panel.add(Box.createVerticalStrut(10));

        buttonEditName.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonEditName);
        panel.add(Box.createVerticalStrut(10));
        buttonStudentID.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonStudentID);
        panel.add(Box.createVerticalStrut(10));
        buttonStudentEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonStudentEmail);
        labelStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelStatus);
        panel.add(Box.createVerticalStrut(10));
        panel.add(Box.createVerticalGlue());

        return panel;

    }
}
