package com.vinicius.listadetarefas.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_Tarefas";
    public static String TABELA_NOME = "tarefas";

    public DBHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS "+ TABELA_NOME +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nome TEXT NOT NULL);" ;

        try{
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+NOME_DB+"."+TABELA_NOME+";");
            sqLiteDatabase.execSQL(sql);
            Log.i("DBHELPER_INFO","Tabela criada com sucesso");
        }catch(Exception e){
            Log.i("DBHELPER_INFO:","Erro ao criar tabela"+e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String sql = "DROP TABLE IF EXISTS "+TABELA_NOME + " ;";

        try{
            sqLiteDatabase.execSQL(sql);
            onCreate(sqLiteDatabase);
            Log.i("DBHELPER_INFO","Tabela alterada com sucesso");
        }catch(Exception e){
            Log.i("DBHELPER_INFO:","Erro ao alterar tabela"+e.getMessage() );
        }

    }
}
