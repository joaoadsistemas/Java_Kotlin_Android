package devandroid.silveira.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.silveira.applistacurso.R;
import devandroid.silveira.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa p1 = new Pessoa();
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

                Toast.makeText(MainActivity.this, p1.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}