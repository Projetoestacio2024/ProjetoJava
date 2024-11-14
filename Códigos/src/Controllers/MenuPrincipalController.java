/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import View.Agenda;
import View.Cliente;
import View.Login;
import View.MenuPrincipal;
import View.Servico;
import View.Usuario;

/**
 *
 * @author thall
 */
public class MenuPrincipalController {
    
    // View Var
    private final MenuPrincipal view;
    public MenuPrincipalController(MenuPrincipal view){
        this.view = view;
    }
    
    // Abrir Agenda - Opção do menu
    public void abrirAgenda(){
        this.view.dispose();
        Agenda agenda = new Agenda();
        agenda.setVisible(true);
    }
    
    // Abrir Cadastro Cliente
    public void abrirCadastroClientes(){
        Cliente cliente = new Cliente();
        cliente.setVisible(true);
    }
    
   // Abrir cad usuario
    public void abrirCadastroUsuario(){
        Usuario usuario = new Usuario();
        usuario.setVisible(true);
    }
    
    // Abrir Servido ADD
    public void abrirCadastroServicos(){
        Servico servico = new Servico();
        servico.setVisible(true);
    }
    public void desconectarConta(){
        Login Login = new Login();
        Login.setVisible(true);
    }       
}
