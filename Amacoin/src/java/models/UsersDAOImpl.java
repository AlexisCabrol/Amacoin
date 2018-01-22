/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Users;
import java.sql.*;
import static beans.Users.generateWallet;
import static models.DAOUtilitaire.fermeturesSilencieuses;
import static models.DAOUtilitaire.iniRequest;

/**
 *
 * @author Alexis
 */
public class UsersDAOImpl implements UsersDAO {
    private DAO dao;
    
    UsersDAOImpl(DAO dao) {
        this.dao = dao;
    }
    
    @Override
    public Users getUsers(String email, String pwd) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from users where email = ? and password = ?";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn,query,false,email,pwd);
            rs = ps.executeQuery();
            if(rs.next()) {
                return map(rs);
            }
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(rs, ps, conn);
        }
        return null;
    }
    
    
    @Override
    public boolean findUser(String email) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select email from users where email = ?";

        try {
            conn = dao.getConnection();
            ps = iniRequest(conn,query,true,email);
            rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch(SQLException e) {
            throw new DAOException(e);

        } finally {
            fermeturesSilencieuses(rs, ps, conn);
        }
        
    }

    @Override
    public boolean inscription(String email, String pwd, String confirmation) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        String walletBTC = generateWallet();
        String walletETH = generateWallet();
        String walletLTC = generateWallet();
        String walletXRP = generateWallet();
        String query = "insert into users (email,password,wallets_btc,wallets_xrp,wallets_ltc,wallets_eth) values (?,?,?,?,?,?)";
        int statut = 0;
        
        try {
                    conn = dao.getConnection();
                    ps = iniRequest(conn,query,false,email,pwd,walletBTC,walletXRP,walletLTC,walletETH);
                    statut = ps.executeUpdate();
                    if(statut == 1)
                        return true;
                    else
                        return false;   
            
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            fermeturesSilencieuses(ps, conn);
        }
    }
    
    

    private static Users map(ResultSet rs) throws SQLException {
        Users utilisateur = new Users();
        utilisateur.setId(rs.getInt("id"));
        utilisateur.setEmail(rs.getString("email"));
        utilisateur.setPassword(rs.getString("password"));
        utilisateur.setWallets_bts(rs.getString("wallets_btc"));
        utilisateur.setWallets_eth(rs.getString("wallets_eth"));
        utilisateur.setWallets_xrp(rs.getString("wallets_xrp"));
        utilisateur.setWallets_ltc(rs.getString("wallets_ltc"));
        return utilisateur;

    }

    @Override
    public Users findWallet(String email) throws DAOException {
       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       String query = "select * from users where email = ?";
       
       try {
           conn = dao.getConnection();
           ps = iniRequest(conn, query, false, email);
           rs = ps.executeQuery();
           if(rs.next()) {
               return map(rs);
           }
       } catch(SQLException e) {
           throw new DAOException(e);
       } finally {
           DAOUtilitaire.fermeturesSilencieuses(rs, ps, conn);
       }
       return null;
    }

    
    
}
