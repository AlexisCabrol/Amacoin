/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Litecoin;
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
public class LitecoinDAOImpl implements LitecoinDAO {
    private DAO dao;

    LitecoinDAOImpl(DAO dao) {
        this.dao = dao;
    }
    
    @Override
    public Litecoin getWalletsLTC(String email) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Litecoin ltc = new Litecoin();
        String query = "select adresse_wallet, nombre, unit from ltc b join users u on b.adresse_wallet = u.wallets_ltc where email = ?";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn,query,false,email);
            rs = ps.executeQuery();
            if(rs.next()) {
                ltc = map(rs);
            }
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(rs,ps,conn);
        }
        return ltc;
    }
    
    private static Litecoin map(ResultSet rs) throws SQLException {
        Litecoin ltc = new Litecoin();
        ltc.setWallets(rs.getString("adresse_wallet"));
        ltc.setNombre(rs.getFloat("nombre"));
        ltc.setUnit(rs.getFloat("unit"));
        return ltc;
    }
    
}
