package com.vinicius.listadetarefas.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vinicius.listadetarefas.R;
import com.vinicius.listadetarefas.model.Tarefa;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Tarefa> listaTarefa;

    public Adapter(List<Tarefa> lista){
        this.listaTarefa = lista;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text;

        public MyViewHolder( View itemView){
            super(itemView);
            text = itemView.findViewById(R.id.adapterTextView);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_tarefa,parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tarefa tarefa = listaTarefa.get(position);

        holder.text.setText(tarefa.getTarefa_texto());

    }

    @Override
    public int getItemCount() {
        return this.listaTarefa.size();
    }



}
