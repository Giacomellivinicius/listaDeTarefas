package com.vinicius.listadetarefas.helpers;

import com.vinicius.listadetarefas.model.Tarefa;

import java.util.List;

public interface ITarefasDAO {

    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listas();

}
