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
                return new Student(studentID, studentName, studentEmail);
            }
        } catch (SQLException e) {

        }
        return null;
    }
}
