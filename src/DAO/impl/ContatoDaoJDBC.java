/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.impl;

import DAO.ContatoDao;
import db.DbConnection;
import db.DbException;
import entities.Contato;
import enums.Sexo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import view.utils.WebServiceCep;

/**
 *
 * @author ederc
 */
public class ContatoDaoJDBC implements ContatoDao {

    private Connection conn = null;

    public ContatoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Contato obj) {
        PreparedStatement st = null;
        try {

            String sql = "INSERT INTO contato"
                    + "(nome, email, sexo, observacoes, logradouro, nome_rua, numero, bairro, cidade, estado, cep, telefone_residencial, telefone_comercial) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getNome());
            st.setString(2, obj.getEmail());
            st.setString(3, obj.getSexo().toString());
            st.setString(4, obj.getObservacoes());
            st.setString(5, obj.getLogradouro());
            st.setString(6, obj.getNome_rua());
            st.setString(7, obj.getNumero());
            st.setString(8, obj.getBairro());
            st.setString(9, obj.getCidade());
            st.setString(10, obj.getEstado());
            st.setString(11, obj.getCep());
            st.setString(12, obj.getTel_residencial());
            st.setString(13, obj.getTel_comercial());

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
    public void update(Contato obj) {
        PreparedStatement st = null;

        try {
            String sql = "UPDATE contato SET nome=?, email=?, sexo=?, observacoes=?, logradouro=?, nome_rua=?,"
                    + "numero=?, bairro=?, cidade=?, estado=?, cep=?, telefone_residencial=?, telefone_comercial=? WHERE ID = ?";
            st = conn.prepareStatement(sql);

            st.setString(1, obj.getNome());
            st.setString(2, obj.getEmail());
            st.setString(3, obj.getSexo().toString());
            st.setString(4, obj.getObservacoes());
            st.setString(5, obj.getLogradouro());
            st.setString(6, obj.getNome_rua());
            st.setString(7, obj.getNumero());
            st.setString(8, obj.getBairro());
            st.setString(9, obj.getCidade());
            st.setString(10, obj.getEstado());
            st.setString(11, obj.getCep());
            st.setString(12, obj.getTel_residencial());
            st.setString(13, obj.getTel_comercial());
            st.setInt(14, obj.getId());

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
            String sql = "DELETE FROM contato WHERE id = ?";
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
    public Contato findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM contato WHERE id = ?";
            st = conn.prepareStatement(sql);

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                Contato obj = new Contato();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setSexo(Sexo.valueOf(rs.getString("sexo")));
                obj.setObservacoes(rs.getString("observacoes"));
                obj.setLogradouro(rs.getString("logradouro"));
                obj.setNome_rua(rs.getString("nome_rua"));
                obj.setNumero(rs.getString("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                obj.setCep(rs.getString("cep"));
                obj.setTel_residencial(rs.getString("telefone_residencial"));
                obj.setTel_comercial(rs.getString("telefone_comercial"));

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
    public List<Contato> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            List<Contato> contatos = new ArrayList<>();
            String sql = "SELECT * FROM contato";
            st = conn.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                Contato obj = new Contato();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setSexo(Sexo.valueOf(rs.getString("sexo")));
                obj.setObservacoes(rs.getString("observacoes"));
                obj.setLogradouro(rs.getString("logradouro"));
                obj.setNome_rua(rs.getString("nome_rua"));
                obj.setNumero(rs.getString("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                obj.setCep(rs.getString("cep"));
                obj.setTel_residencial(rs.getString("telefone_residencial"));
                obj.setTel_comercial(rs.getString("telefone_comercial"));

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
    public List<Contato> findByName(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            List<Contato> contatos = new ArrayList<>();
            String sql = "SELECT * FROM contato WHERE nome like ?";
            st = conn.prepareStatement(sql);
            st.setString(1, nome);
            rs = st.executeQuery();
            

            while (rs.next()) {           
               
                Contato obj = new Contato();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setSexo(Sexo.valueOf(rs.getString("sexo")));
                obj.setObservacoes(rs.getString("observacoes"));
                obj.setLogradouro(rs.getString("logradouro"));
                obj.setNome_rua(rs.getString("nome_rua"));
                obj.setNumero(rs.getString("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                obj.setCep(rs.getString("cep"));
                obj.setTel_residencial(rs.getString("telefone_residencial"));
                obj.setTel_comercial(rs.getString("telefone_comercial"));
                
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

    public Contato buscaCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        Contato obj = new Contato();

        if (webServiceCep.wasSuccessful()) {
            obj.setLogradouro(webServiceCep.getLogradouroType());
            obj.setNome_rua(webServiceCep.getLogradouro());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setEstado(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
    
}
