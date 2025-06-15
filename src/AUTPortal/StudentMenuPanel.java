/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

import java.sql.Connection;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
        panelCards.add(gradesMenuPanel(networkLogin), "Grades");
        panelCards.add(courseMenuPanel(networkLogin), "Courses");
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
        buttonViewGrades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCards, "Grades");
            }
        });
        buttonViewCourse = new JButton("View Course options");
        buttonViewCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCards, "Courses");
            }
        });

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

                if (newName != null && !newName.isEmpty()) {
                    if (student != null) {
                        studentDB.updateStudentName(student.getStudentID(), newName);
                        Student updatedStudent = studentDB.getStudentInfo(networkLogin);
                        labelName.setText("Current name: " + updatedStudent.getStudentName());
                        labelStatus.setText("Name updated!");

                    }
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
        JButton buttonBack = new JButton("Go back");
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCards, "Menu");

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
        panel.add(Box.createVerticalStrut(10));
        buttonBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonBack);
        labelStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelStatus);
        panel.add(Box.createVerticalStrut(10));
        panel.add(Box.createVerticalGlue());

        return panel;

    }

    private JPanel gradesMenuPanel(String networkLogin) {
        StudentDB studentDB = new StudentDB(conn);
        Student student = studentDB.getStudentInfo(networkLogin);
        GradeDB gradeDB = new GradeDB(conn);
        List<Grade> grades = gradeDB.getStudentGrade(student.getStudentID());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        labelTitle = new JLabel("Student Menu (Grades)");
        labelTitle.setFont(new Font("SansSerif", Font.BOLD, 25));
        JLabel labalID = new JLabel("Showing grades for: " + student.getStudentName() + ", ID: " + student.getStudentID());
        panel.add(Box.createVerticalGlue());
        labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelTitle);
        panel.add(Box.createVerticalStrut(20));
        labalID.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labalID);
        panel.add(Box.createVerticalStrut(10));

        for (Grade grade : grades) {
            JLabel labelGrades = new JLabel(grade.getCourseCode() + " = " + grade.getGrade());
            labelGrades.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(labelGrades);
            panel.add(Box.createVerticalStrut(10));
        }

        JButton buttonBack = new JButton("Go back");
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCards, "Menu");
            }
        });

        buttonBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonBack);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    private JPanel courseMenuPanel(String networkLogin) {
        CourseDB courseDB = new CourseDB(conn);
        StudentDB studentDB = new StudentDB(conn);
        Student student = studentDB.getStudentInfo(networkLogin);

        labelTitle = new JLabel("Student Menu (Course)");
        labelTitle.setFont(new Font("SansSerif", Font.BOLD, 25));
        JButton buttonViewAllCourses = new JButton("View All Courses");
        buttonViewAllCourses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Course> courses = courseDB.getAllCourses();
                JPanel courseListPanel = new JPanel();
                courseListPanel.setLayout(new BoxLayout(courseListPanel, BoxLayout.Y_AXIS));

                for (Course course : courses) {
                    JLabel labelAllCourse = new JLabel(course.getCode() + ": " + course.getName() + ", Points: " + course.getPoints() + ", Level: " + course.getLevel());
                    courseListPanel.add(labelAllCourse);
                }
                JScrollPane scrollCourses = new JScrollPane(courseListPanel);
                scrollCourses.setPreferredSize(new Dimension(400, 200));
                JOptionPane.showMessageDialog(null, scrollCourses, "All Courses", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton buttonViewEnrolled = new JButton("View Enrolled Courses");
        buttonViewEnrolled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Course> enrolled = courseDB.getEnrolledCourses(student.getStudentID());
                JPanel courseListPanel = new JPanel();
                courseListPanel.setLayout(new BoxLayout(courseListPanel, BoxLayout.Y_AXIS));

                for (Course course : enrolled) {
                    JLabel labelEnrolledCourse = new JLabel(course.getCode() + ": " + course.getName() + ", Points: " + course.getPoints() + ", Level: " + course.getLevel());
                    courseListPanel.add(labelEnrolledCourse);
                }
                JScrollPane scrollCourses = new JScrollPane(courseListPanel);
                scrollCourses.setPreferredSize(new Dimension(400, 200));
                JOptionPane.showMessageDialog(null, scrollCourses, "Enrolled Courses", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        JButton buttonEnrolCourse = new JButton("Enrol in a Course");
        buttonEnrolCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Course> notEnrolled = courseDB.notEnrolledCourses(student.getStudentID());
                
                String[] enrolOptions = new String[notEnrolled.size()];
                for(int i = 0; i < notEnrolled.size(); i++){
                    Course course = notEnrolled.get(i);
                    enrolOptions[i] = course.getCode() + ": " + course.getName();
                }
               
                String selectedOption = (String) JOptionPane.showInputDialog(null, "Select a course to enrol in: ", "Enrol in a course", JOptionPane.PLAIN_MESSAGE, null, enrolOptions, null);
                if(selectedOption != null && !selectedOption.isEmpty()){
                    String selectedCourseCode = selectedOption.split(":")[0].trim();
                    courseDB.enrollInCourse(student.getStudentID(), selectedCourseCode);
                    JOptionPane.showMessageDialog(null, "Enrolled in course: " + selectedCourseCode);
                }
            }
        });
        
        JButton buttonDropOut = new JButton("Drop a Course");
        buttonDropOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Course> enrolled = courseDB.getEnrolledCourses(student.getStudentID());
                
                String[] dropOptions = new String[enrolled.size()];
                for(int i = 0; i < enrolled.size(); i++){
                    Course course = enrolled.get(i);
                    dropOptions[i] = course.getCode() + ": " + course.getName();
                }
               
                String selectedOption = (String) JOptionPane.showInputDialog(null, "Select a course to drop: ", "Drop a course", JOptionPane.PLAIN_MESSAGE, null, dropOptions, null);
                if(selectedOption != null && !selectedOption.isEmpty()){
                    String selectedCourseCode = selectedOption.split(":")[0].trim();
                    courseDB.dropCourses(student.getStudentID(), selectedCourseCode);
                    JOptionPane.showMessageDialog(null, "Dropped course: " + selectedCourseCode);
                }
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());
        labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelTitle);
        panel.add(Box.createVerticalStrut(20));
        buttonViewEnrolled.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonViewEnrolled);
        panel.add(Box.createVerticalStrut(10));
        buttonViewAllCourses.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonViewAllCourses);
        panel.add(Box.createVerticalStrut(10));
        buttonEnrolCourse.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonEnrolCourse);
        panel.add(Box.createVerticalStrut(10));
        buttonDropOut.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(buttonDropOut);
        panel.add(Box.createVerticalStrut(10));
        panel.add(Box.createVerticalGlue());

        return panel;
    }

}
