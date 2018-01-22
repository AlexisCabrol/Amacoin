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
import models.DAO;
import models.PanierDAO;

/**
 *
 * @author Alexis
 */
public class deletexrp extends HttpServlet {
  private static final String SESSION_BTC = "adress_btc";
  private static final String vue = "/WEB-INF/panier.jsp";
  private static final String CHMP_IDCLIENT = "id";
  private static final String CONF_DAO = "dao";
  private PanierDAO panierDAO;
    private int totalBTC = 0, totalETH = 0, totalXRP = 0, totalLTC = 0;


  
    @Override
    public void init() throws ServletException {
        this.panierDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getPanierDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // on regarde si le client possède déjà un panier
        int idPanier = (int) session.getAttribute("idPanier");
        this.panierDAO.viderPanierXRP(idPanier);
         totalBTC = this.panierDAO.recapPrixBTC(idPanier);
            totalETH = this.panierDAO.recapPrixETH(idPanier);
            totalXRP = this.panierDAO.recapPrixXRP(idPanier);
            totalLTC = this.panierDAO.recapPrixLTC(idPanier);
            request.setAttribute("totalBTC",totalBTC);
            request.setAttribute("totalETH",totalETH);
            request.setAttribute("totalXRP", totalXRP);
            request.setAttribute("totalLTC", totalLTC);
            request.setAttribute("total",totalBTC+totalETH+totalXRP+totalLTC);
        this.getServletContext().getRequestDispatcher(vue).forward(request,response);

    }


}
