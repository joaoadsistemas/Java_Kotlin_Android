package devandroid.silveira.appgaseta.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GasEtaDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "gaseta.db";
    public static final int DB_VERSION = 1;

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
