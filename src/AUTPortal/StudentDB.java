/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ronak
 */
public class StudentDB {

    Connection conn;

    public StudentDB(Connection conn) {
        this.conn = conn;
    }

    public Student getStudentInfo(String networkLogin) {
        String sql = "SELECT STUDENTID, NAME, EMAIL FROM Students WHERE NetworkLogin = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, networkLogin);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int studentID = result.getInt("STUDENTID");
                String studentName = result.getString("NAME");
                String studentEmail = result.getString("EMAIL");
                return new Student(networkLogin, studentID, studentName, studentEmail);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void updateStudentName(int studentID, String newName) {
        String sql = "UPDATE STUDENTS SET NAME = ? WHERE STUDENTID = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, newName);
            statement.setInt(2, studentID);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Student getStudentInfoID(int studentID) {
        String sql = "SELECT * FROM Students WHERE StudentID = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, studentID);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String NetworkLogin = result.getString("NetworkLogin");
                String studentName = result.getString("Name");
                String studentEmail = result.getString("Email");
                return new Student(NetworkLogin, studentID, studentName, studentEmail);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
