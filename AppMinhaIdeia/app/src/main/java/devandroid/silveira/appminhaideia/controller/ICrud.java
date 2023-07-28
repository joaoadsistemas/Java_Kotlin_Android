package devandroid.silveira.appminhaideia.controller;

import devandroid.silveira.appminhaideia.model.Cliente;

public interface ICrud {

    public void incluir(Cliente obj);
    public void deletar();
    public void listar();
    public void alterar();

}
