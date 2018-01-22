/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Ripple;
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
public class RippleDAOImpl implements RippleDAO{
        private DAO dao;
    
    RippleDAOImpl(DAO dao) {
        this.dao = dao;
    }

    private static Ripple map(ResultSet rs) throws SQLException {
        Ripple xrp = new Ripple();
        xrp.setWallets(rs.getString("adresse_wallet"));
        xrp.setNombre(rs.getFloat("nombre"));
        xrp.setUnit(rs.getFloat("unit"));
        return xrp;
    }

    @Override
    public Ripple getWalletsXRP(String email) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Ripple xrp = new Ripple();
        String query = "select adresse_wallet, nombre, unit from xrp b join users u on b.adresse_wallet = u.wallets_xrp where email = ?";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn,query,false,email);
            rs = ps.executeQuery();
            if(rs.next()) {
                return map(rs);
            }
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(rs,ps,conn);
        }
        return xrp;
    }

    @Override
    public boolean ajoutXRPtoWallet(String adresse, int nombre) throws DAOException {
        String query = "update xrp set nombre = nombre+? where adresse_wallet = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        int nbligne = 0;
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, nombre,adresse);
            nbligne = ps.executeUpdate();
            if(nbligne == 1)
                return true;
            else
                return false;
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(ps,conn);
        }
    }

    @Override
    public boolean createWalletXRP(String adresse) throws DAOException {
        String query = "insert into xrp values (?,0,2)";
        Connection conn = null;
        PreparedStatement ps = null;
        int nbligne = 0;
        
        try {
           conn = dao.getConnection();
           ps = iniRequest(conn, query, false, adresse);
           nbligne = ps.executeUpdate();
           if(nbligne == 1)
               return true;
           else
               return false;
        } catch(SQLException e) {
            
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(ps,conn);
        }
        return false;
    }
    
}
