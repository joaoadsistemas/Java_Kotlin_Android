package devandroid.silveira.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;


import devandroid.silveira.appgaseta.R;
import devandroid.silveira.appgaseta.controller.CursoController;
import devandroid.silveira.appgaseta.controller.PessoaController;
import devandroid.silveira.appgaseta.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa p1;
    PessoaController controller;
    CursoController cursoController;
    List<String> nomeDosCursos;
    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeCurso;
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
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);
        spinner = findViewById(R.id.spinner);

        editPrimeiroNome.setText(p1.getPrimeiroNome());
        editSobrenome.setText(p1.getSobrenome());
        editNomeCurso.setText(p1.getCursoDesejado());
        editTelefoneContato.setText(p1.getTelefoneContato());


        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomeDosCursos);

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);



        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editTelefoneContato.setText("");
                editNomeCurso.setText("");

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
                p1.setCursoDesejado(editNomeCurso.getText().toString());
                p1.setTelefoneContato(editTelefoneContato.getText().toString());

                controller.salvar(p1);
            }
        });
    }
}
