package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        // Aqui esta sendo inflando o layout da tela principal.
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root) // App ira usar esse layout na tela

        // Será pego o nome de usuário que veio da activity anterior, caso tenha.
        val username = intent.extras?.getString("username")

        // Se tivermos um nome de usuário, vamos mostrar um "Olá" com o nome de usuário dado.
        if(!username.isNullOrEmpty()){
            binding.textOla.setText("Olá $username")
        }

        // Após clicar no botão "Fechar", o app vai fechar por completo.
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }

        // Após clicar no bitão "Pedir", o app passara para a SplashActivity.kt e mostrara os detalhes do pedido.
        binding.buttonPedir.setOnClickListener {
            val i = Intent(this, SplashActivity::class.java)
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)
            finish()
        }

        // CheckBox para marcação do item "Pizza".
        binding.checkPizza.setOnClickListener {

            // Se a CheckBox estiver marcada, será mostrada a quantidade e o preço
            if(binding.checkPizza.isChecked()){
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            }else{

                // Se não estiver marcado, a quantidade e o preço estaram zerados.
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

        // CheckBox com o mesmo propósito que a anterior.
        binding.checkSalada.setOnClickListener {
            if(binding.checkSalada.isChecked()){
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

        // CheckBox com o mesmo propósito que as anteriores.
        binding.checkHamburger.setOnClickListener {
            if(binding.checkHamburger.isChecked()){
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}