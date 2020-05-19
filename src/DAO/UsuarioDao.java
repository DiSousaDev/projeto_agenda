/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Usuario;
import java.util.List;

/**
 *
 * @author ederc
 */
public interface UsuarioDao {
    
    void insert(Usuario obj);
    void update(Usuario obj);
    void deleteById(Integer id);
    Usuario findById(Integer id);
    List<Usuario> findByName(String nome);
    List<Usuario> findAll(); 
    
}
