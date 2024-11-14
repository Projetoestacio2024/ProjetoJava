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
 * @author Thalles
 */
public class Agendamento {

    private Integer id;
    private CadastroCliente cliente;
    private CadastroServico servico;
    private float valor;
    private Date data;
    private String observacao;

    public Agendamento(Integer idvar, CadastroCliente clientevar, CadastroServico servicovar, float valorvar, String datavar) {
        this.id = idvar;
        this.cliente = clientevar;
        this.servico = servicovar;
        this.valor = valorvar;
        try { this.data = new SimpleDateFormat("dd/mm/yyyy HH:mm").parse(datavar); } 
        catch (ParseException ex) { Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex); }
    }

    public Agendamento(Integer idvar, CadastroCliente clientevar, CadastroServico servicovar, float valorvar, String datavar, String observacaovar) {
        this(idvar, clientevar, servicovar, valorvar, datavar);
        this.observacao = observacaovar;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CadastroCliente getCliente() {
        return cliente;
    }

    public void setCliente(CadastroCliente cliente) {
        this.cliente = cliente;
    }

    public CadastroServico getServico() {
        return servico;
    }

    public void setServico(CadastroServico servico) {
        this.servico = servico;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }
    
    public String getDataFormatada(){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    public String getHoraFormatada(){
        return new SimpleDateFormat("HH:mm").format(data);
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }    
}
