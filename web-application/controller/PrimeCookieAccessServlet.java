/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet responsible for handling cookies.
 * It extends PrimeServletBase and processes incoming HTTP requests
 * to cookies with information of last calculated number.
 * @author Kamil Sobociński
 */
@WebServlet("/CookieAccess")
public class PrimeCookieAccessServlet extends PrimeServletBase {
    
    /**
    * Processes incoming HTTP requests to get saved cookies.
    * Displays all cookies with name "lastEnteredNumber",
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
        
        Cookie[] cookies = request.getCookies();
        String lastEnteredNumber = "None";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastEnteredNumber")) {
                    lastEnteredNumber = cookie.getValue();
                    break;
                }
            }
        }

        // Poprawne ustawienie odpowiedzi
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h2>Last Calculated Number: " + lastEnteredNumber + "</h2>");
            out.println("</body></html>");
        }
    }   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}