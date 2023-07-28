package devandroid.silveira.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import org.w3c.dom.Text;

import devandroid.silveira.appminhaideia.R;
import devandroid.silveira.appminhaideia.controller.ClienteController;
import devandroid.silveira.appminhaideia.controller.ProdutoController;
import devandroid.silveira.appminhaideia.core.AppUtil;
import devandroid.silveira.appminhaideia.model.Cliente;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;


    TextView txtAppVersion;
    ClienteController clienteController;
    ProdutoController produtoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txtAppVersion = findViewById(R.id.txtAppVersion);

        String versao = AppUtil.versaoDoAplicativo();

        txtAppVersion.setText(versao);

        clienteController = new ClienteController(this);
        produtoController = new ProdutoController(this);

        inicializarMain();

    }

    private void inicializarMain() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);


                startActivity(telaPrincipal);
                finish();
            }
        }, TIME_OUT_SPLASH);

    }
}