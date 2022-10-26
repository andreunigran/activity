package br.unigran.hello.crud;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "Banco", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuffer string = new StringBuffer();
        sqLiteDatabase.execSQL(
                "create table cliente(" +
                        "id integer primary key autoincrement," +
                        "nome varchar(120)," +
                        "data_nascimento date," +
                        "saldo numeric(4,2));"
        );

        sqLiteDatabase.execSQL(
                "create table produto(" +
                        "id integer primary key autoincrement," +
                        "nome varchar(120));"
        );

        sqLiteDatabase.execSQL(
                "create table fornecedor(" +
                        "id integer primary key autoincrement," +
                        "nome varchar(120)," +
                        "data_nascimento date," +
                        "nome_fantasia varchar(120));"
        );
     //   sqLiteDatabase.execSQL(string.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
