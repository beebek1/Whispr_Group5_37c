/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.*;
import java.sql.*;

/**
 *
 * @author LOQ
 */
public class SignInController {
    Database db = new Mysqlconnection();
    Connection conn;

    public SignInController() {
        conn = db.openConnection();
    }

    public boolean authenticate(String email, String password) {
        if (conn == null) {
            System.out.println("No DB connection");
            return false;
        }

        try {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Auth error: " + e.getMessage());
        }

        return false;
    }

    public void closeConnection() {
        db.closeConnection(conn);
    }
    
}
