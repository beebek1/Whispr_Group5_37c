/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User.Model;

/**
 *
 * @author sujalkr.purbey
 */
public class User {
    private int id ;
    private String username;
    private String email;
    private String password;
    
    public User(String username, String email, String password){
        this.username =username;
        this.email =email;
        this.password =password;
        
        
    }
    public int getid(){
        return id;
        
    }
    public void setId(int id){
        this.id =id;
        
    }
    public String getEmail(){
        return email;
        
    }
    public void setEmail(String email){
        this.email =email; 
    }
    
}
