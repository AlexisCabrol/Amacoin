/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Ethereum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static models.DAOUtilitaire.fermeturesSilencieuses;
import static models.DAOUtilitaire.iniRequest;

/**
 *
 * @author Alexis
 */
public class EthereumDAOImpl implements EthereumDAO{
    private DAO dao;
    
    EthereumDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public Ethereum getWalletsETH(String email) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Ethereum eth = new Ethereum();
        String query = "select adresse_wallet, nombre, unit from eth b join users u on b.adresse_wallet = u.wallets_eth where email = ?";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn,query,false,email);
            rs = ps.executeQuery();
            if(rs.next()) {
                eth = map(rs);
            }
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(rs,ps,conn);
        }
        return eth;
    }
    
    private static Ethereum map(ResultSet rs) throws SQLException {
        Ethereum eth = new Ethereum();
        eth.setWallets(rs.getString("adresse_wallet"));
        eth.setNombre(rs.getFloat("nombre"));
        eth.setUnit(rs.getFloat("unit"));
        return eth;
    }
    
}
