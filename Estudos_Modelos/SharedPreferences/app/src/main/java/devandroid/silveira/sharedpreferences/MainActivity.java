package devandroid.silveira.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    public static final String TAG = "TAG";

    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    public static final String PREF_NOME = "SharedPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CRIAR PASTA DO SHAREDPREFERENCES NO DATA
        sharedPreferences = getSharedPreferences(PREF_NOME, 0);

        // Posso editar os dados agora
        dados = sharedPreferences.edit();

        nomeProduto = "Notebook";
        codigoProduto = 1245;
        precoProduto = 7.456f;
        estoque = true;

        dados.putString("nomeProduto", nomeProduto);
        dados.putInt("codigoProduto", codigoProduto);
        dados.putFloat("precoProduto", precoProduto);
        dados.putBoolean("estoque", estoque);

        //Salvar Informações no XML
        dados.apply();

        // Pegando os dados salvos
        Log.d(TAG, "Dados recuperados sharedPreferences: " + sharedPreferences.getString("nomeProduto",""));



    }
}