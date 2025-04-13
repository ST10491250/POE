
package poe;
import java.util.Scanner;
public class POE {
    public static void main(String[] args) {
        // TODO code application logic here
        //Scanner object
        Scanner Swag = new Scanner (System.in);
        
        Login Sia = new Login ();
        //Prompting the user
        System.out.println("Welcome to Swag World");
        System.out.println("Enter your First Name>>");
        String FirstName = Swag.nextLine();
        Sia.setFirstName(FirstName);
        
        System.out.println("Enter your Last Name>>");
        String LastName = Swag.nextLine();
        Sia.setLastName(LastName);
        
        System.out.println("Enter your UserName>>");
        String UserName = Swag.nextLine();
        Sia.setUserName(UserName);
        
        //Checking is the username meets the requirements 
        if (Sia.CheckUsername(UserName)){
            System.out.println("Username succssefully entered");
        }else {
            System.out.println("Username is not succsseflly captured(Username must contain _, and must not be more than 5 letters)");
        }
        
        System.out.println("Enter your Password>>");
        String Password = Swag.nextLine();
        Sia.setPassword(Password);
        
        //Checking if the password meets the requirements 
        if (Sia.CheckPasswordComplesity(Password)){
            System.out.println("Password succssefully entered");
        }else{
            System.out.println("Password unsuccssefully entered(Password must contain Digits, Special characters, Uppercase and Length should be atleast 8 letters)");
        }
        
        System.out.println("Enter your Phonenumber>>");
        String Phonenumber = Swag.nextLine();
        Sia.setPhoneNumber(Phonenumber);
        
        //Checking if the Phonenumber meets the requirements
        if (Sia.CheckPhonenumber(Phonenumber)){
            System.out.println("Phonenumber succssefully entered");
        }else{
            System.out.println("Phonenumber unsuccssefully entered (Phonenumber must start with +27, must contain numbers only and must have 12 numbers)");
        }
        
        
        //calling the register method to check if the user has registered
        
       String register = Sia.RegisterUser(UserName, Password);
        System.out.println("Message:  " + register);
        
        //Prompting the user to Login
        System.out.println("***************************\n Login \n***************************");
        
        System.out.println("Enter Username>>");
        String LoginUsername = Swag.nextLine();
        
        System.out.println("Enter Password>>");
        String LoginPassword = Swag.nextLine();
        
        boolean isLogin = Sia.LoginUser(LoginUsername, LoginPassword);
        String LoginMessage = Sia.ReturnLoginStatus(isLogin);
        
        if(isLogin){
            System.out.println(LoginMessage);
        }else{
            System.out.println("Login unsuccessful");
        }
    }
    
    
    
}
