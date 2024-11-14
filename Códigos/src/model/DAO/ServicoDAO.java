/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.util.ArrayList;
import model.CadastroServico;

/**
 *
 * @author Thalles
 */
public class ServicoDAO {
    
    
    /**
     * Insere um servico dentro do banco de dados
     * @param servico exige que seja passado um objeto do tipo servico
     */
    public void insert(CadastroServico servico){
        Banco.servico.add(servico);
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param servico
     * @return 
     */
    public boolean update(CadastroServico servico){
        
        for (int i = 0; i < Banco.servico.size(); i++) {
            if(idSaoIguais(Banco.servico.get(i),servico)){
                Banco.servico.set(i, servico);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do servico passado
     * @param servico
     * @return 
     */
    public boolean delete(CadastroServico servico){
        for (CadastroServico servicoLista : Banco.servico) {
            if(idSaoIguais(servicoLista,servico)){
                Banco.servico.remove(servicoLista);
                return true;
            }
        }
        return false;
    }
    
    public void forcedelete(int servicoid){
        Banco.servico.remove(servicoid);
    }    
    public void forceupdate(int servicoid, String descricao, float preco)
    {
        Banco.servico.get(servicoid).setDescricao(descricao);
        Banco.servico.get(servicoid).setValor(preco);
    }
    
    /**
     * Retorna um arraylist com todos os servicos do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<CadastroServico> selectAll(){
        return Banco.servico;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param servico
     * @param servicoAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(CadastroServico servico, CadastroServico servicoAComparar) {
        return servico.getId() ==  servicoAComparar.getId();
    }
    
}
