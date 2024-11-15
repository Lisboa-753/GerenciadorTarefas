/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DB;

/**
 *
 * @author Gabriel
 */
// Arquivo: ConexaoBancoEmMemoria.java

import Modelo.Tarefa;
import java.util.ArrayList;

public class conexaoBancoEmMemoria implements ConexaoBanco {
    private ArrayList<Tarefa> tarefas = new ArrayList();

    public conexaoBancoEmMemoria() {
        this.tarefas = new ArrayList<>();
    }

    @Override
    public void conectar() {
        System.out.println("Conexao em memoria estabelecida.");
    }

    @Override
    public void desconectar() {
        System.out.println("Conexao em memoria fechada.");
    }

    @Override
    public void salvarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        System.out.println("Tarefa salva em memoria.");
    }

    @Override
    public void listarTarefas() {
        System.out.println("Listando tarefas em memoria:");
        for (Tarefa tarefa : tarefas) {
            tarefa.exibirDetalhes();
        }
    }
}
