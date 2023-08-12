package devandroid.silveira.appbancodedadosmeusclientes;

import android.content.ContentValues;
import android.content.Context;

public class ClienteController extends AppDataBase {

    public ClienteController(Context context) {
        super(context);
    }

    public void incluir (Cliente obj) {

        ContentValues dados = new ContentValues();

        dados.put("nome", obj.getNome());
        dados.put("salario", obj.getSalario());
        dados.put("preco", obj.getPreco());
        dados.put("idade", obj.getIdade());
        dados.put("ativo", obj.getAtivo());
        dados.put("dataCadastro", obj.getDataCadastro());
        dados.put("horaCadastro", obj.getHoraCadastro());

        insert("cliente", dados);


    }

    //////

    public void alterar (Cliente obj) {

    }

    public void listar (Cliente obj) {

    }

    public void deletar(Cliente obj) {

    }


}
