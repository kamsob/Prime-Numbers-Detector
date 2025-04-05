/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.*;
import java.io.PrintWriter;
import java.util.List;
import lombok.*;
/**
 * Handles the display of HTML-formatted output for prime number calculations,
 * history of previous calculations, and system information.
 * 
 * This class utilizes a {@link PrintWriter} to send formatted HTML responses.
 * It includes methods for displaying prime numbers, calculation history, 
 * and general information messages.
 * 
 * Uses Lombok annotations {@code @NoArgsConstructor}, {@code @Getter}, 
 * and {@code @Setter} to simplify boilerplate code.
 * 
 * @author Kamil Sobociński
 */
@NoArgsConstructor
@Setter
@Getter
public class Displayer {
    private PrintWriter output;
     
    /**
     * Displays a list of prime numbers up to a given number in an HTML format.
     *
     * @param list   the list of prime numbers to display
     * @param number the upper limit for the prime number calculation
     */
    public void displayCalculations(List<Integer> list, int number)
    {
        output.println("<html><body>");
        output.println("<h2>Prime numbers under " + number + ":</h2>");
        output.println("<ul>");
        
        for (Integer prime : list)
            output.println("<li>" + prime + "</li>");
        
        output.println("</ul>");
        output.println("</body></html>");
    }
    
    /**
     * Displays the history of previous prime number calculations in an HTML format.
     *
     * @param list the list of previously calculated prime numbers
     */
    public void displayHistory(List<Integer> list)
    {
        output.println("<html><body>");
        output.println("<h2>History of calculations:</h2>");
        output.println("<ul>");
        
        for (Integer historyItem : list)
            output.println("<li>" + historyItem + "</li>");
        
        output.println("</ul>");
        output.println("</body></html>");        
    }
    
    
    /**
     * Displays general system information in an HTML format.
     *
     * @param information the message or information to display
     */
    public void displayInformation(String information){
        output.println("<html><body>");
        output.println("<h2>System Information:</h2>");
        output.println("<ul>");
        
        output.println(information);
        
        output.println("</ul>");
        output.println("</body></html>");   
    }
}
