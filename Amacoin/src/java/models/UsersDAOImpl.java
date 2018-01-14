/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Users;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public Users findUser(String email) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select email from users where email = ?";

        try {
            conn = dao.getConnection();
            ps = iniRequest(conn,query,true,email);
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
    public boolean inscription(String email, String pwd, String confirmation) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "insert into users (email,password) values (?,?)";
        
        try {
            
            if(pwd != null && confirmation != null && pwd.equals(confirmation)) {
                Users user = findUser(email);
                if(user != null) {
                    return false;
                } else {
                    conn = dao.getConnection();
                    ps = iniRequest(conn,query,true,email,pwd);
                    int statut = ps.executeUpdate();
                    if(statut==0) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
            
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            fermeturesSilencieuses(rs, ps, conn);
        }
        return true;
    }
    
    

    private static Users map(ResultSet rs) throws SQLException {
        Users utilisateur = new Users();
        utilisateur.setId(rs.getInt("id"));
        utilisateur.setEmail(rs.getString("email"));
        utilisateur.setPassword(rs.getString("password"));
        return utilisateur;

    }

    
    
}
