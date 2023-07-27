package devandroid.silveira.aninterface;

import android.util.Log;

public class Notebook implements ICrud {

    private String nome;
    private String modelo;

    public static final String TAG = "BANCO_DADOS";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void criar() {
        Log.d(TAG, "criar: " + getNome());
        Log.d(TAG, "criar: " + getModelo());
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
