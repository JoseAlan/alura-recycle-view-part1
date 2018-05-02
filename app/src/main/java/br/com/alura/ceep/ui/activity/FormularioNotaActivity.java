package br.com.alura.ceep.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

import br.com.alura.ceep.R;
import br.com.alura.ceep.model.Nota;

import static br.com.alura.ceep.ui.activity.NotasActivityConstantes.CHAVE_NOTA;
import static br.com.alura.ceep.ui.activity.NotasActivityConstantes.RESULT_CODE_NOTA_CRIADA;

public class FormularioNotaActivity extends AppCompatActivity {

    private int posicaoNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_nota);


        Intent dadosRecebidos = getIntent();
        if(dadosRecebidos.hasExtra(CHAVE_NOTA) && dadosRecebidos.hasExtra("posicao")){
            Nota notaRecebida = (Nota) dadosRecebidos.getSerializableExtra(CHAVE_NOTA);
            posicaoNota = dadosRecebidos.getIntExtra("posicao", -1);
            TextView titulo = findViewById(R.id.formulario_nota_titulo);
            titulo.setText(notaRecebida.getTitulo());
            TextView descricao = findViewById(R.id.formulario_nota_descricao);
            descricao.setText(notaRecebida.getDescricao());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_salvar_nota, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(ehMenuSalvaNota(item)){
            Nota notaCriada = criaNota();
            retornaNota(notaCriada);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void retornaNota(Nota nota) {
        Intent resultadoInserido = new Intent();
        resultadoInserido.putExtra(CHAVE_NOTA, nota);
        resultadoInserido.putExtra("posicao", posicaoNota);
        setResult(RESULT_CODE_NOTA_CRIADA, resultadoInserido);
    }

    @NonNull
    private Nota criaNota() {
        EditText titulo = findViewById(R.id.formulario_nota_titulo);
        EditText descricao = findViewById(R.id.formulario_nota_descricao);
        return new Nota(titulo.getText().toString(), descricao.getText().toString());
    }

    private boolean ehMenuSalvaNota(MenuItem item) {
        return item.getItemId() == R.id.menu_formulario_nota_ic_salva;
    }
}
