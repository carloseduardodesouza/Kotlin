package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Aqui esta sendo inflando o layout da tela principal.
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root) //App ira usar esse layout na tela

        //Configuração do botão que aparecerá no layout.
        binding.buttonEntrar.setOnClickListener {

            //Respectivamente aonde irar obter o texto inserido no campo de usario e senha na teal de login.
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            //Valores para ser usado no Login do app.
            if (username.equals("abc") && password.equals("123")) {
                val i = Intent(this, MainActivity::class.java)
                i.putExtra("username", username)
                startActivity(i) //Inicio da proxima atividade.
                finish() //fim da atividade atual.
            } else {

                //Caso os valores estejam incorretos, será transmitido uma menssagem de erro.
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}