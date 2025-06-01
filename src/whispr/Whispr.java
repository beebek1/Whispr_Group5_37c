    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
     */
package whispr;

import Database.*;
import view.SignIn;  // Make sure this is the correct package

public class Whispr {
    public static void main(String[] args) {
        Database db = new Mysqlconnection();
        if (db.openConnection() != null) {
            System.out.println("Database connected successfully");
        } else {
            System.out.println("Failed to connect to database");
        }

        // Open the SignIn form
        SignIn frame = new SignIn();
        frame.setVisible(true);
    }
}
