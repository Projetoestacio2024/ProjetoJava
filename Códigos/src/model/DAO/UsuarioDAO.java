/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.CadastroUsuario;

/**
 *
 * @author Thalles
 */
public class UsuarioDAO {
    
    private String loginusado;
    private String senhausado;
    private Integer idusado;
    
    /**
     * Insere um usuario dentro do banco de dados
     * @param usuario exige que seja passado um objeto do tipo usuario
     */
    public void insert(CadastroUsuario usuario){
        Banco.usuario.add(usuario);
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param usuarioid
     * @param usuario
     * @return 
     */
    public boolean update(int usuarioid ,CadastroUsuario usuario){
        Banco.usuario.set(usuarioid, usuario);
        return true;
    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do usuario passado
     * @param usuario
     * @return 
     */
    public boolean delete(CadastroUsuario usuario){
        for (CadastroUsuario usuarioLista : Banco.usuario) {
            if(idSaoIguais(usuarioLista,usuario)){
                Banco.usuario.remove(usuarioLista);
                return true;
            }
        }
        return false;
    }
    
    public void forcedelete(int servicoid){
        Banco.usuario.remove(servicoid);
    }    
    
    public void forceupdateUsuario(Integer id, String usuario, String nome, String cpf, String rg, String senha, String datanascimento, String sexo, String email, String telefone)
    {
        Date newdata;
        try {
            newdata = new SimpleDateFormat("dd/mm/yyyy").parse(datanascimento);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "O campo de data está inválido.", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Banco.usuario.get(id).setUsuario(usuario);
        Banco.usuario.get(id).setNome(nome);
        Banco.usuario.get(id).setCpf(cpf);
        Banco.usuario.get(id).setRg(rg);
        Banco.usuario.get(id).setSenha(senha);        
        Banco.usuario.get(id).setDatanascimento(newdata);
        Banco.usuario.get(id).setSexo(sexo);
        Banco.usuario.get(id).setEmail(email);
        Banco.usuario.get(id).setTelefone(telefone);
    }
    
   /* public CadastroUsuario(Integer id, String usario, String nome, String cpf, String rg, String senha, String nivelAcesso, String datanascimento, String sexo, String email, String telefone) {
        super(id, usario, nome, cpf, rg, datanascimento, sexo, email, telefone);
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }*/
    
    /**
     * Retorna um arraylist com todos os usuarios do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<CadastroUsuario> selectAll(){
        return Banco.usuario;
    }
    
    /**
     * Retorna um Objeto do tipo usuario se a funcao encontrar o usuario passado como parâmetro no banco, para considerar sao usado nome e senha
     * @param usuario
     * @return CadastroUsuario encontrado no banco de dados
     */
    public CadastroUsuario selectPorNomeESenha(CadastroUsuario usuario){
        for (CadastroUsuario usuarioLista : Banco.usuario) {
            if(nomeESenhaSaoIguais(usuarioLista,usuario)){
                return usuarioLista;
            }
        }
        return null;
    }

    /**
     * Recebe dois objetos e verifica se são iguais verificando o nome e senha
     * @param usuario
     * @param usuarioAPesquisar
     * @return verdadeiro caso sejam iguais e falso caso nao forem iguais
     */
    private boolean nomeESenhaSaoIguais(CadastroUsuario usuario, CadastroUsuario usuarioAPesquisar) {
        return usuario.getUsuario().equals(usuarioAPesquisar.getUsuario()) && usuario.getSenha().equals(usuarioAPesquisar.getSenha());
    }

    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param usuario
     * @param usuarioAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(CadastroUsuario usuario, CadastroUsuario usuarioAComparar) {
        return usuario.getId() ==  usuarioAComparar.getId();
    }

    public String getLoginusado() {
        return loginusado;
    }

    public void setLoginusado(String loginusado) {
        this.loginusado = loginusado;
    }

    public String getSenhausado() {
        return senhausado;
    }

    public void setSenhausado(String senhausado) {
        this.senhausado = senhausado;
    }

    public Integer getIdusado() {
        return idusado;
    }

    public void setIdusado(Integer idusado) {
        this.idusado = idusado;
    }
    
    
    
}
