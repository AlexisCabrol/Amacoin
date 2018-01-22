/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Bitcoin;

/**
 *
 * @author Alexis
 */
public interface BitcoinDAO {
    Bitcoin getWalletsBTC(String email) throws DAOException;
    boolean createWalletBTC(String adresse) throws DAOException;
    boolean ajoutBTCtoWallet(String adresse, int nombre) throws DAOException;
}
