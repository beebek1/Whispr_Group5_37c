/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package whispr_project;
import Database.*;
/**
 *
 * @author bibek
 */
public class Whispr_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Database db= new MySqlConnection();
        if(db.openConnection()!=null){
            System.out.println("Database connected successfully!");
        }else{
            System.out.println("Failed to connect to database");
        }
        
    }
    
}


