package com.czpla.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public class ContatoController extends DataBaseAdapter{

    public ContatoController(Context context) {
        // integração com o banco de dados
        super(context);
    }

    public boolean create(Contato contato) {
        ContentValues values = new ContentValues();
        values.put("nome", contato.getNome());
        values.put("email", contato.getEmail());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean isCreate = db.insert("contato", null, values) > 0;
        db.close();

        return isCreate;
    }

    public int totalDeContato() {
        return 0;
    }

    public List<Contato> listarContato() {
        return null;
    }

    public Contato buscarPeloID(int contatoID){
        return null;
    }

    public boolean update(Contato contato) {
        return true;
    }

    public boolean delete(Contato contatoID) {
        return true;
    }
}
