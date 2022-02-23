package com.vinicius.listadetarefas.helpers;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.vinicius.listadetarefas.model.Tarefa;

import java.util.ArrayList;
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
    public List<Tarefa> listar() {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM "+DBHelper.TABELA_NOME+" ;";
        Cursor cursor = leitor.rawQuery(sql, null);

        while(cursor.moveToNext()){
            Tarefa tarefa = new Tarefa(cursor.getLong(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")));

//            Long id = cursor.getLong(cursor.getColumnIndex("id"));
//            String texto = cursor.getString(cursor.getColumnIndex("nome"));
//
//            tarefa.setId(id);
//            tarefa.setTarefa_texto(texto);

            if(tarefas.add(tarefa)){
                Log.i("DB_HELPER_INFO","Tarefa recuperada");
            }
        }
        return tarefas;
    }
}
