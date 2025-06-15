/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

/**
 *
 * @author ronak
 */
public class Grade {
    private String courseCode;
    private String grade;
    
    public Grade(String courseCode, String grade){
        this.courseCode = courseCode;
        this.grade = grade;
    }

    /**
     * @return the courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }


    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }
    
    
}
