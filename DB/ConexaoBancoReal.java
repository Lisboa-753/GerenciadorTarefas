/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DB;

/**
 *
 * @author Gabriel
 */
// Arquivo: ConexaoBancoReal.java

import Modelo.Tarefa;
import Modelo.TarefaComPrazo;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.lang.model.util.Types;
import java.sql.PreparedStatement;
import java.sql.*;


public class ConexaoBancoReal implements ConexaoBanco {
    private Connection conexao;
    private String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    private String USER = "system";
    private String PASSWORD = "sysdba";

    public ConexaoBancoReal(String url, String user, String password) {
        this.URL = url;
        this.USER = user;
        this.PASSWORD = password;
    }

    @Override
    public void conectar() {
        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexao com o banco de dados estabelecida.");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
    }

    @Override
    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexao com o banco de dados fechada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar do banco de dados: " + e.getMessage());
        }
    }
 
    @Override
    public void salvarTarefa(Tarefa tarefa) {
    String sql = "INSERT INTO Tarefas (id, descricao, prazo) VALUES (TAREFAS_SEQ.NEXTVAL, ?, ?)";
    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
        stmt.setString(1, tarefa.descricao);
        if (tarefa instanceof TarefaComPrazo) {
            stmt.setString(2, ((TarefaComPrazo) tarefa).getPrazo());
        } else {
            stmt.setNull(2, java.sql.Types.CHAR);
        }
        stmt.executeUpdate();
        System.out.println("Tarefa salva no Oracle.");
    } catch (SQLException e) {
        System.out.println("Erro ao salvar tarefa: " + e.getMessage());
    }
}

    @Override
    public void listarTarefas() {
        String sql = "SELECT descricao, prazo FROM Tarefas ";  
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            String sql2 = "SELECT NULL FROM DUAL";
            if (!rs.isBeforeFirst()) { // retorna false se não houver nenhuma linha no ResultSet
                System.out.println("Nenhuma tarefa encontrada.");
                return;
            } else {
            while (rs.next()) {
                String descricao = rs.getString("descricao");
                String prazo = rs.getString("prazo");
                System.out.println("Descricao: " + descricao);
                System.out.println("Prazo: " + prazo);
            }
        } 
        } catch (SQLException e) {
            System.out.println("Erro ao listar tarefas: " + e.getMessage());
        }
    }

    @Override
    public void delecaoTarefas(String prazo) {
    String sql = "DELETE FROM Tarefas WHERE prazo = ?";
    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
        // Define o parâmetro para o prazo da tarefa a ser deletada
        stmt.setString(1, prazo);

        // Executa a instrução de deleção
        int rowsAffected = stmt.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Tarefa(s) com prazo " + prazo + " deletada(s) com sucesso.");
        } else {
            System.out.println("Nenhuma tarefa encontrada com o prazo especificado.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao deletar tarefa: " + e.getMessage());
    }
}

    
}
