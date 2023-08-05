package devandroid.silveira.appminhaideia.controller;
import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import devandroid.silveira.appminhaideia.datasource.AppDataBase;
import devandroid.silveira.appminhaideia.model.Cliente;


public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;


    public ClienteController(Context context) {
        super(context);
    }

    @Override
    public void incluir(Cliente obj) {

        dadoDoObjeto = new ContentValues();
        // Key, valor (parecido com SharedPreferences)

        dadoDoObjeto.put("nome", obj.getNome());
        dadoDoObjeto.put("email", obj.getEmail());

        // ID SE PASSA NO DELETAR E ALTERAR, POIS É A
        // CHAVE GERADA AUTOMATICAMENTE PELO SQL A
        // CADA NOVO REGISTRO ADICIONADO;
        // dadoDoObjeto.put("id", obj.getId());

        // Enviar os dados(dadosDoObjeto) para a classe AppDataBase
        // utilizando um método capaz de adicionar o OBJ no banco de dados

        insert("Cliente", dadoDoObjeto);
    }

    @Override
    public void deletar(int id) {

        deleteByID("Cliente", id);

        //Deletar
        // SQL ->>>> DELETE from TABELA whre ID = ?????

        // Enviar os dados(dadosDoObjeto) para a classe AppDataBase
        // utilizando um método capaz de deletar o OBJ no banco de dados
        // respeitando o ID, ou PK (Primary Key)

    }

    @Override
    public List<Cliente> listar() {

        return getAllClientes("Cliente");

    }

    @Override
    public void alterar(Cliente obj) {

        dadoDoObjeto = new ContentValues();


        dadoDoObjeto.put("nome", obj.getNome());
        dadoDoObjeto.put("email", obj.getEmail());
        dadoDoObjeto.put("id", obj.getId());


        update("Cliente", dadoDoObjeto);

        //Alterar
        // SQL ->>>> UPDATE

        // Enviar os dados(dadosDoObjeto) para a classe AppDataBase
        // utilizando um método capaz de alterar o OBJ no banco de dados
        // respeitando o ID, ou PK (Primary Key)

    }
}
