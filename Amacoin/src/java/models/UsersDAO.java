/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Users;

/**
 *
 * @author Alexis
 */
public interface UsersDAO {
    Users findWallet(String email) throws DAOException;
    Users getUsers(String email, String pwd) throws DAOException;
    boolean findUser(String email) throws DAOException;
    boolean inscription(String email, String pwd, String confirmation) throws DAOException;
    
}
