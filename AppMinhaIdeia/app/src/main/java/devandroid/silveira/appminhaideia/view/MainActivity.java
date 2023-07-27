package devandroid.silveira.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import devandroid.silveira.appminhaideia.R;

public class MainActivity extends AppCompatActivity {

    TextView txtNome;
    TextView txtEmail;
    TextView txtSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtSexo = findViewById(R.id.txtSexo);

        Bundle bundle = getIntent().getExtras();


        txtNome.setText(bundle.getString("nome"));
        txtEmail.setText(bundle.getString("email"));
        txtSexo.setText((bundle.getString("sexo")));


    }
}