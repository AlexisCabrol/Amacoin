/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.DAO;
import models.UsersDAO;

/**
 *
 * @author Alexis
 */
public class login extends HttpServlet {
    private static final String CONF_DAO = "dao";
    private static final String vue = "/WEB-INF/login.jsp";
    private static final String vue_home = "/WEB-INF/home.jsp";
    private UsersDAO userDAO;
    
    @Override
    public void init() throws ServletException {
        this.userDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getUsersDAO();
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Boolean log = session.getAttribute("log") != null ? (Boolean) session.getAttribute("log"):false;
        
        if(log == true) {
            session.invalidate();
            this.getServletContext().getRequestDispatcher(vue_home).forward(request,response);
        } else {
            this.getServletContext().getRequestDispatcher(vue).forward(request,response);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Boolean log = session.getAttribute("log") != null ? (Boolean) session.getAttribute("log"):false;
        
        if(log == true) {
            this.getServletContext().getRequestDispatcher(vue_home).forward(request,response);
        } else {
            // On regarde dans la bd
            Users user = this.userDAO.getUsers(request.getParameter("email"), request.getParameter("pwd"));
            if(user != null && user.getPassword().equals(request.getParameter("pwd"))) {
                session.setAttribute("email",request.getParameter("email"));
                session.setAttribute("id",user.getId());
                session.setAttribute("log",true);
                session.setAttribute("adress_btc",user.getWallets_bts());
                session.setAttribute("adress_eth",user.getWallets_eth());
                session.setAttribute("adress_xrp", user.getWallets_xrp());
                session.setAttribute("adress_ltc", user.getWallets_ltc());
                log = true;
            
            } else {
                request.setAttribute("error", "Erreur dans l'identification");
            }
        }
        
        if(log == true) {
            this.getServletContext().getRequestDispatcher(vue_home).forward(request,response);
        } else {
            this.getServletContext().getRequestDispatcher(vue).forward(request,response);
        }
    }
    

}
