package br.com.alura.ceep.recyclerview.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.alura.ceep.R;
import br.com.alura.ceep.model.Nota;

public class ListaNotasAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Nota> notas;

    public ListaNotasAdapter(Context context, List<Nota> notas) {
        this.context = context;
        this.notas = notas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_nota, parent, false);
        return new NotaViweHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Nota nota = notas.get(position);
        TextView titulo = holder.itemView.findViewById(R.id.item_nota_titulo);
        titulo.setText(nota.getTitulo());
        TextView descricao = holder.itemView.findViewById(R.id.item_nota_descricao);
        descricao.setText(nota.getDescricao());
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    class NotaViweHolder extends RecyclerView.ViewHolder{

        public NotaViweHolder(View itemView) {
            super(itemView);
        }
    }
}
