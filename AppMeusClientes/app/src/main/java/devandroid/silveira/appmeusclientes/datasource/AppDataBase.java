package devandroid.silveira.appmeusclientes.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import devandroid.silveira.appmeusclientes.core.AppUtil;
import devandroid.silveira.appmeusclientes.datamodel.ClienteDataModel;
import devandroid.silveira.appmeusclientes.datamodel.ProdutoDataModel;
import devandroid.silveira.appmeusclientes.model.Cliente;


public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "AppMeusClientes.sqlite";

    private static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ClienteDataModel.criarTabela());
        db.execSQL(ProdutoDataModel.criarTabela());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        try {

            db.insert(tabela, null, dados);

        } catch (Exception e) {

            Log.e(AppUtil.TAG, "insert: " + e.getMessage() );

        }


    }

    public void deleteByID(String tabela, int id) {

        db = getWritableDatabase();

        try {

            db.delete(tabela, "id = ? ",new String[]{String.valueOf(id)});

        } catch (Exception e) {

            Log.e(AppUtil.TAG, "delete: " + e.getMessage() );

        }

    }

    public void update(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        try {

            db.update(tabela, dados, "id = ? ",new String[]{String.valueOf(dados.get("id"))});

        } catch (Exception e) {

            Log.e(AppUtil.TAG, "update: " + e.getMessage() );

        }

    }

    public List<Cliente> getAllClientes(String tabela) {

        db = getWritableDatabase();

        List<Cliente> clientes = new ArrayList<>();

        Cliente obj;

        String sql = "SELECT * FROM " + tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new Cliente();

                obj.setId(cursor.getInt(0));
                obj.setNome(cursor.getString(1));
                obj.setEmail(cursor.getString(2));

                Log.e("LISTADB", "Clientes: " +  obj.getEmail()+ " " + obj.getNome() + " " + obj.getId());

                clientes.add(obj);

            } while (cursor.moveToNext());

        }

        return clientes;

    }

}
