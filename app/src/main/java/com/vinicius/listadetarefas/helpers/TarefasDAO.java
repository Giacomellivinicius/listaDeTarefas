package com.vinicius.listadetarefas.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.vinicius.listadetarefas.model.Tarefa;

import java.util.List;

public class TarefasDAO implements ITarefasDAO{

    private SQLiteDatabase escritor;
    private SQLiteDatabase leitor;

    public TarefasDAO(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        escritor = dbHelper.getWritableDatabase();
        leitor = dbHelper.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {
        ContentValues values = new ContentValues();
        values.put("nome",tarefa.getTarefa_texto());
        try{
            escritor.insert(DBHelper.TABELA_NOME,null,values);
            Log.i("DB_INFO","Tarefa salva com sucesso");
        }catch(Exception e){
            Log.i("DB_INFO","Erro ao salvar dados: "+e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listas() {
        return null;
    }
}
