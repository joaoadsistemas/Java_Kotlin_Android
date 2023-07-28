package devandroid.silveira.appminhaideia.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import devandroid.silveira.appminhaideia.datasource.AppDataBase;
import devandroid.silveira.appminhaideia.model.Produto;

public class ProdutoController extends AppDataBase implements ICrud<Produto> {

    ContentValues dadoDoObjeto;

    public ProdutoController(Context context) {
        super(context);
    }

    @Override
    public void incluir(Produto obj) {

        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put("marca", obj.getMarca());
        dadoDoObjeto.put("prduto",obj.getProduto());


    }

    @Override
    public void deletar(Produto obj) {

        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put("id", obj.getId());

    }

    @Override
    public List<Produto> listar() {

        List<Produto> lista = new ArrayList<>();

        return lista;
    }

    @Override
    public void alterar(Produto obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put("marca", obj.getMarca());
        dadoDoObjeto.put("prduto",obj.getProduto());
        dadoDoObjeto.put("id", obj.getId());
    }
}
