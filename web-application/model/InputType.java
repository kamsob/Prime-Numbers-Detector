/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Exceptions.InputException;
import lombok.Getter;

/**
 * Record managing exceptions regarding input, contains requirements for the input
 * and run InputException function if they are not met
 * @author Kamil Sobocinski
 */
@Getter
public class InputType {

    private String validatedInput;
    
    /**
     * function checking if input is in correct format and throwing exception if it isn't
     * @param input user String input
     * @throws InputException throws given exception information 
     */
    public InputType (String[] input) throws InputException 
    {
    if (input[0] == "")
        throw new InputException("You have to pass the number.");
    else if (!isInteger(input[0]))
        throw new InputException("Input number must be single Integer.");
    else if(input.length != 1)
        throw new InputException("Detector can process only 1 number at once");
    validatedInput = input[0];
    }
    
    /**
     * function checking if String is convertable to int
     * @param enterNumber number in string type
     * @return true if enterNumber is convertable to int and false if it isn't
     */
    static private boolean isInteger(String enterNumber) {
    try {
        Integer.parseInt(enterNumber);
        return true;
    } catch (NumberFormatException e){
        return false;
    }
}
}

