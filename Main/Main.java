/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controlador.GerenciadoDeTarefas;
import DB.ConexaoBanco;
import DB.ConexaoBancoReal;
import DB.conexaoBancoEmMemoria;
import Modelo.TarefaComPrazo;
import Modelo.TarefaSimples;
import java.util.Scanner;
/**
 *
 * @author Gabriel
 */
// Classe Main para testar o sistema
public class Main {
    public static void main(String[] args) {
        
       /* // Utilizando a conexão real
        ConexaoBanco conexaoReal = new conexaoBancoEmMemoria();
        GerenciadoDeTarefas gerenciadorReal = new GerenciadoDeTarefas(conexaoReal);
        
        gerenciadorReal.conectar();
        gerenciadorReal.adicionarTarefa(new TarefaSimples("Estudar para a prova"));
        gerenciadorReal.adicionarTarefa(new TarefaComPrazo("Projeto de Java", "2024-12-10"));
        gerenciadorReal.exibirTarefas();
        gerenciadorReal.desconectar();
        
        System.out.println("\n---\n");
        */
       
        //Utilizando a conexão real
       
        Scanner sc = new Scanner(System.in);
        ConexaoBanco conexaoReal = new ConexaoBancoReal("jdbc:oracle:thin:@//localhost:1521/XEPDB1","system", "sysdba");
        GerenciadoDeTarefas gerenciador = new GerenciadoDeTarefas(conexaoReal);
        
        gerenciador.conectar();
        
        System.out.println("Informe qual a opcao desejada:");
        System.out.println("1 - Inserir uma tarefa com prazo");
        System.out.println("2 - Inserir uma tarefa simples");
        System.out.println("3 - Listar as tarefas");
        System.out.println("4 - Deletar tarefa");
        System.out.println("5 - Para encerrar o programa");
        int op = sc.nextInt();
        sc.nextLine();
        
        switch(op){
            case 1:
                System.out.println("Informe a tarefa desejada e a data: ");
                String entrada = sc.nextLine();
                String Entprazo = sc.nextLine();
                gerenciador.adicionarTarefa(new TarefaComPrazo(entrada, Entprazo));
                break;
            case 2:
                System.out.println("Informe a tarefa: ");
                String entradaSimples = sc.nextLine();
                gerenciador.adicionarTarefa(new TarefaSimples(entradaSimples));
                break;
            case 3:
                System.out.println("*********** LISTA DE TAREFAS ****************");
                gerenciador.exibirTarefas();
                break;
            case 4:
                System.out.println("Informe qual a data da tarefa: ");
                String data = sc.nextLine();
                gerenciador.deletar(data);
                break;
            case 5:
                System.out.println("Programa encerrado! foi bom te - lo conosco!!!");
                break;
            default:
                System.out.println("Opcao invalida. Tente novamente!");
                return;
        }
        
        gerenciador.desconectar();
    }
}