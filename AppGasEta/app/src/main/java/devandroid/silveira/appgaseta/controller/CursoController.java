package devandroid.silveira.appgaseta.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.silveira.appgaseta.model.Curso;

public class CursoController {

    public List<Curso> getListaDeCursos() {
        List<Curso> listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("Java"));
        listCursos.add(new Curso("Dart"));
        listCursos.add(new Curso("JavaScript"));
        listCursos.add(new Curso("Flutter"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("HTML"));
        listCursos.add(new Curso("CSS"));
        listCursos.add(new Curso("SpringBoost"));
        listCursos.add(new Curso("React"));
        listCursos.add(new Curso("Angular"));


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
