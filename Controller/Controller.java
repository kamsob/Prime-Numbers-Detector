/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.SwingGUI;
import Exceptions.InputException;
import Model.PrimeDetector;
import Model.InputType;
import View.Displayer;
import java.util.Arrays;
/**
 * Class containing method controller which manages the program
 * @author Kamil Sobocinski
 */
public class Controller {
    SwingGUI gui;
    
    public Controller(SwingGUI gui){
        this.gui = gui;
    }
    /**
     * function that manages the program
     * @param enterPhrase 
     */
    public void controller(String enterPhrase[]){
        try {
            gui.setUpTree();
            gui.setJLabel1("");
            InputType.isValid(enterPhrase);
            // Parse input to integer and create a PrimeDetector instance
            int number = Integer.parseInt(enterPhrase[0]);
            PrimeDetector primeDetector = new PrimeDetector(number);
            gui.displayResultInATree(primeDetector.getPrimes(), number);
            // Get and display the prime numbers
//            String primeNumbers = Arrays.toString(primeDetector.getPrimes());
//            gui.setJLabel1(primeNumbers);
            
        } catch (InputException e) {
            gui.setJLabel1("Error: " + e.getMessage());  // Display error in GUI
        }
    }    
}
