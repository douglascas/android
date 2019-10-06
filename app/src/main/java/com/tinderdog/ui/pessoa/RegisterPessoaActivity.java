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
import android.widget.TextView;

public class RegisterPessoaActivity extends AppCompatActivity {

    private Button mbtnRegister;
    private TextView linkLogin;
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
        setContentView(R.layout.activity_register_pessoa);

        linkLogin = findViewById(R.id.lnkLogin);
        mbtnRegister =  findViewById(R.id.btnLogin);

        etEmail = findViewById(R.id.txtEmail);
        etSenha = findViewById(R.id.txtPwd);
        etNome = findViewById(R.id.txtName);
        etDtNascimento = findViewById(R.id.txtData);
        etCPF = findViewById(R.id.txtCpf);
        etCEP = findViewById(R.id.txtCEP);
        etLogradouro = findViewById(R.id.txtLogradouro);
        etBairro = findViewById(R.id.textBairro);
        etCidade = findViewById(R.id.txtCidade);
        etEstado = findViewById(R.id.txtEstado);


        linkLogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterPessoaActivity.this,LoginActivity.class);
            startActivity(intent);
        });

        mbtnRegister.setOnClickListener(v -> {

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


    }
}







