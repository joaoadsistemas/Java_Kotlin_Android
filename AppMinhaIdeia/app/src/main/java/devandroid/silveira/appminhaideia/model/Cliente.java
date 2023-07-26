package devandroid.silveira.appminhaideia.model;

public class Cliente {

    private String nome;
    private String email;
    private String sexo;

    public Cliente(String nome, String email, String sexo){

        setNome(nome);
        setEmail(email);
        setSexo(sexo);

    };

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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
