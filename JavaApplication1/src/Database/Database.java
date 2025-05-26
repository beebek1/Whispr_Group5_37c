/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.*;
/**
 *
 * @author sujalkr.purbey
 */
public interface Database {
    Connection openConnicetion();
    void closeConnection(Connection conn);
    ResultSet runQuery(Connection conn,String query); //reference type
    int executedUpdate(Connection conn, String query);
    
}
