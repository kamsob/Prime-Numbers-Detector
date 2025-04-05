/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

import View.Displayer;

/**
 * Exception class extension that throw exception message for invalid input
 * @author Kamil Sobocinski
 */
public class InputException extends Exception {
    /**
     * Exception that is thrown if the input does not met requirements
     * @param message exception message shown to the user
     */
    public InputException(String message) {
        super(message);
    }
}
