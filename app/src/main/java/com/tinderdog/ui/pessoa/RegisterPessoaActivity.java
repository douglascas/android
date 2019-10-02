package com.tinderdog.ui.pessoa;

import android.content.Intent;
import android.os.Bundle;


import com.tinderdog.R;
import com.tinderdog.models.usuario.Endereco;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.models.usuario.Login;
import com.tinderdog.controllers.Facade;
import com.tinderdog.repository.exception.pessoa.InsertPessoaException;
import com.tinderdog.ui.login.LoginActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;

import android.widget.Button;

public class RegisterPessoaActivity extends AppCompatActivity {

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
    private Facade facade = Facade.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnCadastrar = findViewById(R.id.btnCadastrar);
        mbtnLogin =  findViewById(R.id.btnLogin);

        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        etNome = findViewById(R.id.etNome);
        etDtNascimento = findViewById(R.id.etData);
        etCPF = findViewById(R.id.etCPF);
        etCEP = findViewById(R.id.etCEP);
        etLogradouro = findViewById(R.id.etLogradouro);
        etBairro = findViewById(R.id.etBairro);
        etCidade = findViewById(R.id.etCidade);
        etEstado = findViewById(R.id.etEstado);


        mbtnLogin.setOnClickListener(v -> {
            //Intent intent = new Intent(RegisterPessoaActivity.this,LoginAcitivity.class);
            //startActivity(intent);
        });

        mBtnCadastrar.setOnClickListener(v -> {

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

           Endereco endereco = new Endereco(cep,logradouro,bairro,cidade,estado);
           Login login = new Login(1,email,senha);

           Pessoa pessoa = new Pessoa(1,login,nome,cpf,dtNascimento,endereco,null);

            try {
                facade.insertPessoa(pessoa);
            } catch ( InsertPessoaException e) {
                System.out.println(e.getMessage());
            }

            Intent intent = new Intent(RegisterPessoaActivity.this, LoginActivity.class);
            startActivity(intent);

        });

        mbtnLogin.setOnClickListener(v -> {

            Endereco endereco = new Endereco("51202102","Av Conselheiro Aguiar",
                    "boa viagem","recife","pe");
            Login login = new Login(2,"marina","123456");

            Pessoa pessoa = new Pessoa(1,login,"Marina","023454545",
                    "10/04/1995",endereco,null);

            try {
                facade.insertPessoa(pessoa);
            } catch ( InsertPessoaException e) {
                System.out.println(e.getMessage());
            }

            Intent intent = new Intent(RegisterPessoaActivity.this, LoginActivity.class);
            startActivity(intent);

        });


    }
}







