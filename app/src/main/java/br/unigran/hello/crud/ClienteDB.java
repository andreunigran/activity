package br.unigran.hello.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unigran.hello.domain.Cliente;
import br.unigran.hello.domain.Produto;

public class ClienteDB {
    DBHelper db;
    private SQLiteDatabase conexao;
    public ClienteDB(DBHelper db) {
        this.db = db;
    }

    public void insert(Cliente cliente) {
        conexao = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());

        conexao.insertOrThrow("cliente", null, values);
        conexao.close();
    }

    public void list(List data) {
        data.clear();
        conexao = db.getReadableDatabase();

        String names[] = {"id", "nome"};
        Cursor query = conexao.query(
                "cliente", names, null, null, null, null,
                null
        );

        while(query.moveToNext()) {
            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(query.getString(0)));
            cliente.setNome(query.getString(1));

            data.add(cliente);
        }

        conexao.close();
    }

    public void remove(Integer id) {
        conexao = db.getWritableDatabase();
        conexao.delete("cliente", "id=?", new String[]{ id+"" });
        conexao.close();
    }
}
