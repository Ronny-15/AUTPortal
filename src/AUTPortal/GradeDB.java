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
public class GradeDB {
    
    Connection conn;

    public GradeDB(Connection conn) {
        this.conn = conn;
    }
    
    public List<Grade> getStudentGrade(int studentID) {
        List<Grade> grades = new ArrayList<>();
        String sql = "SELECT COURSECODE , GRADE FROM Grades WHERE StudentID = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, studentID);

            ResultSet result = statement.executeQuery();
            while(result.next()) {
                String courseCode = result.getString("COURSECODE");
                String grade = result.getString("GRADE");
                grades.add(new Grade(courseCode, grade));
            }
        } catch (SQLException e) {

        }
        return grades;
    }
}
