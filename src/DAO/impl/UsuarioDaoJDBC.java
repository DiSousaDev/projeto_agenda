/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.impl;

import DAO.UsuarioDao;
import db.DbConnection;
import db.DbException;
import entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ederc
 */
public class UsuarioDaoJDBC implements UsuarioDao {

    private Connection conn = null;

    public UsuarioDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Usuario obj) {
        PreparedStatement st = null;
        try {

            String sql = "INSERT INTO users (nome, senha) VALUES (?,?)";

            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getNome());
            st.setString(2, obj.getSenha());
            
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                    DbConnection.closeResultSet(rs);
                } else {
                    throw new DbException("Erro, nenuma linha foi alterada.");
                }
            }
        } catch (SQLException erro) {
            throw new DbException("Erro ao inserir dados. " + erro.getMessage());
        } finally {
            DbConnection.closeStatement(st);
        }
    }

    @Override
    public void update(Usuario obj) {
        PreparedStatement st = null;

        try {
            String sql = "UPDATE users SET user_nome=?, user_senha=? WHERE ID = ?";
            st = conn.prepareStatement(sql);

            st.setString(1, obj.getNome());
            st.setString(2, obj.getSenha());
            st.setInt(3, obj.getId());

            st.executeUpdate();

        } catch (SQLException erro) {
            throw new DbException("Erro ao atualizar dados " + erro.getMessage());
        } finally {
            DbConnection.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {

        PreparedStatement st = null;

        try {
            String sql = "DELETE FROM users WHERE id = ?";
            st = conn.prepareStatement(sql);

            st.setInt(1, id);

            int rows = st.executeUpdate();

            if (rows == 0) {
                throw new DbException("Id não encontrado.");
            }
        } catch (SQLException erro) {
            throw new DbException("Erro ao deletar. " + erro.getMessage());
        } finally {
            DbConnection.closeStatement(st);
        }

    }

    @Override
    public Usuario findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM users WHERE id = ?";
            st = conn.prepareStatement(sql);

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                Usuario obj = new Usuario();
                obj.setId(rs.getInt("user_id"));
                obj.setNome(rs.getString("user_nome"));
                obj.setSenha(rs.getString("user_senha"));
                
                return obj;
            } else {
                throw new DbException("Id Não encontrdo.");
            }

        } catch (SQLException erro) {
            throw new DbException("Erro Inesperado: " + erro.getMessage());
        } finally {
            DbConnection.closeResultSet(rs);
            DbConnection.closeStatement(st);
        }
    }

    @Override
    public List<Usuario> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            List<Usuario> contatos = new ArrayList<>();
            String sql = "SELECT * FROM users";
            st = conn.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                Usuario obj = new Usuario();
                obj.setId(rs.getInt("user_id"));
                obj.setNome(rs.getString("user_nome"));
                obj.setSenha(rs.getString("user_senha"));
                
                contatos.add(obj);
            }

            return contatos;

        } catch (SQLException erro) {
            throw new DbException("Erro Inesperado: " + erro.getMessage());
        } finally {
            DbConnection.closeResultSet(rs);
            DbConnection.closeStatement(st);
        }
    }

    @Override
    public List<Usuario> findByName(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            List<Usuario> contatos = new ArrayList<>();
            String sql = "SELECT * FROM contato WHERE nome like ?";
            st = conn.prepareStatement(sql);
            st.setString(1, nome);
            rs = st.executeQuery();
            

            while (rs.next()) {           
               
                Usuario obj = new Usuario();
                obj.setId(rs.getInt("user_id"));
                obj.setNome(rs.getString("user_nome"));
                obj.setSenha(rs.getString("user_senha"));
                
                contatos.add(obj);
            } 
         return contatos;
        } catch (SQLException erro) {
            throw new DbException("Erro Inesperado: " + erro.getMessage());
        } finally {
            DbConnection.closeResultSet(rs);
            DbConnection.closeStatement(st);
        }
    }

}
