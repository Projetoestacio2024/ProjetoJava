/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.helpers;
import model.CadastroUsuario;
import View.Login;

/**
 *
 * @author thall
 */
public class LoginHelper implements IHelper {
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
   
    public void setarModelo(CadastroUsuario modelo){
        String nome = modelo.getUsuario();
        String senha = modelo.getSenha();        
        view.getTextUser().setText(nome);
        view.getTextSenha().setText(senha);
    }
    
    @Override
    public CadastroUsuario obterModelo(){        
        String nome = view.getTextUser().getText();
        char[] senhaCharArray = view.getTextSenha().getPassword();
        //String senha = view.getTextSenha().getText();
        String senha = new String(senhaCharArray);
        CadastroUsuario modelo = new CadastroUsuario(0, nome, senha);
        return modelo;       
    }
    
    @Override
    public void limparTela(){
        view.getTextUser().setText("");
        view.getTextSenha().setText("");
    }  
}
