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
public class LoginUsersDB {

    Connection conn;

    public LoginUsersDB(Connection conn) {
        this.conn = conn;
    }

    public String verifyLogin(String networkLogin, String password) {
        String sql = "SELECT Role FROM LoginUsers WHERE NetworkLogin = ? AND Password = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, networkLogin);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return result.getString("Role");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }
}
