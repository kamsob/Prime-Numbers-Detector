/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Exceptions.InputException;
/**
 * class managing exceptions regarding input, contains requirements for the input
 * and run InputException function if they are not met
 * @author kamso
 */
public class InputType  {
    static public void isValid(String[] input) throws InputException 
    {
    if (!isInteger(input[0]))
        throw new InputException("Input number must be single Integer");
    if (input.length != 1)
        throw new InputException("The input must contain only 1 number.");
    }
    
    static private boolean isInteger(String enterNumber) {
    try {
        Integer.parseInt(enterNumber);
        return true;
    } catch (NumberFormatException e){
        return false;
    }
}
}

