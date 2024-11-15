# Gerenciador de Tarefas com Conexão ao Banco de Dados Oracle

Este projeto é uma aplicação Java que permite gerenciar tarefas com ou sem prazo. Ele oferece uma estrutura de classes para modelagem de tarefas e operações de banco de dados usando Oracle. As principais funcionalidades incluem adicionar, listar e excluir tarefas.

## Estrutura do Projeto

O projeto é composto pelos seguintes pacotes e classes:

### Pacote `Modelo`
- **Classe `Tarefa`**: Classe abstrata base que define uma tarefa com descrição. Possui o método abstrato `exibirDetalhes()`.
- **Classe `TarefaSimples`**: Extensão de `Tarefa` que representa uma tarefa sem prazo definido.
- **Classe `TarefaComPrazo`**: Extensão de `Tarefa` que representa uma tarefa com prazo, adicionando o atributo `prazo`.

### Pacote `DB`
- **Interface `ConexaoBanco`**: Define métodos para conexão, desconexão, salvar, listar e deletar tarefas.
- **Classe `ConexaoBancoReal`**: Implementação da interface `ConexaoBanco` que conecta ao banco Oracle e executa operações de CRUD.

### Pacote `Controlador`
- **Classe `GerenciadorDeTarefas`**: Gerencia as operações de tarefas utilizando uma instância de `ConexaoBanco`.

## Pré-requisitos

- **Java**: Certifique-se de ter o Java instalado.
- **Oracle Database**: O banco de dados Oracle precisa estar configurado.

## Configuração do Banco de Dados

Configure o banco de dados Oracle e crie a tabela `Tarefas` com a seguinte estrutura:

sql
CREATE TABLE Tarefas (
    id NUMBER PRIMARY KEY,
    descricao VARCHAR2(255),
    prazo VARCHAR2(50)
);
CREATE SEQUENCE TAREFAS_SEQ START WITH 1 INCREMENT BY 1;

## Funcionalidades 

Adicionar Tarefa: Permite adicionar uma nova tarefa ao banco de dados.
Listar Tarefas: Exibe todas as tarefas armazenadas.
Excluir Tarefa: Exclui uma tarefa com base no prazo especificado.
