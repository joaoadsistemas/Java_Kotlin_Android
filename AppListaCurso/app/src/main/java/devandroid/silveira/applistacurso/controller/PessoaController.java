package devandroid.silveira.applistacurso.controller;

import android.util.Log;

import devandroid.silveira.applistacurso.model.Pessoa;

public class PessoaController {


    public void salvar(Pessoa pessoa) {
        Log.d("CONTROLLER MVC", "SALVO " + pessoa.toString());
    }
}
