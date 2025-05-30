/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Whisp;

import Controller.SignupController;
import database.Database;
import database.MySqlConnection;
import view.Signup;

/**
 *
 * @author kanchanmaharjan
 */
public class Whis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Signup SignupForm = new Signup();
        SignupController controller = new SignupController(SignupForm);
        controller.open();
       Database db = new MySqlConnection();
        if(db.openConnection() != null){
            System.out.println("Database connected successflly!");
        }else {
            System.out.println("Failed to connect to database.");
        }
        
    }
    
}
