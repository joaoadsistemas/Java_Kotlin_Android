package devandroid.silveira.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import devandroid.silveira.appgaseta.model.Combustivel;

public class GasEtaDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "gaseta.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // QUERY SQL para criar uma tabela
        String sqlTabelaCombustivel = "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeDoCombustivel TEXT, " +
                "precoDoCombustivel REAL, " +
                "recomendacao TEXT)";

        db.execSQL(sqlTabelaCombustivel);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarObjeto(String tabela, ContentValues dados){

        db.insert(tabela, null, dados);

    }


    public List<Combustivel> listarDados() {

        List<Combustivel> lista = new ArrayList<>();

        // Representa um registro que está salvo na tabela de combustivel do Banco de Dados
        Combustivel registro;

        String querySQL = "SELECT * FROM Combustivel";

        cursor = db.rawQuery(querySQL, null);

        if (cursor.moveToFirst()) {

            do {

                registro = new Combustivel();

                registro.setId(cursor.getInt(0));
                registro.setNomeDoCombustivel(cursor.getString(1));
                registro.setPrecoDoCombustivel(cursor.getDouble(2));
                registro.setRecomendacao(cursor.getString(3));

                lista.add(registro);

            } while (cursor.moveToNext());

        }

        return lista;

    }

    public void alterarObjeto(String tabela, ContentValues dados) {

        int id = dados.getAsInteger("id");

        db.update(tabela, dados, "id = ?", new String[]{Integer.toString(id)});

    }

    public void deletarObjeto(String tabela, int id) {

      db.delete(tabela, "id=?", new String[]{Integer.toString(id)});

    }


    // Criar métodos para implementar um CRUD
    // C = Create criar o banco de dados e as  tabelas
    // Create database nome_do_banco_de_dados.db (SQL)
    // 1 - Nome do banco de dados
    // 2 - Versão do Banco de Dados



    // Create table (SQL)


    // R = Retrieve recuperar os dados salvo nas tabelas
    // Select * from table (SQL)

    // U = Update aalterar os dados que já existem em um registro na tabela
    // Update from table (SQL)



}
