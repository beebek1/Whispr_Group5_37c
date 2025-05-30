
package Model;

/**
 *
 * @author bibek
 */
public class UserModel {
    private int id;
   
    private String firstname;
    private String lastname;
     private String email;
    private String password;
    private Boolean isverified;
   
    public UserModel(String firstname,String lastname,String email,String password, Boolean isverified){
     this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
    this.isverified = isverified;
    }
     public String getFirstname(){
        return firstname;
    }
        public void setFirstname(String firstname){
        this.firstname=firstname;
    }
     public String getLastname(){
        return lastname;
    }
        public void setLastname(String lastname){
        this.lastname=lastname;
    }
    public String getEmail(){
        return email;
    }
        public void setEmail(String email){
        this.email=email;
    }
            public String getPassword(){
        return password;
    }
        public void setPassword(String password){
        this.password=password;
    }
        public Boolean isVerified(){
        return isverified;
    }
        public void setisVerified(Boolean isverified){
        this.isverified=isverified;
    }
        public int getId(){
        return id;
    }
        public void setId(Integer id){
        this.id= id;
        }
}

