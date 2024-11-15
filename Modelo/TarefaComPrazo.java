/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gabriel
 */
public class TarefaComPrazo extends Tarefa{
    private String prazo;
    
    public TarefaComPrazo(String descricao, String prazo) {
        super(descricao);
        this.prazo = prazo;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Prazo da tarefa " + prazo);
    }
    public String getPrazo(){
        return prazo;
    }
    
}
