/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import database.MySqlConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import model.user;

/**
 *
 * @author kanchanmaharjan
 */
public class UserDao {
    MySqlConnection mysql = new MySqlConnection();
    Connection conn = mysql.openConnection();
    
    public void signUp(user user){
        String sql = "Insert into user (first_name, last_name,email, password,is_verified) values (?,?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setBoolean(5, user.getis_verified());
            pstmt.executeUpdate();
        }catch (SQLException ex){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection(conn);
        } 
    }
    public boolean checkUser(user user){
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM user where email = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, user.getEmail());
            ResultSet result = pstmt.executeQuery();
            return result.next();
        }catch (SQLException ex){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return false;
    }
    public void saveOtp(String email, String otp) {
    Connection conn = mysql.openConnection();
    String sql = "INSERT INTO otp_table (email, otp) VALUES (?, ?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, email);
        pstmt.setString(2, otp);
        int rows = pstmt.executeUpdate();
        System.out.println("OTP insert status: " + rows + " row(s) added");  // ✅ Add this
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Error saving OTP: " + ex.getMessage());  // ✅ Add this
    } finally {
        mysql.closeConnection(conn);
    }
}

    public boolean verifyOtp(String email, String otp) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM otp_table WHERE email = ? AND otp = ? AND NOW() <= expires_at";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, email);
            pstmt.setString(2, otp);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }catch(SQLException ex){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection(conn);
        }
        return false;
    }

    public void deleteOtp(String email) {
        Connection conn = mysql.openConnection();
        String sql = "DELETE FROM otp_table WHERE email = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, email);
            pstmt.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection(conn);
        }
    }
    public void setUserVerified(String email, boolean status) {
    Connection conn = mysql.openConnection();
    String sql = "UPDATE user SET is_verified = ? WHERE email = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setBoolean(1, status);
        pstmt.setString(2, email);
        pstmt.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        mysql.closeConnection(conn);
    }
}

}
