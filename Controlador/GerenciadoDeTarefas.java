/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DB.ConexaoBanco;
import Modelo.Tarefa;

/**
 *
 * @author Gabriel
 */
public class GerenciadoDeTarefas {
    private ConexaoBanco  conexaoBanco;
    
    public GerenciadoDeTarefas(ConexaoBanco conexao){
        this.conexaoBanco = conexao;
    }
    
    public void conectar(){
        conexaoBanco.conectar();
    }
    
    public void desconectar(){
        conexaoBanco.desconectar();
    }
    
    public void adicionarTarefa(Tarefa tarefa){
        conexaoBanco.salvarTarefa(tarefa);
    }
    
    public void exibirTarefas(){
        conexaoBanco.listarTarefas();
    }
    
    public void deletar(String prazo){
        conexaoBanco.delecaoTarefas(prazo);
    }
    
}
