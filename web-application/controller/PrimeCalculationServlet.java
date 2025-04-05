/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Exceptions.InputException;
import model.PrimeDetector;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.List;

/**
 * Servlet responsible for handling prime number detection requests.
 * It extends PrimeServletBase and processes incoming HTTP requests
 * to determine prime numbers up to a given value.
 * @author Kamil Sobociński
 */
@WebServlet("/calculate")
public class PrimeCalculationServlet extends PrimeServletBase {
    /**
     * Processes incoming HTTP requests to detect prime numbers.
     * Validates the input, performs prime number detection,
     * and returns the result. If the input is invalid, an error
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
        String number = request.getParameter("number");
        try {
            if (detector.inputValidation(new String[]{number})) {
                List<Integer> primeNumbersList 
                        = detector.detectPrimeNumbersUnderN();
                displayer.displayCalculations(primeNumbersList, detector.getNNumber());
            }
        } catch (InputException ex) {
            response.sendError(response.SC_BAD_REQUEST, ex.toString());
        }

        Cookie cookie = new Cookie("lastEnteredNumber", number);
            response.addCookie(cookie);
    }
}
