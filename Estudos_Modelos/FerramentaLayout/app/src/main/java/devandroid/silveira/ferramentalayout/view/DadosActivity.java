package devandroid.silveira.ferramentalayout.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import devandroid.silveira.ferramentalayout.R;

public class DadosActivity extends AppCompatActivity {
    TextView txtDadoNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dados_activity);

        txtDadoNome = findViewById(R.id.txtDadoNome);

        Intent intent = getIntent();

        String dadoNome = intent.getStringExtra("dado_nome");

        txtDadoNome.setText(dadoNome);




    }
}