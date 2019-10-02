package com.tinderdog;

import android.content.Intent;
import android.os.Bundle;


import com.tinderdog.adapters.DogAdapter;
import com.tinderdog.controllers.PessoaController;
import com.tinderdog.models.Dog;
import com.tinderdog.models.usuario.Endereco;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.models.usuario.Login;
import com.tinderdog.repository.api.IDogRepository;
import com.tinderdog.repository.api.IPessoaRepository;
import com.tinderdog.repository.exception.pessoa.InsertPessoaException;
import com.tinderdog.repository.factoy.PessoaRepositoryFactory;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.graphics.Color;
import android.widget.AdapterView;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mbtnLogin;
    private Button mBtnCadastrar;
    private EditText etEmail;
    private EditText etSenha;
    private EditText etNome;
    private EditText etDtNascimento;
    private EditText etCPF;
    private EditText etCEP;
    private EditText etLogradouro;
    private EditText etBairro;
    private EditText etCidade;
    private EditText etEstado;
    private Pessoa pessoa;
    private Endereco endereco;
    private Login login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        mbtnLogin = (Button) findViewById(R.id.btnLogin);

        etEmail = (EditText)findViewById(R.id.etEmail);
        etSenha = (EditText)findViewById(R.id.etSenha);
        etNome = (EditText)findViewById(R.id.etNome);
        etDtNascimento = (EditText)findViewById(R.id.etData);
        etCPF = (EditText)findViewById(R.id.etCPF);
        etCEP = (EditText)findViewById(R.id.etCEP);
        etLogradouro = (EditText)findViewById(R.id.etLogradouro);
        etBairro = (EditText)findViewById(R.id.etBairro);
        etCidade = (EditText)findViewById(R.id.etCidade);
        etEstado = (EditText)findViewById(R.id.etEstado);


        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this,LoginAcitivity.class);
                //startActivity(intent);
            }
        });

        mBtnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmail.getText().toString();
                String senha = etSenha.getText().toString();
                String nome  = etNome.getText().toString();
                String cpf   = etCPF.getText().toString();
                String dtNascimento = etDtNascimento.getText().toString();
                String cep = etCEP.getText().toString();
                String logradouro = etLogradouro.getText().toString();
                String bairro = etBairro.getText().toString();
                String cidade = etCidade.getText().toString();
                String estado = etEstado.getText().toString();

                //endereco = new Endereco(cep,logradouro,bairro,cidade,estado);
                //login = new Login(001,email,senha);

                //pessoa = new Pessoa(001,login,nome,cpf,dtNascimento,endereco,null);

                //IPessoaRepository pessoaRepository = PessoaRepositoryFactory.getInstance().getRepository();



                Intent intent = new Intent(MainActivity.this, CadastroPessoaActivity.class);
                startActivity(intent);

            }
        });


    }
}







