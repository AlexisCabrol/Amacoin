/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static models.DAOUtilitaire.iniRequest;

/**
 *
 * @author Alexis
 */
public class PanierDAOImpl implements PanierDAO{
    private DAO dao;

    PanierDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public boolean createPanier(int idClient) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "insert into orders(idClient) values (?)";
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idClient);
            int nbligne = ps.executeUpdate();
            if(nbligne == 1) {
                return true;
            }
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(ps,conn);
        }
        return false;
    }

    @Override
    public int existePanier(int idClient) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from orders where idClient = ?";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idClient);
            rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getInt("id_commande");
            } 
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(rs,ps,conn);
        }
        return -1;
    }

    @Override
    public boolean insertPanierBTC(int idPanier, int nombre) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "insert into details values (?,?,?)";
        int nbligne = 0;
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier,1,nombre);
            nbligne = ps.executeUpdate();
            if(nbligne == 1)
                return true;
            else
                return false;
            
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(ps, conn);
        }
    }

    @Override
    public boolean insertPanierLTC(int idPanier, int nombre) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "insert into details values (?,?,?)";
        int nbligne = 0;
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier,2,nombre);
            nbligne = ps.executeUpdate();
            if(nbligne == 1)
                return true;
            else
                return false;
            
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(ps, conn);
        }
    }

    @Override
    public boolean insertPanierETH(int idPanier, int nombre) throws DAOException {
                Connection conn = null;
        PreparedStatement ps = null;
        String query = "insert into details values (?,?,?)";
        int nbligne = 0;
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier,3,nombre);
            nbligne = ps.executeUpdate();
            if(nbligne == 1)
                return true;
            else
                return false;
            
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(ps, conn);
        }
    }

    @Override
    public boolean insertPanierXRP(int idPanier, int nombre) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "insert into details values (?,?,?)";
        int nbligne = 0;
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier,4,nombre);
            nbligne = ps.executeUpdate();
            if(nbligne == 1)
                return true;
            else
                return false;
            
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(ps, conn);
        }
        
    }

    @Override
    public int recapPrixBTC(int idPanier) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select sum(prix_unitaire*nombre) as totalBTC from produit p join details d on p.ref_produit = d.ref_item where id_commande = ? and ref_item = 1";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier);
            rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getInt("totalBTC");
            }
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(rs,ps,conn);
        }
        return 0;
    }

    @Override
    public int recapPrixETH(int idPanier) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select sum(prix_unitaire*nombre) as totalETH from produit p join details d on p.ref_produit = d.ref_item where id_commande =? and ref_item = 3";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier);
            rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getInt("totalETH");
            }
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(rs,ps,conn);
        }
        return 0;
    }

    @Override
    public int recapPrixLTC(int idPanier) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select sum(prix_unitaire*nombre) as totalLTC from produit p join details d on p.ref_produit = d.ref_item where id_commande =? and ref_item = 2";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier);
            rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getInt("totalLTC");
            }
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(rs,ps,conn);
        }
        return 0;
    }

    @Override
    public int recapPrixXRP(int idPanier) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select sum(prix_unitaire*nombre) as totalXRP from produit p join details d on p.ref_produit = d.ref_item where id_commande =? and ref_item = 4";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier);
            rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getInt("totalXRP");
            }
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(rs,ps,conn);
        }
        return 0;
    
    }
    

    @Override
    public boolean paiement(int idPanier, int total) throws DAOException {
        Connection conn = null;
        String query = "update orders set prix_total = ?, paiement = 1 where id_commande = ?";
        PreparedStatement ps = null;
        int nbligne = 0;
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, total,idPanier);
            nbligne = ps.executeUpdate();
            if(nbligne == 1)
                return true;
            else
                return false;
        }catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(ps, conn);
        }
    }

    @Override
    public int recapPrixTotal(int idPanier) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select sum(prix_unitaire*nombre) as total from produit p join details d on p.ref_produit = d.ref_item where id_commande = ?";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier);
            rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getInt("total");
            }
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(rs, ps, conn);
        }
        return 0;
    }

    @Override
    public boolean remiseAZeoPanier(int idPanier) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        int nbligne = 0;
        String query = "delete from details where id_commande = ?";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier);
            nbligne = ps.executeUpdate();
            if(nbligne == 1)
                return true;
            else
                return false;
            
        } catch(SQLException e){
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(ps,conn);
        }
        
    }

    @Override
    public int nombreBTCPanier(int idPanier) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select nombre from details where id_commande = ? and ref_item = 1";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier);
            rs = ps.executeQuery();
            if(rs.next())
                return rs.getInt("nombre");
            
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(rs,ps,conn);
        }
        return 0;
    }

    @Override
    public int nombreETHPanier(int idPanier) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select nombre from details where id_commande = ? and ref_item = 3";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier);
            rs = ps.executeQuery();
            if(rs.next())
                return rs.getInt("nombre");
            
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(rs,ps,conn);
        }
        return 0;
    }

    @Override
    public int nombreLTCPanier(int idPanier) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select nombre from details where id_commande = ? and ref_item = 2";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier);
            rs = ps.executeQuery();
            if(rs.next())
                return rs.getInt("nombre");
            
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(rs,ps,conn);
        }
        return 0;
    }

    @Override
    public int nombreXRPPanier(int idPanier) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select nombre from details where id_commande = ? and ref_item = 4";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn, query, false, idPanier);
            rs = ps.executeQuery();
            if(rs.next())
                return rs.getInt("nombre");
            
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            DAOUtilitaire.fermeturesSilencieuses(rs,ps,conn);
        }
        return 0;
    }
}
