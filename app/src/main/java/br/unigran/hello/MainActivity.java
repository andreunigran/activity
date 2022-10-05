package br.unigran.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void next(View view){
        Intent it = new Intent(this,SegundaActivity.class);
        it.putExtra("Nome","André");

        startActivity(it);
    }
}