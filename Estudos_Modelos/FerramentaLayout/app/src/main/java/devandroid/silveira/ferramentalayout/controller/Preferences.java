package devandroid.silveira.ferramentalayout.controller;

import android.content.Context;
import android.content.SharedPreferences;

import devandroid.silveira.ferramentalayout.model.Usuario;


public class Preferences {


    private SharedPreferences sharedPreferences;

    private SharedPreferences.Editor dados;

    public static final String PREF_NOME = "SharedPreferences";

    public Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NOME, 0);
        dados = sharedPreferences.edit();
    }


    public void saveSharedPreferences(Usuario usuario) {
        dados.putString("nome", usuario.getNome());
        dados.apply();
    }


    public String getSharedPreferences(String key) {
        String dadoNome;

       return sharedPreferences.getString(key, "NOME NÃO IDENTIFICADO");




    }

}
