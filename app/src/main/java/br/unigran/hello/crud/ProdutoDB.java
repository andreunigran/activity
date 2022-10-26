package br.unigran.hello.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unigran.hello.domain.Produto;

public class ProdutoDB {
    DBHelper db;
    private SQLiteDatabase conexao;
    public ProdutoDB(DBHelper db) {
        this.db = db;
    }

    public void insert(Produto produto) {
        conexao = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", produto.getNome());

        conexao.insertOrThrow("produto", null, values);
        conexao.close();
    }

    public void list(List data) {
        data.clear();
        conexao = db.getReadableDatabase();

        String names[] = {"id", "nome"};
        Cursor query = conexao.query(
                "produto", names, null, null, null, null,
                null
        );

        while(query.moveToNext()) {
            Produto produto = new Produto();
            produto.setId(Integer.parseInt(query.getString(0)));
            produto.setNome(query.getString(1));

            data.add(produto);
        }

        conexao.close();
    }

    public void remove(Integer id) {
        conexao = db.getWritableDatabase();
        conexao.delete("produto", "id=?", new String[]{ id+"" });
        conexao.close();
    }
}
