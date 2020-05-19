/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.impl.ContatoDaoJDBC;
import DAO.impl.UsuarioDaoJDBC;
import db.DbConnection;

/**
 *
 * @author ederc
 */
public class DaoFactory {
    
     public static ContatoDao createContatoDao(){
        return new ContatoDaoJDBC(DbConnection.getConnection());
    }
     
     public static UsuarioDao createUsuarioDao(){
        return new UsuarioDaoJDBC(DbConnection.getConnection());
    }
    
}
