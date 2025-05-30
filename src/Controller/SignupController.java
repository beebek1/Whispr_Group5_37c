/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.UserDao;
import model.user;
import view.Signup;
import  java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import javax.swing.JOptionPane;
import utils.EmailSender;


/**
 *
 * @author kanchanmaharjan
 */
public class SignupController {
    
    
    private final UserDao userDao = new UserDao();
    private final Signup userView;

    public SignupController(Signup userView){
        this.userView = userView;

        userView.addAddUserListener(new AddUserListener());
    }

    public void open(){
        this.userView.setVisible(true);
    }
    public void close(){
        this.userView.dispose();
    }

    private static class userService {

        public userService() {
        }
    }
    class AddUserListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                String firstname = userView.getFirstNameField().getText();
                String lastname = userView.getLastNameField().getText();
                String email = userView.getEmailField().getText();
                String password = userView.getPasswordfield().getText();
                // Generate 6-digit OTP
                int otp = (int)(Math.random() * 900000) + 100000;
                String token = String.valueOf(otp);
                boolean is_verified = false;

                // Create user object
                user newUser = new user(email, password, firstname, lastname, is_verified, token);
                newUser.setVerificationToken(token);
                newUser.setVerified(is_verified);

                boolean check = userDao.checkUser(newUser);
                if(check){
                    JOptionPane.showMessageDialog(userView, "Duplicate user");
                }else{
                    userDao.signUp(newUser);
                    userDao.saveOtp(email, token);
                    
                    String verificationLink = "http://localhost:8080/verify?token=" + token;

               // Compose HTML email body with just the code (token)
                String body = "<h3>Welcome to Our App!</h3>" +
                              "<p>Your verification code is:</p>" +
                              "<h2>" + token + "</h2>" +
                              "<p>Please enter this code in the app to verify your email.</p>";

            // Send email - call your EmailSender utility here
            EmailSender.sendEmail(email, "Please Verify Your Email", body);

            JOptionPane.showMessageDialog(userView, "Signup successful! Please check your email to verify your account.");
                }
                
            }catch(Exception ex){
                System.out.println("Error adding uer" + ex.getMessage());
            } 
        }
         
    }
}

