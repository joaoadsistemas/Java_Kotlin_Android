package devandroid.silveira.appminhaideia.controller;

import java.util.List;

import devandroid.silveira.appminhaideia.model.Cliente;

// <T> significa que posso passar como parametro qualquer objeto
public interface ICrud<T> {

    public void incluir(T obj);
    public void deletar(T obj);
    public List<T> listar();
    public void alterar(T obj);

}
