package devandroid.silveira.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.silveira.appgaseta.R;
import devandroid.silveira.appgaseta.apoio.UtilGasEta;
import devandroid.silveira.appgaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {


    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    double precoGasolina;
    double precoEtanol;
    String recomendacao;


    EditText editGasolina;
    EditText editEtanol;

    TextView txtResultado;

    Button btnCalcular;
    Button btnSalvar;
    Button btnLimpar;
    Button btnFinalizar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isOkay = true;

                if (TextUtils.isEmpty(editEtanol.getText())) {
                    editEtanol.setError("* OBRIGATÓRIO");
                    editEtanol.requestFocus();
                    isOkay = false;
                }

                if (TextUtils.isEmpty(editGasolina.getText())) {
                    editGasolina.setError("* OBRIGATÓRIO");
                    editGasolina.requestFocus();
                    isOkay = false;
                }

                if(isOkay) {

                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());

                    recomendacao = UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);

                    txtResultado.setText(recomendacao);

                }



            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                combustivelEtanol.setNomeDoCombustivel("Etanol");
                combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));




            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editEtanol.setText("");
                editGasolina.setText("");
                txtResultado.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(GasEtaActivity.this, "Obrigado por usar o APP", Toast.LENGTH_LONG).show();
                finish();
            }
        });


        Toast.makeText(GasEtaActivity.this, UtilGasEta.calcularMelhorOpcao(5.00, 3.16), Toast.LENGTH_LONG).show();

    }
}
