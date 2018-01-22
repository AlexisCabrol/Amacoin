/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Ethereum;

/**
 *
 * @author Alexis
 */
public interface EthereumDAO {
    Ethereum getWalletsETH(String email) throws DAOException;
    
}
