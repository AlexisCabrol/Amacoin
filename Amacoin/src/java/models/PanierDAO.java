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
    boolean insertPanierLTC(int idPanier, int nombre) throws DAOException;
    boolean insertPanierETH(int idPanier, int nombre) throws DAOException;
    boolean insertPanierXRP(int idPanier, int nombre) throws DAOException;
    boolean insertPanierBTC(int idPanier, int nombre) throws DAOException;
    boolean createPanier(int idClient) throws DAOException;
    int existePanier(int idClient) throws DAOException;
    
}
