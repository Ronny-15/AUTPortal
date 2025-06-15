/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

/**
 *
 * @author ronak
 */
public class Course {

    private String courseCode;
    private String courseName;
    private int coursePoints;
    private int courseLevel;

    public Course(String code, String name, int points, int level) {
        this.setCode(code);
        this.setName(name);
        this.setPoints(points);
        this.setLevel(level);
    }

    public String getCode() {
        return courseCode;
    }

    public void setCode(String code) {
        this.courseCode = code;
    }

    public String getName() {
        return courseName;
    }

    public void setName(String name) {
        this.courseName = name;
    }

    public int getPoints() {
        return coursePoints;
    }

    public void setPoints(int points) {
        this.coursePoints = points;
    }

    public int getLevel() {
        return courseLevel;
    }

    public void setLevel(int level) {
        this.courseLevel = level;
    }

}
