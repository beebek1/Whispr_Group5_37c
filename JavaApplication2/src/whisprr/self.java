package whisprr;

import Database.*;

public class self{
    public static void main(String[]args){
        Database db = new MySqlConnection();
        if(db.openConnection()!= null){
            System.out.println("Database connected Succefully!");
        }
        else{
            System.out.println("Failed to connect to database.");
        }
    }
}