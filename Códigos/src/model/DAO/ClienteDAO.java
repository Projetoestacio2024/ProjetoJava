/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.util.ArrayList;
import model.CadastroCliente;

/**
 *
 * @author Thalles
 */
public class ClienteDAO {
        
    /**
     * Insere um cliente dentro do banco de dados
     * @param cliente exige que seja passado um objeto do tipo cliente
     */
    public void insert(CadastroCliente cliente){
        Banco.cliente.add(cliente);
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param cliendid
     * @param cliente
     * @return 
     */
    public boolean update(int cliendid, CadastroCliente cliente){
        Banco.cliente.set(cliendid, cliente);
        return true; 
    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do cliente passado
     * @param cliente
     * @return 
     */
    public boolean delete(CadastroCliente cliente){
        for (CadastroCliente clienteLista : Banco.cliente) {
            if(idSaoIguais(clienteLista,cliente)){
                Banco.cliente.remove(clienteLista);
                return true;
            }
        }
        return false;
    }
    
    public void forcedelete(int clienteid){
        Banco.cliente.remove(clienteid);
    } 
    
    public void forceupdate(Integer id, String usuario, String nome, String cpf, 
            String rg, String datanascimento, String sexo, String email, String telefone, 
            String estado, String bairro, String endereco, String cep)
    {
        
        Banco.cliente.get(0).setNome(nome);
        Banco.cliente.get(0).setCpf(cpf);
        Banco.cliente.get(0).setRg(rg);
        Banco.cliente.get(0).setSexo(sexo);
        Banco.cliente.get(0).setEmail(email);
        Banco.cliente.get(0).setTelefone(telefone);
        Banco.cliente.get(0).setEstado(estado);
        Banco.cliente.get(0).setBairro(bairro);
        Banco.cliente.get(0).setEndereco(endereco);
        Banco.cliente.get(0).setCep(cep);        
    }
    
    /**
     * Retorna um arraylist com todos os clientes do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<CadastroCliente> selectAll(){
        return Banco.cliente;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param cliente
     * @param clienteAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(CadastroCliente cliente, CadastroCliente clienteAComparar) {
        return cliente.getId() ==  clienteAComparar.getId();
    }

    public void selectall() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }         
}
