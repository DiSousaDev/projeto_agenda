/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Contato;
import java.util.List;

/**
 *
 * @author ederc
 */
public interface ContatoDao {
    
    void insert(Contato obj);
    void update(Contato obj);
    void deleteById(Integer id);
    Contato buscaCep(String cep);
    Contato findById(Integer id);
    List<Contato> findByName(String nome);
    List<Contato> findAll(); 
    
}
