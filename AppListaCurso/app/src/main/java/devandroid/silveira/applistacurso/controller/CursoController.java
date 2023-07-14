package devandroid.silveira.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.silveira.applistacurso.model.Curso;

public class CursoController {

    public List<Curso> getListaDeCursos() {
        List<Curso> listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("JAVA"));
        listCursos.add(new Curso("Dart"));
        listCursos.add(new Curso("Flutter"));


        return listCursos;
    };

    public ArrayList<String> dadosParaSpinner() {

        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaDeCursos().size(); i++) {

            Curso objeto = getListaDeCursos().get(i);
            dados.add(objeto.getNomeDoCursoDesejado());

        }

        return dados;

    }

}
