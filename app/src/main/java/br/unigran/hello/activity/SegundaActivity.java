package br.unigran.hello.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

import br.unigran.hello.R;
import br.unigran.hello.crud.ClienteDB;
import br.unigran.hello.crud.DBHelper;
import br.unigran.hello.crud.FornecedorDB;
import br.unigran.hello.crud.ProdutoDB;
import br.unigran.hello.fragmento.CadastroCliente;
import br.unigran.hello.fragmento.CadastroFornecedor;
import br.unigran.hello.fragmento.CadastroProduto;
import br.unigran.hello.fragmento.Listagem;

public class SegundaActivity extends AppCompatActivity {

    Fragment fragmento;
Listagem listagem;
DBHelper db;
    ArrayAdapter adapter;
    private String acao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        db = new DBHelper(this);
        setContentView(R.layout.activity_segunda);

        getSupportActionBar().setElevation(0);
        listagem=new Listagem();
        acao=getIntent().getStringExtra("fragmento");
        fragmento=criaFragmento(acao);

        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();//cria transacao
        transaction.add(R.id.idframe,listagem);//add fragmento
        transaction.commit();//valida a adição
        findViewById(R.id.idLista);

    }

    public Fragment criaFragmento(String nome){
       switch (nome){
           case "Fornecedor":
               fragmento=new CadastroFornecedor();

               break;
           case "Produto":
               fragmento=new CadastroProduto();
               break;
           case "Cliente":
               fragmento=new CadastroCliente();
               break;
       }
        return fragmento;
    }
    public void segundaTela(View view){
        getSupportFragmentManager().beginTransaction().//cria transacao
        replace(R.id.idframe,fragmento)//add fragmento
        .commit();//valida a adição
    }
    public void primeiraTela(View view){
        getSupportFragmentManager().beginTransaction().//cria transacao
                replace(R.id.idframe,listagem)//add fragmento
                .commit();//valida a adição
      switch (acao){
          case "Fornecedor":
              new FornecedorDB(db).list(listagem.getDados());
              break;
          case "Produto":
              new ProdutoDB(db).list(listagem.getDados());
              break;
          case "Cliente":
              new ClienteDB(db).list(listagem.getDados());
              break;

      }
        listagem.atualizaAdapter();
    }
}