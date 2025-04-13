/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe;
import java.util.regex.*;
/**
 *
 * @author RC_Student_lab
 */
public class Login {
    //declaration
   private String FirstName;
   private String LastName;
   private String userName;
   private String password;
   private String phoneNumber;
//setters for the variables
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
     
    
    
    //getters for the variables
    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
   //method that checks if the username meets the requirements
   public boolean CheckUsername(String username){
     
       return username.contains("_") && username.length()<=5;
   }
   //method that checks if the password meets the requirements 
   public boolean CheckPasswordComplesity(String password){
       return password.length()>=8 && password.matches(".*[A-Z] .*") && password.matches(".*[a-z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%&*?/].*");
   }
   //method that checks if phonenumber meets the requirements
   public boolean CheckPhonenumber(String Phonenumber){
      
       
       return Phonenumber.length()==12 && Phonenumber.startsWith("+27") && !Phonenumber.matches(".*[A-Z] .*") && !Phonenumber.matches(".*[a-z].*") && !Phonenumber.matches(".*[!@#$%&*?/].*");
   }
   //method checks if the user has registered successfully
   public String RegisterUser(String Username, String Password){
       if(CheckUsername(Username)&&CheckPasswordComplesity(Password)){
       return "The above conditions have been met, and you have been registered successfully"; 
       }else if(!CheckUsername(Username) && CheckPasswordComplesity(Password)){
        return "Username is not successfully captured";   
       }else{
           return "Password is not successfully captured";
       }
   }
   
   //Method that checks if the username and password entered are the same as the registered
   public boolean LoginUser(String LoginUsername,String LoginPassword){
        
       return LoginUsername.equals(this.userName) && LoginPassword.equals(this.password);
   }
   
   public String ReturnLoginStatus(boolean LoginUser){
       
       if(LoginUser){
           return "**********************\nLogin Successful\n**********************"+ "\nWelcome " + getFirstName() + " " +  getLastName();
       }else{
           return "Login unsuccessful";
       }
       
   }
           
         
}
