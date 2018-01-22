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
public class panier extends HttpServlet {
  private static final String vue = "/WEB-INF/panier.jsp";
  private static final String CHMP_IDCLIENT = "id";
  private static final String CONF_DAO = "dao";
  private PanierDAO panierDAO;
  
    @Override
    public void init() throws ServletException {
        this.panierDAO = ( (DAO) getServletContext().getAttribute( CONF_DAO )).getPanierDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // on regarde si le client possède déjà un panier
        int idPanier = this.panierDAO.existePanier((int) session.getAttribute(CHMP_IDCLIENT));
        if(idPanier != -1) {
            session.setAttribute("panier", true);
        } else {
            session.setAttribute("panier", false);
        }
        this.getServletContext().getRequestDispatcher(vue).forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
           
    }
}
