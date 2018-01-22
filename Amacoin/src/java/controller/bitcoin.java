/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class bitcoin extends HttpServlet {
    private static final String CHMP_NOMBRE = "nombre";
    private static final String CHMP_IDCLIENT = "id";
    private static final String CONF_DAO = "dao";
    private static final String vue = "/WEB-INF/bitcoin.jsp";
    private PanierDAO panierDAO;
    
    @Override
    public void init() throws ServletException {
        this.panierDAO = ((DAO) getServletContext().getAttribute(CONF_DAO)).getPanierDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(vue).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        Verfier qu'un panier existe ou pas
            - si il existe pas le crée
            - sinon recup l'id du panier
        Ensuite juste insert dans details
        */
        HttpSession session = request.getSession();
        int idPanier = this.panierDAO.existePanier((int) session.getAttribute(CHMP_IDCLIENT));
        if(idPanier == -1) {
            boolean create = this.panierDAO.createPanier((int) session.getAttribute(CHMP_IDCLIENT));
            idPanier = this.panierDAO.existePanier((int) session.getAttribute(CHMP_IDCLIENT));
        }
        int nombre = Integer.parseInt(request.getParameter(CHMP_NOMBRE));
        boolean insert = this.panierDAO.insertPanierBTC(idPanier,nombre);
        if(insert)
            request.setAttribute("insert", insert);
        else
            request.setAttribute("insert", insert);
        
        this.getServletContext().getRequestDispatcher(vue).forward(request,response);
        
           
    }



}
