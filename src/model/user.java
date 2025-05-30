/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class user {
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private boolean is_verified = false;
    private String verificationToken;

    public user(String email, String password, String firstname, String lastname, Boolean is_verified, String verificationToken ){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.is_verified = is_verified;
        this.verificationToken = verificationToken;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getFirstName(){
        return firstname;
    }
    public void setFirstName(String firstname){
        this.firstname = firstname;
    }

    public String getLastName(){
        return lastname;
    }
    public void setLastName(String lastname){
        this.lastname = lastname;
    }

    public boolean getis_verified(){
        return is_verified;
    }
    public void setis_verified(boolean is_verified){
        this.is_verified = is_verified;
    }

    public String getVerificationToken(){
        return verificationToken;
    }
    public void setVerificationToken(String verificationToken){
        this.verificationToken = verificationToken;
    }

    public void setVerified(boolean _verified) {
       this.is_verified = _verified; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}