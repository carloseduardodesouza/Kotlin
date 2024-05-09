package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Esse bloco de código criara um delay de dois segundos de atraso antes de inicar a próxima atividade.
        Handler(Looper.getMainLooper()).postDelayed({

            // obtém a intent que iniciou esta activity.
            val i = intent

            // Cria uma nova intent para iniciar a atividade de pedido.
            val j = Intent(this,PedidoActivity::class.java)

            // Transfere os extras da intent atual para a nova intent.
            j.putExtras(i)

            //Fara inicio a atividade de pedido com a nova i
            startActivity(j)
        },2000)

    }
}