package com.vinicius.listadetarefas.model;

import java.io.Serializable;

public class Tarefa implements Serializable {


    private Long Id;
    private String tarefa_texto;

    public Tarefa(Long id, String tarefa_texto) {
        this.Id = id;
        this.tarefa_texto = tarefa_texto;
    }

    public String getTarefa_texto() {
        return tarefa_texto;
    }

    public void setTarefa_texto(String tarefa_texto) {
        this.tarefa_texto = tarefa_texto;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
