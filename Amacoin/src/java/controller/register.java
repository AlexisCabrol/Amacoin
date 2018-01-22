/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Users;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.BitcoinDAO;
import models.DAO;
import models.EthereumDAO;
import models.LitecoinDAO;
import models.RippleDAO;
import models.UsersDAO;


/**
 *
 * @author Alexis
 */
public class register extends HttpServlet {
    private static final String CONF_DAO = "dao";
    private static final String vue_succes = "/WEB-INF/login.jsp";
    private static final String vue = "/WEB-INF/register.jsp";
    private UsersDAO userDAO;
    private BitcoinDAO bitcoinDAO;
    private LitecoinDAO litecoinDAO;
    private RippleDAO rippleDAO;
    private EthereumDAO ethereumDAO;
    
    public void init() throws ServletException {
        // Récupération d'une isntance de notre DAO User
        this.userDAO = ( (DAO) getServletContext().getAttribute(CONF_DAO)).getUsersDAO();
        this.rippleDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getRippleDAO();
        this.bitcoinDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getBitcoinDAO();
        this.ethereumDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getEthereumDAO();
        this.litecoinDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getLitecoinDAO();
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.getServletContext().getRequestDispatcher(vue).forward(request,response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("pwd").equals(request.getParameter("confirmation"))) {
                    boolean verif = this.userDAO.findUser(request.getParameter("email"));
        if(!verif) {
            boolean register = this.userDAO.inscription(request.getParameter("email"),request.getParameter("pwd"),request.getParameter("confirmation"));
            if(register) {
                Users user = this.userDAO.findWallet(request.getParameter("email"));
                this.bitcoinDAO.createWalletBTC(user.getWallets_bts());
                this.ethereumDAO.createWalletETH(user.getWallets_eth());
                this.litecoinDAO.createWalletLTC(user.getWallets_ltc());
                this.rippleDAO.createWalletXRP(user.getWallets_xrp());
                this.getServletContext().getRequestDispatcher(vue_succes).forward(request,response);
                
            }
        }

        } else {
            request.setAttribute("error","Erreur dans l'incription");
            this.getServletContext().getRequestDispatcher(vue).forward(request,response);
        }


        
        
 
    }

}
