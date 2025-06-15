/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ronak
 */
public class CourseDB {

    Connection conn;

    public CourseDB(Connection conn) {
        this.conn = conn;
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM Courses";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String courseCode = result.getString("CourseCode");
                String courseName = result.getString("CourseName");
                int coursePoints = result.getInt("CoursePoints");
                int courseLevel = result.getInt("CourseLevel");
                courses.add(new Course(courseCode, courseName, coursePoints, courseLevel));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return courses;
    }

    public List<Course> getEnrolledCourses(int studentID) {
        List<Course> enrolled = new ArrayList<>();
        String sql = "SELECT c.COURSECODE, c.COURSENAME, c.COURSEPOINTS, c.COURSELEVEL  FROM Enrolments e JOIN Courses c ON e.COURSECODE = c.COURSECODE WHERE e.STUDENTID = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, studentID);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String courseCode = result.getString("CourseCode");
                String courseName = result.getString("CourseName");
                int coursePoints = result.getInt("CoursePoints");
                int courseLevel = result.getInt("CourseLevel");
                enrolled.add(new Course(courseCode, courseName, coursePoints, courseLevel));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return enrolled;
    }

    public void enrollInCourse(int studentID, String courseCode) {
        String sql = "INSERT INTO Enrolments (StudentID, CourseCode) VALUES (?,?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, studentID);
            statement.setString(2, courseCode);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Course> notEnrolledCourses(int studentID) {
        List<Course> notEnrolled = new ArrayList<>();
        String sql = "SELECT * FROM Courses WHERE CourseCode NOT IN (SELECT CourseCode FROM Enrolments WHERE StudentID = ?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, studentID);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String courseCode = result.getString("CourseCode");
                String courseName = result.getString("CourseName");
                int coursePoints = result.getInt("CoursePoints");
                int courseLevel = result.getInt("CourseLevel");
                notEnrolled.add(new Course(courseCode, courseName, coursePoints, courseLevel));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return notEnrolled;
    }

    public void dropCourses(int studentID, String courseCode) {
        String sql = "DELETE FROM Enrolments WHERE StudentID = ? AND CourseCode = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, studentID);
            statement.setString(2, courseCode);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
