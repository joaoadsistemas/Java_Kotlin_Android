package devandroid.silveira.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.silveira.applistacurso.R;
import devandroid.silveira.applistacurso.database.AppListaVipDB;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        comutarTelaSplash();

    }

    private void comutarTelaSplash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                AppListaVipDB db = new AppListaVipDB(SplashActivity.this);

                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(telaPrincipal);

                finish();

            }
        }, TIME_OUT_SPLASH);

    }

}