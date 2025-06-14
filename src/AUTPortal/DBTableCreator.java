/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AUTPortal;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ronak
 */
public class DBTableCreator {

    Connection conn;

    public DBTableCreator(Connection conn) {
        this.conn = conn;
    }

    public void createAllTables() {
        createLoginUsersTable();
        createCourseTable();
        createEnrolmentsTable();
        createGradesTable();
        createStaffTable();
        createStudentsTable();
    }

    public void dropTableIfExists(String tableName) {
        try {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet tables = meta.getTables(null, null, tableName.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("AUTPortalDB: " + tableName + " table exists. Dropping it.");
                Statement statement = conn.createStatement();
                statement.execute("DROP TABLE " + tableName);
            } else {
                System.out.println("AUTPortalDB: " + tableName + " table does not exists.");
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

    }

    public void createLoginUsersTable() {
        try {
            Statement statement = conn.createStatement();
            String newTable = "LoginUsers";

            dropTableIfExists(newTable);

            String sqlCreateTable = "CREATE TABLE " + newTable + " (StudentID INT PRIMARY KEY, " + " NetworkLogin VARCHAR(50), " + "Password VARCHAR(50)," + "Role VARCHAR(50))";

            String insertData = "INSERT INTO " + newTable + " VALUES " + "(999,'admin', 'admin','Staff'),"
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

    public void createCourseTable() {
        try {
            Statement statement = conn.createStatement();
            String newTable = "Courses";

            dropTableIfExists(newTable);

            String sqlCreateTable = "CREATE TABLE " + newTable + "(CourseCode VARCHAR(50), " + "CourseName VARCHAR(50)," + "CoursePoints INT," + "CourseLevel INT)";

            String insertData = "INSERT INTO " + newTable + " VALUES "
                    + "('COMP500','Programming Concepts and Techniques',15,5), "
                    + "('COMP501','Computing Technology in Society',15,5), "
                    + "('COMP503','Object Oriented Programming',15,5), "
                    + "('COMP504','Networks and Internet',15,5), "
                    + "('COMP505','Introduction to Programming',15,5), "
                    + "('COMP506','Computer Organisation',15,5), "
                    + "('COMP507','IT Project Management',15,5), "
                    + "('COMP508','Database System Design',15,5), "
                    + "('COMP517','Data Analysis',15,5), "
                    + "('COMP600','IT Project Management',15,6), "
                    + "('COMP602','Software Development Practice',15,6), "
                    + "('COMP603','Program Design and Construction',15,6), "
                    + "('COMP604','Operating Systems',15,6), "
                    + "('COMP607','Information Security Technologies',15,6), "
                    + "('COMP609','Network and System Administration',15,6), "
                    + "('COMP610','Data Structures and Algorithms',15,6), "
                    + "('COMP611','Algorithm Design and Analysis',15,6), "
                    + "('COMP612','Computer Graphics Programming',15,6), "
                    + "('COMP613','Combinatorics and Graph Theory',15,6), "
                    + "('COMP615','Foundations of Data Science',15,6), "
                    + "('COMP616','Statistics for Data Science',15,6), "
                    + "('COMP700','Text and Vision Intelligence',15,7), "
                    + "('COMP701','Nature Inspired Computing',15,7), "
                    + "('COMP702','Research and Development Project Part 1',15,7), "
                    + "('COMP703','Research and Development Project Part 2',15,7), "
                    + "('COMP705','Special Topic',15,7), "
                    + "('COMP707','Conjoint Cooperative Education Project',15,7), "
                    + "('COMP708','Conjoint Cooperative Education Project (Part A)',15,7), "
                    + "('COMP709','Conjoint Cooperative Education Project (Part B)',15,7), "
                    + "('COMP710','Game Programming',15,7), "
                    + "('COMP711','Theory of Computation',15,7), "
                    + "('COMP712','Programming Languages',15,7), "
                    + "('COMP713','Distributed and Mobile Systems',15,7), "
                    + "('COMP714','Advanced Network Technologies',15,7), "
                    + "('COMP715','Network Security',15,7), "
                    + "('COMP716','Highly Secure Systems',15,7), "
                    + "('COMP717','Artificial Intelligence',15,7), "
                    + "('COMP718','Information Security Management',15,7), "
                    + "('COMP719','Applied Human Computer Interaction',15,7), "
                    + "('COMP721','Web Development',15,7), "
                    + "('COMP723','Data Mining and Knowledge Engineering',15,7), "
                    + "('COMP726','Blockchain and Cryptocurrency Technology',15,7), "
                    + "('COMP728','Internet of Things and Applications',15,7), "
                    + "('COMP729','Enterprise Networks',15,7)";

            statement.execute(sqlCreateTable);
            statement.execute(insertData);
            System.out.println("AUTPortalDB: " + newTable + " table created.");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

    }

    public void createEnrolmentsTable() {
        try {
            Statement statement = conn.createStatement();
            String newTable = "Enrolments";

            dropTableIfExists(newTable);

            String sqlCreateTable = "CREATE TABLE " + newTable + "(StuedntID INT, " + "CourseCode VARCHAR(50))";

            String insertData = "INSERT INTO " + newTable + " VALUES " + "(999,'COMP500')";

            statement.execute(sqlCreateTable);
            statement.execute(insertData);
            System.out.println("AUTPortalDB: " + newTable + " table created.");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

    }

    public void createGradesTable() {
        try {
            Statement statement = conn.createStatement();
            String newTable = "Grades";

            dropTableIfExists(newTable);

            String sqlCreateTable = "CREATE TABLE " + newTable + "(StudentID INT, " + "CourseCode VARCHAR(50)," + "Grade VARCHAR(50))";

            String insertData = "INSERT INTO " + newTable + " VALUES " + "(999,'COMP500', 'A+')";

            statement.execute(sqlCreateTable);
            statement.execute(insertData);
            System.out.println("AUTPortalDB: " + newTable + " table created.");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

    }

    public void createStaffTable() {
        try {
            Statement statement = conn.createStatement();
            String newTable = "Staff";

            dropTableIfExists(newTable);

            String sqlCreateTable = "CREATE TABLE " + newTable + "(NetworkLogin VARCHAR(50), " + "StaffID INT PRIMARY KEY, " + " Name VARCHAR(50), " + "Email VARCHAR(50))";

            String insertData = "INSERT INTO " + newTable + " VALUES " + "('admin',999,'John Pork', 'John.pork@aut.ac.nz'),"
                    + "('Staff1',998,'Weihua Li', 'weihua.li@aut.ac.nz'),"
                    + "('Staff2',997,'Xinyu Hu', 'xinyu.hu@aut.ac.nz')";

            statement.execute(sqlCreateTable);
            statement.execute(insertData);
            System.out.println("AUTPortalDB: " + newTable + " table created.");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

    }

    public void createStudentsTable() {
        try {
            Statement statement = conn.createStatement();
            String newTable = "Students";

            dropTableIfExists(newTable);

            String sqlCreateTable = "CREATE TABLE " + newTable + "(NetworkLogin VARCHAR(50), " + "StudentID INT PRIMARY KEY, " + " Name VARCHAR(50), " + "Email VARCHAR(50))";

            String insertData = "INSERT INTO " + newTable + " VALUES " + "('qvz3326',22184803,'Ronny Patel', 'qvz3326@autuni.ac.nz'),"
                    + "('Student1',101,'Alyssa Chia', 'Student1@autuni.ac.nz'),"
                    + "('Student2',102,'Mary Anne', 'Student2@autuni.ac.nz'),"
                    + "('Student3',29734627,'Andrew Smith', 'Student3@autuni.ac.nz')";

            statement.execute(sqlCreateTable);
            statement.execute(insertData);
            System.out.println("AUTPortalDB: " + newTable + " table created.");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

    }

}
