package com.example.appcronometro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.example.appcronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //quando eu coloco variaveis aqui em cima todos os metodos consegue utliziar essa variavel !!
    var running  = false
    var pausarContinuar: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIniciar.setOnClickListener {
            iniciarCronometro()
            //eu poderia colocar o codigo das funções diretamente aqui !!
            //estamos colocando em funções só para separar
        }

        binding.btnPausar.setOnClickListener {
            pausarCronometro()
            //eu poderia colocar o codigo das funções diretamente aqui !!
            //estamos colocando em funções só para separar
        }

        binding.btnZerar.setOnClickListener {
            zerarCronometro()
            //eu poderia colocar o codigo das funções diretamente aqui !!
            //estamos colocando em funções só para separar
        }

    }

    //============================

    private fun iniciarCronometro(){
        if(!running){ //se nao estiver correndo(running) por isso o !
            binding.cronometro.base = SystemClock.elapsedRealtime() - pausarContinuar
            binding.cronometro.start()
            running = true
        }
    }

    private fun pausarCronometro(){
        if(running){ //aqui o cronometro esta correndo(running)
            binding.cronometro.stop()
            pausarContinuar = SystemClock.elapsedRealtime() - binding.cronometro.base
            running = false
        }
    }

    private fun zerarCronometro(){
        binding.cronometro.base = SystemClock.elapsedRealtime()
        pausarContinuar = 0
    }
}