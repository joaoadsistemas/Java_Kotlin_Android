package devandroid.silveira.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import devandroid.silveira.applistacurso.model.Pessoa;
import devandroid.silveira.applistacurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_lista_vip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    public void salvar(Pessoa p1) {
        Log.d("CONTROLLER MVC", "SALVO " + p1.toString());
        listaVip.putString("primeiroNome", p1.getPrimeiroNome());
        listaVip.putString("sobrenome", p1.getSobrenome());
        listaVip.putString("nomeCurso", p1.getCursoDesejado());
        listaVip.putString("telefoneContato", p1.getTelefoneContato());
        listaVip.apply();
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }

    public Pessoa buscar(Pessoa p1) {
        p1.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        p1.setSobrenome(preferences.getString("sobrenome", ""));
        p1.setCursoDesejado(preferences.getString("nomeCurso", ""));
        p1.setTelefoneContato(preferences.getString("telefoneContato", ""));

        return p1;
    }
}
