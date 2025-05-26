/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe;
import java.io.File;
import java.util.HashSet;
import java.util.Random;
import javax.swing.JOptionPane;

import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class Message {
  
    
     public String SendMessage(String MessageId, String Message, String MessageHash, String recepient) {
       //a value returning function  
       
         String[] StoreOptions ={"Send Message", "Disregard Message","Store Message to send Later"};
         
        int Sendoptions=JOptionPane.showOptionDialog(
                null, 
                "Please select an option", "Status options", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, StoreOptions, 0);
                  
        String task = StoreOptions[Sendoptions];
        //instead of using a switch i opt for a if statement
               if(Sendoptions==0){
                  
                   JOptionPane.showMessageDialog(null, "Message is sent successfully");
                  String display = DisplayMessage(MessageId,Message,MessageHash,recepient);
                  JOptionPane.showMessageDialog(null, display);
               }else if(Sendoptions==1){
                    JOptionPane.showMessageDialog(null, "Message is disregarded");
               }else if(Sendoptions==2){
                
                StoreUserMessages(MessageId,Message,MessageHash,recepient);
                JOptionPane.showMessageDialog(null, "Message is successfully stored");   
               }
        
        return task;
    }
 
    //created a method that creates 10 random numbers
   public String CreateRandomMessageID() {
    Random rand = new Random();
    StringBuilder build = new StringBuilder();
    
    //using a for loop to generate 10 numbers
    for (int i = 0; i < 10; i++) {
        int digit = rand.nextInt(10); // Random digit from 0–9
        build.append(digit);
    }

    return build.toString();
}
   //a method that checks if the MessageId length is valid or not
   public boolean CheckMessageIDLength(String messageID) {
    boolean isValid = messageID.length() == 10;

    if (isValid) {
        JOptionPane.showMessageDialog(null, "Message ID is valid.\nMessage Id" + messageID);
    } else {
        JOptionPane.showMessageDialog(null, "Invalid Message ID. It must be exactly 10 digits.");
    }

    return isValid;
}
//created a method that generatesa message hash
public String generateMessageHash(String messageID, int messageNumber, String message) {
    // storing the First 2 characters of MessageID
    String prefix = messageID.substring(0, 2); 

    // Split the message into words
    String[] words = message.trim().split("\\s+");
    //storing the first word into as the first element of an array
    String firstWord = words[0];
    String lastWord = words[words.length - 1];

    // Build the hash
    String messageHash = (prefix + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();

    return messageHash;
}


    public boolean CheckMessageComplexity(String Message){
    boolean validate=false;
    
    if(Message.length()<=50){
       JOptionPane.showMessageDialog(null,"Message is successfully captured: "); 
       validate =true;
    }else{
        
       JOptionPane.showMessageDialog(null,"Message is not successfully captured, please ensure that the message does not exceed 50 characters: ");   
        validate =false;
    }
    
    return validate;
    }
   public String DisplayMessage(String messageId, String message, String messageHash, String recipient) {
    String display =
            "=========================\n" +
            "      Message Details    \n" +
            "=========================\n" +
            "Message ID     : " + messageId + "\n" +
            "Message Hash   : " + messageHash + "\n" +
            "Recipient No.  : " + recipient + "\n" +
            "User Message   : " + message + "\n" +
            "=========================";

    return display;
}

    
   
   public void StoreUserMessages(String messageId, String message, String messageHash, String recipient) {
    String fileLocation = "StoreMessage.json";

    // Create the file if it doesn't exist
    File file = new File(fileLocation);
    try {
        if (!file.exists()) {
            file.createNewFile(); 
            
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error creating file: " + e.getMessage());
        return;
    }

    // Prepare the JSON message object
    JSONObject json = new JSONObject();
    json.put("MessageID", messageId);
    json.put("MessageHash", messageHash);
    json.put("Message", message);
    json.put("Recipient", recipient);

    // Append the JSON object as a single line (newline-delimited)
    try (FileWriter writer = new FileWriter(file, true)) {
        writer.write(json.toString());
        writer.write(System.lineSeparator()); // add newline
        JOptionPane.showMessageDialog(null, "Message stored successfully in file.");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage());
    }
}
   
    //method that validates the recipient number
   public int checkRecipientCell(String phone_number) {
    boolean isValid = phone_number != null 
                      && phone_number.length() == 12 
                      && phone_number.startsWith("+27") 
                      && !phone_number.matches(".*[A-Za-z!@#$%^&*().].*");

    if (isValid) {
        return 1;
    } else {
        return 0;
    }
}
}
