package com.vinicius.listadetarefas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.vinicius.listadetarefas.R;
import com.vinicius.listadetarefas.helpers.TarefasDAO;
import com.vinicius.listadetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText textTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        textTarefa = findViewById(R.id.textTarefa);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_salvar:
                TarefasDAO tarefaDAO = new TarefasDAO(getApplicationContext());
                Tarefa tarefa = new Tarefa(null,textTarefa.getText().toString());
                tarefaDAO.salvar(tarefa);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}