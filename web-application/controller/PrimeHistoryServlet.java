/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Exceptions.InputException;
import view.Displayer;
import model.PrimeDetector;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet responsible for handling prime numbers history.
 * It extends PrimeServletBase and processes incoming HTTP requests
 * to display all detected prime numbers in the detector.
 * @author Kamil Sobociński
 */
@WebServlet("/history")
public class PrimeHistoryServlet extends PrimeServletBase {
    
    /**
     * Processes incoming HTTP requests to get history of detected prime numbers,
     * gets history of detected in PrimeDetector object, 
     * and if there are no numbers detected yet information is sent.
     * response is sent.
     *
     * @param request  the HttpServletRequest object containing the client's request
     * @param response the HttpServletResponse object for sending the response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an input or output error is detected
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(detector.getDetectedPrimesHistory() == null)
            displayer.displayInformation("There are no detected number yet. You need to run Prime numbers detection");
        else displayer.displayHistory(
                detector.getDetectedPrimesHistory());
        
    }
}
