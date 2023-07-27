package devandroid.silveira.aninterface;

import android.util.Log;

public class Cliente implements ICrud{

    private String nome;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static final String TAG = "BANCO_DADOS";

    @Override
    public void criar() {
        Log.d(TAG, "criar: " + getNome());
        Log.d(TAG, "criar: "+ getTelefone());
    }

    @Override
    public void listar() {

    }

    @Override
    public void incluir() {

    }

    @Override
    public void deletar() {

    }
}
