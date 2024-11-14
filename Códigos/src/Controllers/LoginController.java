/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import Controllers.helpers.LoginHelper;
import Model.DAO.UsuarioDAO;
import View.Login;
import View.MenuPrincipal;
import javax.swing.JOptionPane;
import model.CadastroUsuario;

/**
 *
 * @author thall
 */
public class LoginController {
    
    // Var
    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrar(){
        
        // Pegar Dados
        CadastroUsuario usuario = helper.obterModelo();
        
        // Verificar dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CadastroUsuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        
        // Verificar Usuário
        if(usuarioAutenticado != null){
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
            
            // INFO MSG
            JOptionPane.showMessageDialog(null, "O seu login foi realizado com sucesso", "Sistema de login", JOptionPane.INFORMATION_MESSAGE);
        }
        else { 
            JOptionPane.showMessageDialog(null, "Você digitou seu email ou senha errado, tente novamente.", "Sistema de login", JOptionPane.ERROR_MESSAGE);
        }
    }
}
