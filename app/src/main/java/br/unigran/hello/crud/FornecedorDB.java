package br.unigran.hello.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unigran.hello.domain.Fornecedor;

public class FornecedorDB {
    DBHelper db;
    private SQLiteDatabase conexao;
    public FornecedorDB(DBHelper db) {
        this.db = db;
    }

    public void insert(Fornecedor fornecedor) {
        conexao = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", fornecedor.getNome());

        conexao.insertOrThrow("fornecedor", null, values);
        conexao.close();
    }

    public void list(List data) {
        data.clear();
        conexao = db.getReadableDatabase();

        String names[] = {"id", "nome"};
        Cursor query = conexao.query(
                "fornecedor", names, null, null, null, null,
                null
        );

        while(query.moveToNext()) {
            Fornecedor Fornecedor = new Fornecedor();
            Fornecedor.setId(Integer.parseInt(query.getString(0)));
            Fornecedor.setNome(query.getString(1));

            data.add(Fornecedor);
        }

        conexao.close();
    }

    public void remove(Integer id) {
        conexao = db.getWritableDatabase();
        conexao.delete("fornecedor", "id=?", new String[]{ id+"" });
        conexao.close();
    }
}
