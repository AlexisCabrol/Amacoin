/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Litecoin;

/**
 *
 * @author Alexis
 */
public interface LitecoinDAO {
    Litecoin getWalletsLTC(String email) throws DAOException;
    boolean ajoutLTCtoWallet(String adresse, int nombre) throws DAOException;
    boolean createWalletLTC(String adresse) throws DAOException;
    
}
