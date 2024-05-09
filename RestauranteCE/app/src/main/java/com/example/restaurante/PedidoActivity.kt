package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPedidoBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        // Aqui esta sendo inflando o layout da tela principal.
        binding = ActivityPedidoBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root) // App ira usar esse layout na tela

        // Vamos pegar os extras da intent que iniciou essa activity
        val i = intent

        // Aqui sera obtido a quantidade de Pizza, Salada e Hamburguer do intent e será convertido para int.
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()

        // Criação do texto de resumo de pedido, incluindo a quantidade e o preço de cada item.
        val texto = "Resumo do Pedido\n" +
                "Pizza: $quantidadePizza Preço: ${quantidadePizza*8}\n" +
                "Salada: $quantidadeSalada Preço: ${quantidadeSalada*10}\n" +
                "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer*12}\n"

        // Texto ira ser introduzido no TextView para ser mostrado ao usuário.
        binding.textResumo.text = texto

    }
}