/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.helpers;

import View.Agenda;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import model.Agendamento;
import model.CadastroCliente;
import model.CadastroServico;

/**
 *
 * @author thall
 */
public class AgendaHelper implements IHelper {
    
    // View
    private final Agenda view;   
    
    // Obtém a data e hora
    LocalDate dataatual = LocalDate.now();
    LocalTime tempoatual = LocalTime.now();
    
    // Formata a data como uma string (opcional)& Formata a hora como uma string (opcional)
    DateTimeFormatter dataformatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String novadata = dataatual.format(dataformatada);
    
    // Hora Formatada
    DateTimeFormatter horaformatada = DateTimeFormatter.ofPattern("HH:mm"); // Formato de 24 horaso
    String novahora = tempoatual.format(horaformatada);

    public AgendaHelper(Agenda view) {
        this.view = view;
        
    }    
    
    // Lista de Clientes
    @SuppressWarnings("unchecked")
    public void preencherClientes(ArrayList<CadastroCliente> clientes) {
        DefaultComboBoxModel listacliente = (DefaultComboBoxModel) view.getListaClientes().getModel();
        for(CadastroCliente cliente : clientes) {
            listacliente.addElement(cliente);
        }
    }
    
    // Lista de Serviços
    @SuppressWarnings("unchecked")
    public void preencherServicos(ArrayList<CadastroServico> servicos) {
        DefaultComboBoxModel listaservico = (DefaultComboBoxModel) view.getListaServicos().getModel(); 
        for(CadastroServico servico : servicos) {            
            listaservico.addElement(servico);
        }
    }
    public CadastroCliente obterCliente() {
        return (CadastroCliente) view.getListaClientes().getSelectedItem();
    }
    public CadastroServico obterServico() {
        return (CadastroServico) view.getListaServicos().getSelectedItem();
    }
    public void setarValor(float valor) {
        view.getTextValor().setText(valor+"");
    }

    @Override
    public Agendamento obterModelo() {              
        // Data
        CadastroCliente clienteid = obterCliente();
        CadastroServico servicoid = obterServico();
        String stringvalor = view.getTextValor().getText();
        float valorid = Float.parseFloat(stringvalor);
        String dataid = view.getTextData().getText();
        String horaid = view.getTextHora().getText();
        String datahora = dataid + " " + horaid;
        String obs = view.getObsText().getText();
               
        // Salvar Agendamento
        Agendamento agendamento = new Agendamento(0, clienteid, servicoid, valorid, datahora, obs);
        return agendamento;      
    }

    @Override
    public void limparTela() {
        view.getTextData().setText(novadata);
        view.getTextHora().setText(novahora);
        view.getObsText().setText("");
    }      
}
