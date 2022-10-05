package br.unigran.hello;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void next(View view){
        Intent it = new Intent(this,SegundaActivity.class);
        it.putExtra("Nome","André");
        startActivityForResult(it,50);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==50 && resultCode==80){
            Toast.makeText(getApplicationContext(),"recebi",
                            Toast.LENGTH_SHORT).show();
        }
    }
}