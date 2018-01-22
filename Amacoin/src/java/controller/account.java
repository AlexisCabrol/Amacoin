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
import models.BitcoinDAO;
import models.DAO;
import models.EthereumDAO;
import models.LitecoinDAO;
import models.RippleDAO;

/**
 *
 * @author Alexis
 */
public class account extends HttpServlet {
    private static final String vue = "/WEB-INF/account.jsp";
    private static final String CONF_DAO = "dao";
    private static final String SESSION_EMAIL = "email";
    private BitcoinDAO bitcoinDAO;
    private LitecoinDAO litecoinDAO;
    private RippleDAO rippleDAO;
    private EthereumDAO ethereumDAO;
    
    public void init() throws ServletException {
        this.bitcoinDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getBitcoinDAO();
        this.ethereumDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getEthereumDAO();
        this.litecoinDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO)).getLitecoinDAO();
        this.rippleDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO)).getRippleDAO();
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Boolean log = session.getAttribute("log") != null ? (Boolean) session.getAttribute("log"):false;
        if(log == true) {
            Bitcoin wallet_btc = this.bitcoinDAO.getWalletsBTC((String) session.getAttribute(SESSION_EMAIL));
            request.setAttribute("wallet_btc",wallet_btc);
            Ripple wallet_xrp = this.rippleDAO.getWalletsXRP((String) session.getAttribute(SESSION_EMAIL));
            request.setAttribute("wallet_xrp",wallet_xrp);
            Ethereum wallet_eth = this.ethereumDAO.getWalletsETH((String) session.getAttribute(SESSION_EMAIL));
            request.setAttribute("wallet_eth",wallet_eth);
            Litecoin wallet_ltc = this.litecoinDAO.getWalletsLTC((String) session.getAttribute(SESSION_EMAIL));
            request.setAttribute("wallet_ltc",wallet_ltc);
            this.getServletContext().getRequestDispatcher(vue).forward(request,response); 
        }
        
    }
}