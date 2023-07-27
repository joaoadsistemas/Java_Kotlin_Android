package devandroid.silveira.aninterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Cliente cliente = new Cliente();
    Notebook notebook = new Notebook();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cliente.setNome("Carlos");
        cliente.setTelefone("1577742885");

        notebook.setModelo("Acer");
        notebook.setNome("A332");

        notebook.criar();
        cliente.criar();


    }
}