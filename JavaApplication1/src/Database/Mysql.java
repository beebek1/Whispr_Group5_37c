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
public class Mysql implements Database{

    @Override
    public Connection openConnicetion() {
        try{
            String Username = "root";
            String password = "12345678";
            String database = "Chatapplication"; 
            Connection connection;
            connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/"+ database,Username,password);
            if  (connection == null){
                System.out.println("Database connection fail");
                
            }else{
                System.out.println("Databse connection successs");
            }
            return connection;
        }catch (SQLException e){
            System.out.println(e);
            return null;
            
        }
    }
    

    @Override
    public void closeConnection(Connection conn) {
        try{
   if (conn!=null&& !conn.isClosed()){
   conn.close();
   System.out.println("Connection close");
}
}catch (SQLException e){
  System.out.println(e);
}
    }

  @Override
    public ResultSet runQuery(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            return result;
        } catch (SQLException e) {
            System.out.println("Query Execution Error: " + e.getMessage());
            return null;
        }
    }



    @Override
    public int executedUpdate(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            System.out.println("Update Execution Error: " + e.getMessage());
            return -1;
        }

    }
}


import Database.*;
public class Self{
    public static void main(String[]args){
        Database db = new Mysql();
        if(db.openConnection()!=null){
            System.out.println("Database connected successfully");
        }else{
            System.out.println("failed to connect to database");
            
        }
    }
}
