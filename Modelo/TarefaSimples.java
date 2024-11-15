/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gabriel
 */
public class TarefaSimples extends Tarefa {

    public TarefaSimples(String descricao) {
        super(descricao);
        this.descricao = descricao;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Descricao da tarefa simples: " + descricao);
    }

}
