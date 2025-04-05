/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.zadanie7;

import Exceptions.InputException;
import View.SwingGUI;
import Controller.Controller;
/**
 * @author Kamil Sobocinski
 * starting class with main function
 */
public class Zadanie7 {

    /**
     * function check args if there is exception and start running GUI window
     * @param args command line arguments, user is expected to put here integer number N
     * till which prime numbers will be displayed by the program
     */
    public static void main(String[] args) throws InputException {
            SwingGUI gui = new SwingGUI();
            gui.setJTextField(args[0]);
                java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui.setVisible(true);
                gui.setUpTree();
                try {
                    Model.InputType.isValid(args);
                }   catch (InputException e) {
                    gui.setJLabel1("Error: " + e.getMessage());
                }
            }
        });
    }
}
