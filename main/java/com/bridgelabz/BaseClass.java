package com.bridzelabz.dbautomation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BaseClass {
    public static Connection connection;
    @BeforeTest
    public static Connection setUp() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/uploadfilecsv";
        String username = "root";
        String password = "ekta123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection ;
    }
    @AfterTest
    protected void tearDown() throws SQLException {
        if (connection != null) {
            try {
                System.out.println("Closing Database Connection.....");
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
