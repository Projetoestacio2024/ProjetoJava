/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thalles
 */
public class CadastroCliente extends Pessoa{
    private String estado;
    private String bairro;
    private String endereco;
    private String cep; 

    public CadastroCliente(Integer id, String usuario, String nome, String cpf, String rg, String datanascimento, String sexo, String email, String telefone, String estado, String bairro, String endereco, String cep) {
        super(id, usuario, nome, cpf, rg, datanascimento, sexo, email, telefone);
        this.estado = estado;
        this.bairro = bairro;        
        this.endereco = endereco;
        this.cep = cep;
    }

    public CadastroCliente(Integer id, String nome, String endereco, String cep) {
        super(id, nome);
        this.endereco = endereco;
        this.cep = cep;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
        
    @Override
    public String toString(){
        return getNome();
    }
    
}
