/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package poe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
   

    /**
     * Test of CheckUsername method, of class Login.
     */
    @Test
    public void testCheckUsernameTest1() {
        System.out.println("CheckUsername");
        String username = "kyl_1";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.CheckUsername(username);
        assertEquals(expResult, result);
  
       
    }
    
    @Test
    public void testCheckUsernameTest2() {
        System.out.println("CheckUsername");
        String username = "kyle!!!!!!!!!!";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.CheckUsername(username);
        assertEquals(expResult, result);
  
       
    }

    /**
     * Test of CheckPasswordComplesity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplesityTest1() {
        System.out.println("CheckPasswordComplesity");
        String password = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.CheckPasswordComplesity(password);
        assertEquals(expResult, result);
        
    }
    
     @Test
    public void testCheckPasswordComplesityTest2() {
        System.out.println("CheckPasswordComplesity");
        String password = "password";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.CheckPasswordComplesity(password);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of CheckPhonenumber method, of class Login.
     */
    @Test
    public void testCheckPhonenumberTest1() {
        System.out.println("CheckPhonenumber");
        String Phonenumber = "+27838968976";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.CheckPhonenumber(Phonenumber);
        assertEquals(expResult, result);
        
    }
    
    public void testCheckPhonenumberTest2() {
        System.out.println("CheckPhonenumber");
        String Phonenumber = "08966553";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.CheckPhonenumber(Phonenumber);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of RegisterUser method, of class Login.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("RegisterUser");
        String Username = "";
        String Password = "";
        Login instance = new Login();
        String expResult = "";
        String result = instance.RegisterUser(Username, Password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of LoginUser method, of class Login.
     */
    @Test
    public void testLoginUser() {
        System.out.println("LoginUser");
        String LoginUsername = "";
        String LoginPassword = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.LoginUser(LoginUsername, LoginPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ReturnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("ReturnLoginStatus");
        boolean LoginUser = false;
        Login instance = new Login();
        String expResult = "";
        String result = instance.ReturnLoginStatus(LoginUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
