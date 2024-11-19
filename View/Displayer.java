/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.JOptionPane;

/**
 * Class containing all messeges and communication with the user
 * which can be displayed in the console
 * @author Kamil Sobocinski
 */
public class Displayer {
    private static final String enterPhrase[] = new String[1];//1 element array of strings that contains string uploaded by the user
    
    /**
    *function that displays prime numbers
    *@param primeNumbers prime numbers array converted to string
    **/
    static public void displayPrimeNumbers(String primeNumbers)
    {
        JOptionPane.showMessageDialog(null, "Prime numbers under "+ enterPhrase[0] + ": "+ primeNumbers, 
            "Result Message", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
    *function that takes input from the user and upload 1 element array enterPhrase
    *@return 1 element array with input from user
    */
    static public String[] getInputFromUser()
    {
        enterPhrase[0] = JOptionPane.showInputDialog(null, "Enter number N: ", 
            "enterNumber", JOptionPane.QUESTION_MESSAGE);
        return enterPhrase;
    }
    
    /*
    *function that display error that input is incorrect
    */
    static public void wrongInputErrorMessage()
    {
        JOptionPane.showMessageDialog(null, "Please enter single natural number!", 
                "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
    }
}
