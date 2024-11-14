/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.util.ArrayList;
import model.Agendamento;
import model.CadastroCliente;
import model.CadastroServico;
import model.CadastroUsuario;

/**
 *
 * @author Thalles
 */
public class Banco {
    
    public static ArrayList<CadastroUsuario> usuario;
    public static ArrayList<CadastroCliente> cliente;
    public static ArrayList<CadastroServico> servico;
    public static ArrayList<Agendamento> agendamento;
    
    public static void inicia(){
    
        // Instancia os Objetos
        usuario = new ArrayList<>();
        cliente = new ArrayList<>();
        servico = new ArrayList<>();
        agendamento = new ArrayList<>();
        
        // Criando Banco de dados de testes
        CadastroUsuario usuario1 = new CadastroUsuario(0, "admin", "Administrador", "17125218709", "273745660", "root", "admin", "23/06/1998", "M", "admin@root.com", "21980997790", "RJ", "CP", "Rua 1", "239999");
        usuario.add(usuario1);
        
        // Serviço Beta
        CadastroServico servico1 = new CadastroServico(0, "Barba", 25);
        servico.add(servico1);
    } 
    
}
