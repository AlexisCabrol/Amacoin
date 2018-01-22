/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;

/**
 *
 * @author Alexis
 */
public interface PanierDAO {
    boolean viderPanierBTC(int idPanier) throws DAOException;
    boolean viderPanierETH(int idPanier) throws DAOException;
    boolean viderPanierXRP(int idPanier) throws DAOException;
    boolean viderPanierLTC(int idPanier) throws DAOException;
    boolean insertPanierLTC(int idPanier, int nombre) throws DAOException;
    boolean insertPanierETH(int idPanier, int nombre) throws DAOException;
    boolean insertPanierXRP(int idPanier, int nombre) throws DAOException;
    boolean insertPanierBTC(int idPanier, int nombre) throws DAOException;
    boolean paiement(int idPanier, int total) throws DAOException;
    boolean remiseAZeoPanier(int idPanier) throws DAOException;
    boolean createPanier(int idClient) throws DAOException;
    int existePanier(int idClient) throws DAOException;
    int nombreBTCPanier(int idPanier) throws DAOException;
    int nombreETHPanier(int idPanier) throws DAOException;
    int nombreLTCPanier(int idPanier) throws DAOException;
    int nombreXRPPanier(int idPanier) throws DAOException;
    int recapPrixBTC(int idPanier) throws DAOException;
    int recapPrixETH(int idPanier) throws DAOException;
    int recapPrixLTC(int idPanier) throws DAOException;
    int recapPrixXRP(int idPanier) throws DAOException;
    int recapPrixTotal(int idPanier) throws DAOException;
    
}
