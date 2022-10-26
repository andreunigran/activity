package br.unigran.hello.activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.unigran.hello.R;
import br.unigran.hello.domain.Produto;
import br.unigran.hello.fragmento.CadastroCliente;
import br.unigran.hello.fragmento.CadastroFornecedor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void segundaTela(View view){
        switch (view.getId()){
            case R.id.idFornecedor:
                startActivity(new Intent(this,SegundaActivity.class)
                        .putExtra("fragmento", "Fornecedor"));
                break;
            case R.id.idCliente:
                startActivity(new Intent(this,SegundaActivity.class).
                        putExtra("fragmento", "Cliente"));
                break;
            case R.id.idProduto:
                startActivity(new Intent(this,SegundaActivity.class).
                        putExtra("fragmento", "Produto"));
                break;
        }

    }
    public void sair(View view){
        finish();
    }
 /*   public void next(View view){
        Intent it = new Intent(this,SegundaActivity.class);
        it.putExtra("Nome","André");
        resultLauncher.launch(it);
    }
    ActivityResultLauncher resultLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>(){
                        @Override
                        public void onActivityResult(ActivityResult result) {
                           if(result.getResultCode()==80)
                            Toast.makeText(getApplicationContext(),
                                    "retorno",Toast.LENGTH_SHORT).show();
                        }
                    });
*/

}