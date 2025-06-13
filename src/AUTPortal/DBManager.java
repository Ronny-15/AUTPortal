/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ronak
 */
public final class DBManager {
    private static final String USER_NAME = "Ronny"; 
    private static final String PASSWORD = "Ronny"; 
    private static final String URL = "jdbc:derby:AUTPortalDB;create=true";  

    Connection conn;

    public DBManager() {
        establishConnection();
    }

    public Connection getConnection() {
        return this.conn;
    }

    //Establish connection
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Get Connected Successfully ....");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    
    public void createLoginUsersTable(){
           try {
            Statement statement = conn.createStatement();
            String newTable = "LoginUsers";

            dropTableIfExists(newTable);

            String sqlCreateTable = "CREATE TABLE " + newTable + " (StudentID INT PRIMARY KEY, " + " UserName VARCHAR(50), " + "Password VARCHAR(50),"+"Role VARCHAR(50))";

            String insertData = "INSERT INTO " + newTable + " VALUES " 
                    + "(999,'admin', 'admin','Staff')," 
                    + "(998,'Staff1', 'AUT','Staff')," 
                    + "(997,'Staff2', 'AUT','Staff'),"
                    + "(101,'Student1', 'pass123','Student'),"
                    + "(102,'Student2', 'pass123','Student'),"
                    + "(22184803,'qvz3326', '123','Student')";
            

            statement.execute(sqlCreateTable);
            statement.execute(insertData);
            System.out.println("AUTPortalDB: " + newTable + " table created.");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

    }
     public void dropTableIfExists(String tableName) {
        try {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet tables = meta.getTables(null, null, tableName.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("AUTPortalDB:: " + tableName + " table exists. Dropping it.");
                Statement statement = conn.createStatement();
                statement.execute("DROP TABLE " + tableName);
            } else {
                System.out.println("AUTPortalDB: " + tableName + " table does not exists.");
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

}


