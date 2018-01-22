/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Bitcoin;
import beans.Ethereum;
import beans.Litecoin;
import beans.Ripple;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.DAO;

/**
 *
 * @author Alexis
 */
public class paiement extends HttpServlet {
    private static final String vue = "/WEB-INF/paiement.jsp";
    public void init() throws ServletException {

        
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            this.getServletContext().getRequestDispatcher(vue).forward(request,response); 
        }
        
    }

