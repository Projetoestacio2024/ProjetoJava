/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Model.DAO.Banco;
import Model.DAO.UsuarioDAO;
import View.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CadastroUsuario;

/**
 *
 * @author thall
 */
public class CadastroUsuarioController {
    
    // Var
    private final Usuario view;
    public CadastroUsuarioController(Usuario view) {
        this.view = view;       
    }
    
    public void atualizarTabela(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ArrayList<CadastroUsuario> usuarios = usuarioDAO.selectAll();
        DefaultTableModel tablemodel = (DefaultTableModel) view.getTabelaUsers().getModel();
        tablemodel.setNumRows(0);
        for(CadastroUsuario usuario : usuarios){            
            tablemodel.addRow(new Object[]{
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getUsuario(),
            });
        }       
    }
    
    public void clicktabelaupdate(){
        int linha = view.getTabelaUsers().getSelectedRow();
        if(linha == 0){
                JOptionPane.showMessageDialog(null, "Você não pode modificar este usuário", "Erro de atualização", JOptionPane.ERROR_MESSAGE);
                return;               
        }
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ArrayList<CadastroUsuario> usuarios = usuarioDAO.selectAll();  
        view.getTextNome().setText(usuarios.get(linha).getNome());
        view.getTextCpf().setText(usuarios.get(linha).getCpf());
        view.getTextRg().setText(usuarios.get(linha).getRg());
        view.getTextDataNasc().setText(usuarios.get(linha).getDataFormatada());
        view.getTextSexo().setText(usuarios.get(linha).getSexo());
        view.getTextEmail().setText(usuarios.get(linha).getEmail());
        view.getTextSenha().setText(usuarios.get(linha).getSenha());
        view.getTextTelefone().setText(usuarios.get(linha).getTelefone());
        view.getTextEstado().setText(usuarios.get(linha).getEstado());
        view.getTextBairro().setText(usuarios.get(linha).getBairro());
        view.getTextEndereco().setText(usuarios.get(linha).getEndereco());
        view.getTextCep().setText(usuarios.get(linha).getCep());    
        
    }
    
