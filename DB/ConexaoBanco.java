/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DB;

import Modelo.Tarefa;

/**
 *
 * @author Gabriel
 */
public interface ConexaoBanco {
    
    public abstract void conectar();
    
    public abstract void desconectar();
    
    public abstract void salvarTarefa(Tarefa tarefa);
    
    public abstract void listarTarefas();
    
    public abstract void delecaoTarefas(String prazo);
}
