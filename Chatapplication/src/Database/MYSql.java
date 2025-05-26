/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.*;

/**
 *
 * @author sujalkr.purbey
 */


// Make sure this interface exists
// interface Database {
//     Connection openConnection();
//     void closeConnection(Connection conn);
//     ResultSet runQuery(Connection conn, String query);
//     int executeUpdate(Connection conn, String query);
// }

public class MYSql implements Database {

    @Override
    public Connection openConnection() {
        try {
            String username = "root";
            String password = "12345678";
            String database = "Sujal purbey";

            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + database, username, password);

            if (connection == null) {
                System.out.println("Database connection failed");
            } else {
                System.out.println("Database connection successful");
            }

            return connection;
        } catch (SQLException e) {
            System.out.println("Connection Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }

    @Override
    public ResultSet runQuery(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Query Execution Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public int executeUpdate(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Update Execution Error: " + e.getMessage());
            return -1;
        }
    }

  
}

