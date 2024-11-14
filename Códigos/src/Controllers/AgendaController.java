/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Controllers.helpers.AgendaHelper;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;
import model.CadastroCliente;
import model.CadastroServico;

/**
 *
 * @author thall
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;
        
    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizarTabela(){
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        DefaultTableModel tablemodel = (DefaultTableModel) view.getTabelaAgendamentos().getModel();
        tablemodel.setNumRows(0);
        for(Agendamento agendamento : agendamentos){            
            tablemodel.addRow(new Object[]{
                agendamento.getCliente(),
                agendamento.getServico(),
                agendamento.getObservacao(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),                
            });
        }     
     }
                
    public void atualizarCliente(){
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<CadastroCliente> clientes = clienteDAO.selectAll();        
        helper.preencherClientes(clientes);
        
    }
    
    public void AtualizarDataHora(){
        helper.limparTela();
    }
    
    public void atualizarServico(){
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<CadastroServico> servico = servicoDAO.selectAll();        
        helper.preencherServicos(servico);      
    }
    
    public void atualizarValor() {
        CadastroServico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }
    
    public void agendar(){
        Agendamento agendamento = helper.obterModelo();
        new AgendamentoDAO().insert(agendamento);        
        helper.limparTela();
             
        // INFO MSG
        JOptionPane.showMessageDialog(null, "O agendamento foi realizado com sucesso", "Agendamento", JOptionPane.INFORMATION_MESSAGE);
    }   
       
    public void atualizarAgendamento()
    {
        // Atualizar ITENS
        Agendamento agendamento = helper.obterModelo();
        int linha = view.getTabelaAgendamentos().getSelectedRow();  
        if(linha != -1)
        {
            new AgendamentoDAO().update(linha, agendamento);        
            helper.limparTela();
         
            // INFO MSG
            JOptionPane.showMessageDialog(null, "O agendamento foi atualizado com sucesso", "Agendamento", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void deletarAgendamento(){
        int linha = view.getTabelaAgendamentos().getSelectedRow();        
        if(linha != -1)
        {
            // Remover Array
            AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
            agendamentoDAO.forcedelete(linha);
            
            
            // INFO MSG
            JOptionPane.showMessageDialog(null, "O agendamento foi deletado com sucesso", "Cadastro de serviços", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            // INFO MSG
            JOptionPane.showMessageDialog(null, "Você não pode deletar este agendamento ele não é válido.", "Cadastro de serviços", JOptionPane.ERROR_MESSAGE);
        }
    }    
}
