package br.com.alura.ceep.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.List;

import br.com.alura.ceep.R;
import br.com.alura.ceep.dao.NotaDAO;
import br.com.alura.ceep.model.Nota;
import br.com.alura.ceep.recyclerview.adpter.ListaNotasAdapter;


public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);

        NotaDAO dao = new NotaDAO();
        for(int i = 1; i<10000; i++){
            dao.insere(new Nota("Titulo " + i,"descricao " + i));
        }

        List<Nota> todasNotas = dao.todos();

        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        listaNotas.setLayoutManager(LayoutManager);
    }
}
