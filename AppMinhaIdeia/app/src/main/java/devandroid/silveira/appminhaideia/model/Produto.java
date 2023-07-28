package devandroid.silveira.appminhaideia.model;

public class Produto {

    private String marca;
    private String produto;


    public Produto(String marca, String produto) {

        setMarca(marca);
        setProduto(produto);

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
