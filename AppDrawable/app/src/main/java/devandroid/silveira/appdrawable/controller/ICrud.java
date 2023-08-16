package devandroid.silveira.appdrawable.controller;

import java.util.List;

// <T> significa que posso passar como parametro qualquer objeto
public interface ICrud<T> {

    public void incluir(T obj);
    public void deletar(int id);
    public List<T> listar();
    public void alterar(T obj);

}
