package devandroid.silveira.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import devandroid.silveira.appminhaideia.R;
import devandroid.silveira.appminhaideia.controller.ClienteController;
import devandroid.silveira.appminhaideia.controller.ProdutoController;
import devandroid.silveira.appminhaideia.core.AppUtil;
import devandroid.silveira.appminhaideia.model.Cliente;
import devandroid.silveira.appminhaideia.model.Produto;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;


    TextView txtAppVersion;
    ClienteController clienteController;
    ProdutoController produtoController;

    Cliente cliente;

    Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txtAppVersion = findViewById(R.id.txtAppVersion);

        String versao = AppUtil.versaoDoAplicativo();

        txtAppVersion.setText(versao);

        clienteController = new ClienteController(this);
        produtoController = new ProdutoController(this);


        //clienteController.incluir(cliente);
        //produtoController.incluir(produto);

//        produto.setMarca("Tramontina");
//        produto.setProduto("Faca");
//        produto.setId(1);
//
//        produtoController.alterar(produto);

        // clienteController.deletar(1);
        // produtoController.deletar(1);

        for (int i = 0; i < 30; i++) {

            cliente = new Cliente();

            cliente.setEmail("joaoadsistemas **** "+ i + " ****");
            cliente.setNome("Joao ****" + i + " ****");

            clienteController.incluir(cliente);
        }

        for (Cliente obj: clienteController.listar()) {

            Log.e("LISTAVIEW", "onCreate: " + obj.getId() + " " + obj.getNome() + " " + obj.getEmail() );

        }
//

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