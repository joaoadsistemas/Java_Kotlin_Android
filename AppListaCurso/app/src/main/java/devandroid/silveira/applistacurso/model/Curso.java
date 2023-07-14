package devandroid.silveira.applistacurso.model;

public class Curso {

    private String nomeDoCursoDesejado;

    public Curso(String nomeDoCursoDesejado) {
         setNomeDoCursoDesejado(nomeDoCursoDesejado);
    }

    public String getNomeDoCursoDesejado() {
        return nomeDoCursoDesejado;
    }

    public void setNomeDoCursoDesejado(String nomeDoCursoDesejado) {
        this.nomeDoCursoDesejado = nomeDoCursoDesejado;
    }
}
