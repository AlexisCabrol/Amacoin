/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Ripple;

/**
 *
 * @author Alexis
 */
public interface RippleDAO {
    Ripple getWalletsXRP(String email) throws DAOException;
    boolean ajoutXRPtoWallet(String adresse, int nombre) throws DAOException;
    boolean createWalletXRP(String adresse) throws DAOException;
    
}
