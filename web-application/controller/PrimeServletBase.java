package controller;

import jakarta.inject.Inject;
import model.PrimeDetector;
import view.Displayer;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

/**
 * Abstract base class for servlets handling prime number detection.
 * It extends {@code HttpServlet} and provides a common framework 
 * for processing HTTP GET and POST requests.
 * 
 * This class initializes shared instances of {@code PrimeDetector} and 
 * {@code Displayer} for use in subclasses. It defines an abstract method 
 * {@code processRequest} that must be implemented by subclasses to 
 * process client requests.
 * 
 * @author Kamil Sobociński
 */
public abstract class PrimeServletBase extends HttpServlet {
    
    protected static final PrimeDetector detector = new PrimeDetector();
    
    protected final Displayer displayer = new Displayer();
    
     /**
     * Abstract method that must be implemented by subclasses to process
     * HTTP requests.
     *
     * @param request  the HttpServletRequest object containing the client's request
     * @param response the HttpServletResponse object for sending the response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an input or output error occurs
     */
    protected abstract void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
    /**
     * Handles HTTP GET requests by setting the response content type,
     * initializing the {@code Displayer} output stream, and delegating
     * processing to {@code processRequest}.
     *
     * @param request  the HttpServletRequest object containing the client's request
     * @param response the HttpServletResponse object for sending the response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an input or output error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=ISO-8859-2");
        displayer.setOutput(response.getWriter());
        processRequest(request, response);
    }

    /**
     * Handles HTTP POST requests by setting the response content type,
     * initializing the {@code Displayer} output stream, and delegating
     * processing to {@code processRequest}.
     *
     * @param request  the HttpServletRequest object containing the client's request
     * @param response the HttpServletResponse object for sending the response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an input or output error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=ISO-8859-2");
        displayer.setOutput(response.getWriter());
        processRequest(request, response);
    }
}