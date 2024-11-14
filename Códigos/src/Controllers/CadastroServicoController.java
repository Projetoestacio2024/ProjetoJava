/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.DAO.Banco;
import Model.DAO.ServicoDAO;
import View.Servico;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CadastroServico;

/**
 *
 * @author thall
 */
public class CadastroServicoController {
    
    private final Servico view;   
    public CadastroServicoController(Servico view) {
        this.view = view;       
    }
    
    // Cadastrar Servicos
    public void inserirServico(){
        // Dados
        String serviconome = view.getTextServico().getText();
        float servicopreco = Float.parseFloat(view.getTextValor().getText()); 
        boolean jaexiste = false;        
        
        // Verificar se Ja existe
        for(CadastroServico servicoLista : Banco.servico) 
        {
            if(serviconome.equals(servicoLista.getDescricao()))
            {
                jaexiste = true;
                break;
            }
        }
        
        // Checks
        if(jaexiste)
        {
            // INFO MSG
            JOptionPane.showMessageDialog(null, "Este serviço ja existe no banco de dados", "Cadastro de serviços", JOptionPane.ERROR_MESSAGE);
            return;
        }       
        if(serviconome == null || serviconome.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo tipo de serviço está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }        
        if(view.getTextValor().getText() == null || serviconome.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo tipo de serviço está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
       
        if(isNumeric(view.getTextValor().getText()))
        {
            // Salvar Dados
            CadastroServico servico = new CadastroServico(proximoId(), serviconome, servicopreco);
            new ServicoDAO().insert(servico); 

            // INFO MSG
            JOptionPane.showMessageDialog(null, "O serviço foi cadastrado com sucesso", "Cadastro de serviços", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "O ERROS", "Cadastro de serviços", JOptionPane.INFORMATION_MESSAGE);
        }
    }    
    public void limparCamposServico(){
        view.getTextServico().setText("Tipo de serviço");
        view.getTextValor().setText("15.00");
    }
    
    public void atualizarTabela(){
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<CadastroServico> servicos = servicoDAO.selectAll();
        DefaultTableModel tablemodel = (DefaultTableModel) view.getjTabelaInfo().getModel();
        tablemodel.setNumRows(0);
        for(CadastroServico servico : servicos){            
            tablemodel.addRow(new Object[]{
                servico.getId(),
                servico.getDescricao(),
                servico.getValor()
            });
        }       
    }
    
    public void atualizarServicoTabela(){
        int linha = view.getjTabelaInfo().getSelectedRow();         
        if(linha != -1)
        {
            String serviconome = view.getTextServico().getText();
            float servicopreco = Float.parseFloat(view.getTextValor().getText());  
                     
            if(serviconome == null || serviconome.trim().isEmpty()) 
            {
               JOptionPane.showMessageDialog(null, "O campo tipo de serviço está vazio.", "Erro de atualização", JOptionPane.ERROR_MESSAGE);
               return;
            }        
            if(view.getTextValor().getText() == null || serviconome.trim().isEmpty()) 
            {
               JOptionPane.showMessageDialog(null, "O campo tipo de serviço está vazio.", "Erro de atualização", JOptionPane.ERROR_MESSAGE);
               return;
            }
            ServicoDAO servicoDAO = new ServicoDAO();
            servicoDAO.forceupdate(linha, serviconome, servicopreco);
        
            // INFO MSG
            JOptionPane.showMessageDialog(null, "O serviço foi atualizado com sucesso", "Cadastro de serviços", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            // INFO MSG
            JOptionPane.showMessageDialog(null, "Você não pode atualizar este serviço ele não é válido.", "Cadastro de serviços", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public void deletarServicoTabela(){
        int linha = view.getjTabelaInfo().getSelectedRow();        
        if(linha != -1)
        {            
            // Remover Array
            ServicoDAO servicoDAO = new ServicoDAO();
            servicoDAO.forcedelete(linha);
            
            // INFO MSG
            JOptionPane.showMessageDialog(null, "O serviço foi deletado com sucesso", "Cadastro de serviços", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            // INFO MSG
            JOptionPane.showMessageDialog(null, "Você não pode deletar este serviço ele não é válido.", "Cadastro de serviços", JOptionPane.ERROR_MESSAGE);
        }
        
    }
       
    // Auto ID
    private int proximoId()
    {       
        int maiorId = 0;        
        for (CadastroServico servico : Banco.servico) 
        {           
           int id = servico.getId();            
            if(maiorId < id){
                maiorId = id;
            }           
        }       
        return maiorId + 1;
    }      
    
    public boolean isNumeric(String str) 
    {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
