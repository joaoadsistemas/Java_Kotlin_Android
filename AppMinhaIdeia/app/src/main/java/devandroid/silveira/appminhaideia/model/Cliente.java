package devandroid.silveira.appminhaideia.model;

import devandroid.silveira.appminhaideia.controller.ICrud;

public class Cliente {

    private int id; // Chave primaria no banco de dados

    private String nome;
    private String email;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