    // Cadastrar Usuario
    public void inserirUsuario(){
        
        // Dados
        String nomecliente = view.getTextNome().getText();
        String cpfcliente = view.getTextCpf().getText();
        String rgcliente = view.getTextRg().getText();
        String datanasc = view.getTextDataNasc().getText();
        String sexocliente = view.getTextSexo().getText();
        String emailcliente = view.getTextEmail().getText();
        String usuariocliente = view.getTextUsuario().getText();
        String senhacliente = view.getTextSenha().getText();
        String telefonecliente = view.getTextTelefone().getText();
        String estadocliente = view.getTextEstado().getText();
        String bairrocliente = view.getTextBairro().getText();
        String enderecocliente = view.getTextEndereco().getText();
        String cepcliente = view.getTextCep().getText();
        
        boolean jaexiste = false;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ArrayList<CadastroUsuario> usuarios = usuarioDAO.selectAll();
        for(CadastroUsuario usuariolista : Banco.usuario) 
        {
            if(cpfcliente.equals(usuariolista.getCpf()) || rgcliente.equals(usuariolista.getRg()) || usuariocliente.equals(usuariolista.getUsuario()))
            {
                jaexiste = true;
                break;
            }
        }
        
        // Checks
        if(jaexiste)
        {
            // INFO MSG
            JOptionPane.showMessageDialog(null, "Ja tem um usuário com algum campo igual(CPF, USUARIO, RG)", "Cadastro de usuários", JOptionPane.ERROR_MESSAGE);
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
        if(emailcliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo email está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(senhacliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo senha está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
           return;
        }
        if(telefonecliente.trim().isEmpty()) 
        {
           JOptionPane.showMessageDialog(null, "O campo telefone está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
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
        CadastroUsuario usuario = new CadastroUsuario(proximoId(), usuariocliente, nomecliente, cpfcliente, rgcliente, senhacliente, "barbeiro", 
                datanasc, sexocliente, emailcliente, telefonecliente, estadocliente, bairrocliente, enderecocliente, cepcliente);
        new UsuarioDAO().insert(usuario);       
        
        // INFO MSG
        JOptionPane.showMessageDialog(null, "O cadastro foi realizado com sucesso", "Cadastro de usuário", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Limpar Campos
    public void limparCamposUsuario(){
        view.getTextNome().setText("Digite nome do cliente");
        view.getTextCpf().setText("999.999.999-99");
        view.getTextRg().setText("Digite o RG");
        view.getTextDataNasc().setText("22/12/2000");
        view.getTextUsuario().setText("usuario");
        view.getTextSexo().setText("Nenhum");
        view.getTextEmail().setText("email@info.com");
        view.getTextSenha().setText("******");
        view.getTextTelefone().setText("(21) 99999-9999");
        view.getTextEstado().setText("Rio de Janeiro");
        view.getTextBairro().setText("Campo Grande");
        view.getTextEndereco().setText("Rua Exemplo, casa 25");
        view.getTextCep().setText("25092-000");        
    }
    
    public void atualizarCadastroUsuario() {
        int linha = view.getTabelaUsers().getSelectedRow();
        if(linha != -1) {
            // Dados
            String nomecliente = view.getTextNome().getText();
            String cpfcliente = view.getTextCpf().getText();
            String rgcliente = view.getTextRg().getText();
            String datanasc = view.getTextDataNasc().getText();
            String sexocliente = view.getTextSexo().getText();
            String emailcliente = view.getTextEmail().getText();
            String usuariocliente = view.getTextUsuario().getText();
            String senhacliente = view.getTextSenha().getText();
            String telefonecliente = view.getTextTelefone().getText();
            String estadocliente = view.getTextEstado().getText();
            String bairrocliente = view.getTextBairro().getText();
            String enderecocliente = view.getTextEndereco().getText();
            String cepcliente = view.getTextCep().getText();
            
            if(linha == 0){
                JOptionPane.showMessageDialog(null, "Você não pode modificar este usuário", "Erro de atualização", JOptionPane.ERROR_MESSAGE);
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
            if(emailcliente.trim().isEmpty()) 
            {
               JOptionPane.showMessageDialog(null, "O campo email está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
               return;
            }
            if(senhacliente.trim().isEmpty()) 
            {
               JOptionPane.showMessageDialog(null, "O campo senha está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
               return;
            }
            if(telefonecliente.trim().isEmpty()) 
            {
               JOptionPane.showMessageDialog(null, "O campo telefone está vazio.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
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
            CadastroUsuario usuario = new CadastroUsuario(linha, usuariocliente, nomecliente, cpfcliente, rgcliente, senhacliente, "barbeiro", 
                datanasc, sexocliente, emailcliente, telefonecliente, estadocliente, bairrocliente, enderecocliente, cepcliente);
            new UsuarioDAO().update(linha, usuario);     
                  
            // INFO MSG
            JOptionPane.showMessageDialog(null, "O serviço foi atualizado com sucesso", "Cadastro de usuários", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Você precisa selecionar um item na tabela para atualizar.", "Cadastro de usuários", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public void deletarUsuario(){
        int linha = view.getTabelaUsers().getSelectedRow();        
        if(linha != -1)
        {
            if(linha == 0){
                JOptionPane.showMessageDialog(null, "Você não pode deletar este usuário", "Erro de atualização", JOptionPane.ERROR_MESSAGE);
                return;               
            }
            // Remover Array
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.forcedelete(linha);
            
            // INFO MSG
            JOptionPane.showMessageDialog(null, "O usuário foi deletado com sucesso", "Cadastro de usuários", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            // INFO MSG
            JOptionPane.showMessageDialog(null, "Você não pode deletar este usuário ele não é válido.", "Cadastro de usuários", JOptionPane.ERROR_MESSAGE);
        }
    }  
            
    // Auto ID
    private int proximoId()
    {       
        int maiorId = 0;        
        for (CadastroUsuario cliente : Banco.usuario) 
        {           
           int id = cliente.getId();            
            if(maiorId < id){
                maiorId = id;
            }           
        }       
        return maiorId + 1;
    }  
}
