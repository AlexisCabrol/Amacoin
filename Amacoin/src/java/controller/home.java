/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexis
 */
public class home extends HttpServlet {
    private RequestDispatcher rd;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        rd = getServletContext().getRequestDispatcher("/servlet/home");
        rd.forward(request,response);
    }
    
}