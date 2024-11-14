/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thall
 */
abstract class Pessoa {
    
    // VARS
    protected Integer id;
    protected String usuario;
    protected String nome;
    protected String cpf;
    protected String rg;
    protected Date datanascimento;
    protected String sexo;
    protected String email;
    protected String telefone;

    public Pessoa(Integer id, String usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public Pessoa(Integer id, String usuario, String nome, String cpf, String rg, String datanascimento, String sexo, String email, String telefone) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        try {
            this.datanascimento = new SimpleDateFormat("dd/mm/yyyy").parse(datanascimento);
        } catch (ParseException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }   

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getDataFormatada(){
        return new SimpleDateFormat("dd/MM/yyyy").format(datanascimento);
    }
    public String getHoraFormatada(){
        return new SimpleDateFormat("HH:mm").format(datanascimento);
    }
    
    
}
