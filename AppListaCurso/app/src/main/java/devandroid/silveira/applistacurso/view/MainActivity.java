package devandroid.silveira.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import devandroid.silveira.applistacurso.R;
import devandroid.silveira.applistacurso.controller.CursoController;
import devandroid.silveira.applistacurso.controller.PessoaController;
import devandroid.silveira.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa p1;
    PessoaController controller;
    CursoController cursoController;
    List<String> nomeDosCursos;
    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editTelefoneContato;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        p1 = new Pessoa();
        controller = new PessoaController(this);
        controller.buscar(p1);

        cursoController = new CursoController();
        nomeDosCursos = cursoController.dadosParaSpinner();


        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);
        spinner = findViewById(R.id.spinner);

        editPrimeiroNome.setText(p1.getPrimeiroNome());
        editSobrenome.setText(p1.getSobrenome());
        editTelefoneContato.setText(p1.getTelefoneContato());

        List dados = controller.getlistaDeDados();

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomeDosCursos);

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);

        controller.getlistaDeDados();

        controller.deletar(5);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtenha o curso selecionado do Spinner
                String cursoSelecionado = (String) parent.getItemAtPosition(position);

                // Defina o curso selecionado no objeto pessoa (p1)
                p1.setCursoDesejado(cursoSelecionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Não faça nada se nada for selecionado
            }
        });



        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editTelefoneContato.setText("");

                controller.limpar();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.setPrimeiroNome(editPrimeiroNome.getText().toString());
                p1.setSobrenome(editSobrenome.getText().toString());
                p1.setTelefoneContato(editTelefoneContato.getText().toString());



                controller.salvar(p1);
                Toast.makeText(MainActivity.this, "SALVO", Toast.LENGTH_LONG).show();

                // TODO: DEIXAR MAIS DINAMICO E MAIS ESTRUTURADO O METODO DE LIMPEZA

                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editTelefoneContato.setText("");
                recreate();

            }
        });
    }
}
