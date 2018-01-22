/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import models.PanierDAO;
import models.RippleDAO;

/**
 *
 * @author Alexis
 */
public class panier extends HttpServlet {
  private static final String SESSION_BTC = "adress_btc";
  private static final String SESSION_ETH = "adress_eth";
  private static final String SESSION_LTC = "adress_ltc";
  private static final String SESSION_XRP = "adress_xrp";
  private static final String vue_redirection = "/WEB-INF/paiement.jsp";
  private static final String vue = "/WEB-INF/panier.jsp";
  private static final String CHMP_IDCLIENT = "id";
  private static final String CONF_DAO = "dao";
  private PanierDAO panierDAO;
  private BitcoinDAO bitcoinDAO;
  private EthereumDAO ethereumDAO;
  private RippleDAO rippleDAO;
  private LitecoinDAO litecoinDAO;
  private int totalBTC = 0, totalETH = 0, totalXRP = 0, totalLTC = 0, nombreBTC = 0, nombreETH = 0, nombreXRP = 0, nombreLTC = 0;
  
    @Override
    public void init() throws ServletException {
        this.panierDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getPanierDAO();
        this.rippleDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getRippleDAO();
        this.bitcoinDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getBitcoinDAO();
        this.ethereumDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getEthereumDAO();
        this.litecoinDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getLitecoinDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // on regarde si le client possède déjà un panier
        int idPanier = this.panierDAO.existePanier((int) session.getAttribute(CHMP_IDCLIENT));
        if(idPanier != -1) {
            session.setAttribute("idPanier",idPanier);
            session.setAttribute("panier", true);
            totalBTC = this.panierDAO.recapPrixBTC(idPanier);
            totalETH = this.panierDAO.recapPrixETH(idPanier);
            totalXRP = this.panierDAO.recapPrixXRP(idPanier);
            totalLTC = this.panierDAO.recapPrixLTC(idPanier);
            request.setAttribute("totalBTC",totalBTC);
            request.setAttribute("totalETH",totalETH);
            request.setAttribute("totalXRP", totalXRP);
            request.setAttribute("totalLTC", totalLTC);
            request.setAttribute("total",totalBTC+totalETH+totalXRP+totalLTC);
        } else {
            session.setAttribute("panier", false);
        }
        this.getServletContext().getRequestDispatcher(vue).forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idPanier = (int) session.getAttribute("idPanier");
        int prixTotal = this.panierDAO.recapPrixTotal(idPanier);
        nombreBTC = this.panierDAO.nombreBTCPanier(idPanier);
        nombreXRP = this.panierDAO.nombreXRPPanier(idPanier);
        nombreLTC = this.panierDAO.nombreLTCPanier(idPanier);
        nombreETH = this.panierDAO.nombreETHPanier(idPanier);
        if(nombreBTC > 0)
            this.bitcoinDAO.ajoutBTCtoWallet((String) session.getAttribute(SESSION_BTC), nombreBTC);
        else if(nombreXRP > 0)
            this.rippleDAO.ajoutXRPtoWallet((String) session.getAttribute(SESSION_XRP), nombreXRP);
        else if(nombreLTC > 0)
            this.litecoinDAO.ajoutLTCtoWallet((String) session.getAttribute(SESSION_LTC), nombreLTC);
        else if(nombreETH > 0)
            this.ethereumDAO.ajoutETHtoWallet((String) session.getAttribute(SESSION_ETH), nombreETH);
        boolean remiseAZero = this.panierDAO.remiseAZeoPanier(idPanier);
        boolean paiement = this.panierDAO.paiement(idPanier, prixTotal);
        if(paiement)
            request.setAttribute("paiement", true);
        else
            request.setAttribute("paiement", false);
        this.getServletContext().getRequestDispatcher(vue_redirection).forward(request,response);
           
    }
}
