package devandroid.silveira.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.silveira.applistacurso.R;
import devandroid.silveira.applistacurso.controller.PessoaController;
import devandroid.silveira.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_lista_vip";

    Pessoa p1 = new Pessoa();
    PessoaController controller = new PessoaController();
    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editTelefoneContato;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = preferences.edit();

        p1.setCursoDesejado("Android");
        p1.setSobrenome("Silveira");
        p1.setPrimeiroNome("Joao");
        p1.setTelefoneContato("15-99123488");


        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNome.setText(p1.getPrimeiroNome());
        editSobrenome.setText(p1.getSobrenome());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editTelefoneContato.setText("");
                editNomeCurso.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "volte sempre", Toast.LENGTH_LONG).show();
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

                listaVip.putString("primeiroNome", p1.getPrimeiroNome());
                listaVip.putString("sobrenome", p1.getSobrenome());
                listaVip.putString("nomeCurso", p1.getCursoDesejado());
                listaVip.putString("telefoneContato", p1.getTelefoneContato());
                listaVip.apply();

                controller.salvar(p1);
            }
        });

    }
}