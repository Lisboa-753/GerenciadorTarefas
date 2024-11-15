/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gabriel
 */
public abstract class Tarefa {
   public String descricao;
    public Tarefa (String descricao){
        this.descricao = descricao;
    }
   
    public abstract void exibirDetalhes();
    
}
