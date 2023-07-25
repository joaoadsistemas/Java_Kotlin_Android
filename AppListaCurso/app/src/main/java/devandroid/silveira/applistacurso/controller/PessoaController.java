package devandroid.silveira.applistacurso.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.List;

import devandroid.silveira.applistacurso.database.AppListaVipDB;
import devandroid.silveira.applistacurso.model.Pessoa;
import devandroid.silveira.applistacurso.view.MainActivity;

public class PessoaController extends AppListaVipDB {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_lista_vip";

    public PessoaController(MainActivity mainActivity) {
        super(mainActivity);

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    public void salvar(Pessoa p1) {


        ContentValues dados = new ContentValues();

        Log.d("CONTROLLER MVC", "SALVO " + p1.toString());
        listaVip.putString("primeiroNome", p1.getPrimeiroNome());
        listaVip.putString("sobrenome", p1.getSobrenome());
        listaVip.putString("nomeCurso", p1.getCursoDesejado());
        listaVip.putString("telefoneContato", p1.getTelefoneContato());
        listaVip.apply();

        dados.put("primeiroNome", p1.getPrimeiroNome());
        dados.put("sobrenome", p1.getSobrenome());
        dados.put("cursoDesejado", p1.getCursoDesejado());
        dados.put("telefoneContato", p1.getTelefoneContato());


        salvarObjeto("AppListaVip",dados);

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

    public List<Pessoa> getlistaDeDados() {
        return listarDados();
    }

    public void alterar(Pessoa pessoa) {

        ContentValues dados = new ContentValues();

        dados.put("id", pessoa.getId());
        dados.put("primeiroNome", pessoa.getPrimeiroNome());
        dados.put("sobrenome", pessoa.getSobrenome());
        dados.put("cursoDesejado", pessoa.getCursoDesejado());
        dados.put("telefoneContato", pessoa.getTelefoneContato());

        alterarObjeto("AppListaVip", dados);

    }

    public void deletar(int id) {

        deletarObjeto("AppListaVip", id);

    }

}
