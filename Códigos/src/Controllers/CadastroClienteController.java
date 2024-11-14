/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.DAO.Banco;
import Model.DAO.ClienteDAO;
import View.Cliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CadastroCliente;
import View.MenuPrincipal;
import Controllers.MenuPrincipalController;

/**
 *
 * @author thall
 */
public class CadastroClienteController {
    
    // Var
    private final Cliente view;
    public CadastroClienteController(Cliente view) {
        this.view = view;       
    }
              
    public void atualizarTabela()
    {      
        // Data base
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<CadastroCliente> clientes = clienteDAO.selectAll();
        DefaultTableModel tablemodel = (DefaultTableModel) view.getTabelaClientes().getModel();
        tablemodel.setNumRows(0);
        for(CadastroCliente cliente : clientes){            
            tablemodel.addRow(new Object[]{
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getRg(),
            });
        }  
    }
       
    // Cadastrar Cliente
    public void inserirCliente(){
        
        // Dados
        String nomecliente = view.getTextNome().getText();
        String cpfcliente = view.getTextCpf().getText();
        String rgcliente = view.getTextRg().getText();
        String datanasc = view.getTextDataNasc().getText();
        String sexocliente = view.getTextSexo().getText();
        String emailcliente = view.getTextEmail().getText();
        String telefonecliente = view.getTextTelefone().getText();
        String estadocliente = view.getTextEstado().getText();
        String bairrocliente = view.getTextBairro().getText();
        String enderecocliente = view.getTextEndereco().getText();
        String cepcliente = view.getTextCep().getText();
        
        boolean jaexiste = false;
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<CadastroCliente> clientes = clienteDAO.selectAll();
        for(CadastroCliente clientelista : Banco.cliente) 
        {
            if(cpfcliente.equals(clientelista.getCpf()) || rgcliente.equals(clientelista.getRg()))
            {
                jaexiste = true;
                break;
            }
        }
        
        // Checks
        if(jaexiste)
        {
            // INFO MSG
            JOptionPane.showMessageDialog(null, "Ja tem um cliente com algum campo igual(CPF, USUARIO, RG)", "Cadastro de usuários", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Estourar Erros(EVITAR BUGS)
        try {
            new SimpleDateFormat("dd/mm/yyyy").parse(datanasc);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "O campo de data está inválido.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(nomecliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo nome está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(cpfcliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo cpf está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(rgcliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo rg está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(sexocliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo sexo está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(estadocliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo estado está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(bairrocliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo bairro está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(enderecocliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo endereço está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(cepcliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo CEP está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        
        // Salvar Dados
        CadastroCliente cliente = new CadastroCliente(proximoId(), "none", nomecliente, cpfcliente, rgcliente, datanasc, sexocliente, 
                emailcliente, telefonecliente, estadocliente, bairrocliente, enderecocliente, cepcliente);
        new ClienteDAO().insert(cliente);  
        
        // INFO MSG
        JOptionPane.showMessageDialog(null, "O cadastro foi realizado com sucesso", "Cadastro de cliente", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void deletarCliente(){
        int linha = view.getTabelaClientes().getSelectedRow();        
        if(linha != -1)
        {
            // Remover Array
            ClienteDAO clientedao = new ClienteDAO();
            clientedao.forcedelete(linha);
            
            // INFO MSG
            JOptionPane.showMessageDialog(null, "O cliente foi deletado com sucesso", "Cadastro de usuários", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            // INFO MSG
            JOptionPane.showMessageDialog(null, "Você não pode deletar este cliente ele não é válido.", "Cadastro de usuários", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateCliente()
    {
        // Dados
        String nomecliente = view.getTextNome().getText();
        String cpfcliente = view.getTextCpf().getText();
        String rgcliente = view.getTextRg().getText();
        String datanasc = view.getTextDataNasc().getText();
        String sexocliente = view.getTextSexo().getText();
        String emailcliente = view.getTextEmail().getText();
        String telefonecliente = view.getTextTelefone().getText();
        String estadocliente = view.getTextEstado().getText();
        String bairrocliente = view.getTextBairro().getText();
        String enderecocliente = view.getTextEndereco().getText();
        String cepcliente = view.getTextCep().getText();
        ClienteDAO clienteDAO = new ClienteDAO();
                
        // Estourar Erros(EVITAR BUGS)
        try {
            new SimpleDateFormat("dd/mm/yyyy").parse(datanasc);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "O campo de data está inválido.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(nomecliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo nome está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(cpfcliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo cpf está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(rgcliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo rg está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(sexocliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo sexo está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(estadocliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo estado está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(bairrocliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo bairro está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(enderecocliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo endereço está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(cepcliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo CEP está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        
        int linha = view.getTabelaClientes().getSelectedRow();         
        if(linha != -1)
        {
            // Salvar Dados
            CadastroCliente cliente = new CadastroCliente(linha, "none", nomecliente, cpfcliente, rgcliente, datanasc, sexocliente, 
                emailcliente, telefonecliente, estadocliente, bairrocliente, enderecocliente, cepcliente);
            new ClienteDAO().update(linha, cliente);
        
            // INFO MSG
            JOptionPane.showMessageDialog(null, "O cadastro foi atualizado com sucesso", "Cadastro de cliente", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Você precisa escolher algum cliente na tabela antes de usar esta opção.", "Erro de atualização", JOptionPane.ERROR_MESSAGE);            
        }
    }
    
    // Limpar Campos
    public void limparCampos(){
        view.getTextNome().setText("Digite nome do cliente");
        view.getTextCpf().setText("999.999.999-99");
        view.getTextRg().setText("9999999-99");
        view.getTextDataNasc().setText("22/12/2000");
        view.getTextSexo().setText("Nenhum");
        view.getTextEmail().setText("email@info.com");
        view.getTextTelefone().setText("(21) 99999-9999");
        view.getTextEstado().setText("Rio de Janeiro");
        view.getTextBairro().setText("Campo Grande");
        view.getTextEndereco().setText("Rua Exemplo, casa 25");
        view.getTextCep().setText("25092-000");        
    }
    
    public void tabelaClick(){        
        int linha = view.getTabelaClientes().getSelectedRow();
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<CadastroCliente> clientes = clienteDAO.selectAll();              
        view.getTextNome().setText(clientes.get(linha).getNome());
        view.getTextCpf().setText(clientes.get(linha).getCpf());
        view.getTextRg().setText(clientes.get(linha).getRg());
        view.getTextDataNasc().setText(clientes.get(linha).getDataFormatada());
        view.getTextSexo().setText(clientes.get(linha).getSexo());
        view.getTextEmail().setText(clientes.get(linha).getEmail());
        view.getTextTelefone().setText(clientes.get(linha).getTelefone());
        view.getTextEstado().setText(clientes.get(linha).getEstado());
        view.getTextBairro().setText(clientes.get(linha).getBairro());
        view.getTextEndereco().setText(clientes.get(linha).getEndereco());
        view.getTextCep().setText(clientes.get(linha).getCep());
    }
        
    // Auto ID
    private int proximoId()
    {       
        int maiorId = 0;        
        for (CadastroCliente cliente : Banco.cliente) 
        {           
           int id = cliente.getId();            
            if(maiorId < id){
                maiorId = id;
            }           
        }       
        return maiorId + 1;
    }    
}
