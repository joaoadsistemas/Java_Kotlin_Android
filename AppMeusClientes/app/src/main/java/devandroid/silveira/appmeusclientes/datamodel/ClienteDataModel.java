package devandroid.silveira.appmeusclientes.datamodel;

public class ClienteDataModel {

    // modelo Objeto Relacional


    // Toda Classe Data Model tem esta estrutura

    // 1 - Query para criar a tabela no banco de dados
    // CADA CARACTERISTICA RESPECTIVA A SUA CLASSE (se tem email, é pq na Classe Cliente existe o get e set do atributo email)
    public static String queryCriarTabela = "CREATE TABLE Cliente (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome TEXT, " +
            "telefone TEXT, " +
            "email TEXT, " +
            "cep INTEGER, " +
            "logradouro TEXT, " +
            "numero TEXT, " +
            "bairro TEXT, " +
            "cidade TEXT, " +
            "estado TEXT, " +
            "termos_de_uso INTEGER" +
            ")";



    // 2 - Método para gerar o Script para criar a tabela
    public static String criarTabela(){
        return queryCriarTabela;
    };

}
