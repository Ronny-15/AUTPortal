/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

/**
 *
 * @author ronak
 */
public class Student {

    private String networkLogin;
    private int studentID;
    private String studentName = "";
    private String studentEmail = "";

    public Student(String networkLogin, int studentID, String studentName, String studentEmail) {
        this.networkLogin = networkLogin;
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentEmail = studentEmail;

    }

    public String getNetworkLogin() {
        return networkLogin;
    }

    // get the studentID
    public int getStudentID() {
        return studentID;
    }

    // set the studentID
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    // get the studentName
    public String getStudentName() {
        return studentName;
    }

    // set the studentName
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // get the studentEmail
    public String getStudentEmail() {
        return studentEmail;
    }

    // set the studentEmail
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}
