package devandroid.silveira.appmeusclientes.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import devandroid.silveira.appmeusclientes.R;
import devandroid.silveira.appmeusclientes.controller.ClienteController;
import devandroid.silveira.appmeusclientes.model.Cliente;


public class AdicionarClienteFragment extends Fragment {

    // DECLARAÇÃO GLOBAL DE ATRIBUTOS
    View view;
    TextView txtTituloAddCliente;
    EditText editNome;
    EditText editTelefone;
    EditText editEmail;
    EditText editCep;
    EditText editLogradouro;
    EditText editNumero;
    EditText editBairro;
    EditText editCidade;
    EditText editEstado;

    CheckBox termosUso;

    Button btnCancelar;
    Button btnSalvar;


    Cliente novoCliente;

    ClienteController clienteController;


    public AdicionarClienteFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_adicionar_cliente, container, false);

        iniciarComponentesDeLayout();

        escutarEventosDosBotoes();

        return view;
    }

    /**
     * Inicializar os componentes da tela/layout
     * para adicionar os clientes
     */

    private void iniciarComponentesDeLayout() {


        txtTituloAddCliente = view.findViewById(R.id.txtTituloAddCliente);
        txtTituloAddCliente.setText(R.string.txt_titulo);

        editNome = view.findViewById(R.id.editNome);
        editTelefone = view.findViewById(R.id.editTelefone);
        editEmail = view.findViewById(R.id.editEmail);
        editCep = view.findViewById(R.id.editCep);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editNumero = view.findViewById(R.id.editNumero);
        editBairro = view.findViewById(R.id.editBairro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);

        termosUso = view.findViewById(R.id.termosUso);

        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();

        clienteController = new ClienteController(getContext());


    }

    private void escutarEventosDosBotoes() {

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Considerando que o usuario digitou todos os dados;
                boolean isDadosOkay = true;

                if (TextUtils.isEmpty(editNome.getText())) {
                    isDadosOkay = false;
                    editNome.setError("Digite o nome completo...");
                    editNome.requestFocus();
                }

                if (TextUtils.isEmpty(editBairro.getText())) {
                    isDadosOkay = false;
                    editBairro.setError("Digite o bairro...");
                    editBairro.requestFocus();
                }

                if (TextUtils.isEmpty(editCep.getText())) {
                    isDadosOkay = false;
                    editCep.setError("Digite o cep...");
                    editCep.requestFocus();
                }

                if (TextUtils.isEmpty(editEmail.getText())) {
                    isDadosOkay = false;
                    editEmail.setError("Digite o email...");
                    editEmail.requestFocus();
                }

                if (TextUtils.isEmpty(editCidade.getText())) {
                    isDadosOkay = false;
                    editCidade.setError("Digite a cidade...");
                    editCidade.requestFocus();
                }

                if (TextUtils.isEmpty(editEstado.getText())) {
                    isDadosOkay = false;
                    editEstado.setError("Digite o estado...");
                    editEstado.requestFocus();
                }

                if (TextUtils.isEmpty(editLogradouro.getText())) {
                    isDadosOkay = false;
                    editLogradouro.setError("Digite o logradouro...");
                    editLogradouro.requestFocus();
                }

                if (TextUtils.isEmpty(editNumero.getText())) {
                    isDadosOkay = false;
                    editNumero.setError("Digite o numero...");
                    editNumero.requestFocus();
                }

                if (TextUtils.isEmpty(editTelefone.getText())) {
                    isDadosOkay = false;
                    editTelefone.setError("Digite o telefone...");
                    editTelefone.requestFocus();
                }

                if (isDadosOkay) {

                    novoCliente.setNome(editNome.getText().toString());
                    novoCliente.setBairro(editBairro.getText().toString());
                    novoCliente.setEmail(editEmail.getText().toString());
                    novoCliente.setCep(Integer.parseInt(editCep.getText().toString()));
                    novoCliente.setTelefone(editTelefone.getText().toString());
                    novoCliente.setNumero(editNumero.getText().toString());
                    novoCliente.setCidade(editCidade.getText().toString());
                    novoCliente.setLogradouro(editLogradouro.getText().toString());
                    novoCliente.setEstado(editEstado.getText().toString());
                    novoCliente.setTermosDeUso(termosUso.isChecked());

                    clienteController.incluir(novoCliente);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "ERRO AO ENVIAR OS DADOS", Toast.LENGTH_LONG).show();
                }




            }
        });


    }

}
