package model;

/**
 *
 * @author Thalles
 */
public class CadastroUsuario extends Pessoa{
    protected String senha;
    protected String nivelAcesso;
    protected String estado;
    protected String bairro;
    protected String endereco;
    protected String cep; 

    public CadastroUsuario(Integer id, String usuario, String senha) {
        super(id, usuario);
        this.senha = senha;
    }

    public CadastroUsuario(Integer id, String usario, String nome, String cpf, String rg, String senha, String nivelAcesso, String datanascimento, String sexo, String email, String telefone,
            String estado, String bairro, String endereco, String cep) {
        super(id, usario, nome, cpf, rg, datanascimento, sexo, email, telefone);
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
        this.estado = estado;
        this.bairro = bairro;        
        this.endereco = endereco;
        this.cep = cep;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
}