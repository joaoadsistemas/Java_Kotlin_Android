package devandroid.silveira.appmeusclientes.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import devandroid.silveira.appmeusclientes.datasource.AppDataBase;
import devandroid.silveira.appmeusclientes.model.Produto;

public class ProdutoController extends AppDataBase implements ICrud<Produto> {

    ContentValues dadoDoObjeto;

    public ProdutoController(Context context) {
        super(context);
    }

    @Override
    public void incluir(Produto obj) {

        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put("marca", obj.getMarca());
        dadoDoObjeto.put("produto",obj.getProduto());

        insert("Produto", dadoDoObjeto);


    }

    @Override
    public void deletar(int id) {

        deleteByID("Produto", id);
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
        dadoDoObjeto.put("produto",obj.getProduto());
        dadoDoObjeto.put("id", obj.getId());


        update("Produto", dadoDoObjeto);
    }
}
