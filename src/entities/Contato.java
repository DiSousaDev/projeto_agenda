/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import enums.Sexo;

/**
 *
 * @author ederc
 */
public class Contato {
    
    private int id;
    private String nome;
    private String email;
    private Sexo sexo;
    private String observacoes;
    private String logradouro;
    private String nome_rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String tel_residencial;
    private String tel_comercial; 

    public Contato() {
    }   

    public Contato(String nome, String email, Sexo sexo, String observacoes, String logradouro, String nome_rua, String numero, String bairro, String cidade, String estado, String cep, String tel_residencial, String tel_comercial) {
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.observacoes = observacoes;
        this.logradouro = logradouro;
        this.nome_rua = nome_rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.tel_residencial = tel_residencial;
        this.tel_comercial = tel_comercial;
    }
    
    
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the sexo
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the nome_rua
     */
    public String getNome_rua() {
        return nome_rua;
    }

    /**
     * @param nome_rua the nome_rua to set
     */
    public void setNome_rua(String nome_rua) {
        this.nome_rua = nome_rua;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }  

    public String getTel_comercial() {
        return tel_comercial;
    }

    public void setTel_comercial(String tel_comercial) {
        this.tel_comercial = tel_comercial;
    }

    public String getTel_residencial() {
        return tel_residencial;
    }

    public void setTel_residencial(String tel_residencial) {
        this.tel_residencial = tel_residencial;
    }   

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id:[" + id + "] Nome:[" + nome + "] E-mail:[" + email + "] Sexo:[" + sexo + "]\n");
        sb.append("Observações:[" + observacoes + "]\n");
        sb.append("---------------------------------------------------------------------------------\n");
        sb.append("Tipo:" + logradouro + " " + nome_rua + ", " + numero + ", Bairro: " + bairro + "\n");
        sb.append("Cidade:" + cidade + " Estado:" + estado + " CEP: " + cep + "\n");
        sb.append("---------------------------------------------------------------------------------\n");
        sb.append("Telefone Residencial:[" + tel_residencial + "] " + " Telefone Comercial:[" + tel_comercial + "]\n");      
        return sb.toString();
    }
    
    
    
}
