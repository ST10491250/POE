
package poe;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
public class POE {
    public static void main(String[] args) {
        // TODO code application logic here
        //Scanner object
        JDialog window = new JDialog();
        window.setAlwaysOnTop(true);
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
         //part 2 starts only when the uuser has logged successfully  
         JOptionPane.showMessageDialog(null, "-----------------------------\nWelcome To QuickChat \n-----------------------------"  );
             //declaring
        int Menu=0;
        
         
         while(Menu !=3){
         Menu = Integer.parseInt(JOptionPane.showInputDialog("Please choose an option from 1-3: \n1:Send Messages \n2:Show recently sent Messages \n3:Exit Application"));
        
         
         switch(Menu){
             case 1:
                 
           Message message = new Message ();
        int num_of_tasks = Integer.parseInt(JOptionPane.showInputDialog("How many messages do you want to send: "));
        
        
        //declaring arrays to store variables
        String [] recipient = new String [num_of_tasks];
        String [] Message_Id = new String [num_of_tasks];
        String [] UserMessages = new String [num_of_tasks];
        String [] Message_Hash = new String [num_of_tasks];
        String [] Message_Options = new String [num_of_tasks];
        
        //accumulator
        int total=  0;
        int CheckNum=0;
        //for loop that will iterate based on the user input
        
        for(int Messagecount =0; Messagecount <num_of_tasks ;Messagecount++){
            
            do{
            recipient [Messagecount] =JOptionPane.showInputDialog("Please enter the cell number:");
            CheckNum=message.checkRecipientCell( recipient [Messagecount]);
            
            if(CheckNum==0){
                 JOptionPane.showMessageDialog(null, "Invalid recipient num " );
            }
            }while(CheckNum==0);
            do{
            UserMessages [Messagecount] = JOptionPane.showInputDialog("Please enter your message: ");
            }while(!message.CheckMessageComplexity(UserMessages [Messagecount]));
            
            Message_Id [Messagecount] = message.CreateRandomMessageID();
            JOptionPane.showMessageDialog(null, "Message Id: \n"  + Message_Id[Messagecount]);
            
            
            Message_Hash [Messagecount] = message.generateMessageHash(Message_Id[Messagecount], Messagecount, UserMessages[Messagecount]);
             JOptionPane.showMessageDialog(null, "Message Hash for mesage \n" +   Message_Hash[Messagecount]);
            
            Message_Options[Messagecount]= message.SendMessage(Message_Id[Messagecount],  UserMessages[Messagecount], Message_Hash [Messagecount],   
            recipient [Messagecount]);
            
            total +=Messagecount;
                         
        }
         JOptionPane.showMessageDialog(null, "The total number of messages sent " + total);
        
                 break;
             case 2:
                 JOptionPane.showMessageDialog(null, "--------------------------\nComing Soon\n--------------------------");
                 break;
             case 3:
                 
                 JOptionPane.showMessageDialog(null, "Thank you hope you had a nice experience. \nGoodbye!!");
                 
                 break;
                 
             default:
                 JOptionPane.showMessageDialog(null, "Invalid option, please choose an option (1-3)");
                 
                 break;
         }
         }
        }else{
            System.out.println("Login unsuccessful");
        }
    }
    
    
    
}
