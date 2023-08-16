package devandroid.silveira.appmeusclientes.datamodel;

public class ProdutoDataModel {

    public static final String queryCriarTabela = "CREATE TABLE Produto (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "marca TEXT, " +
            "produto TEXT)";


    public static String criarTabela() {
        return queryCriarTabela;
    }

}
