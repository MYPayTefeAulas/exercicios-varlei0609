package com.example.aula3.Listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityListasBinding

class ListasActivity : AppCompatActivity() {
    private lateinit var biding: ActivityListasBinding
    private val listaFrutas = listOf("maçã","abacate","manga")
    private val listaVegetais = listOf("pepino","alface","pimentão")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        biding = ActivityListasBinding.inflate(layoutInflater)

       biding.btAnalisar.setOnClickListener {
           biding.txtSaida.text = analisar(biding.txtEntrada.text.toString())
       }

        setContentView(biding.root)
    }


    fun analisar(entrada: String): String{
        var saida = ""
        for(frutas in listaFrutas){
            if(frutas==entrada){
                saida ="É uma fruta"
                break
            }

        }
        for(vegetal in listaVegetais){
            if(vegetal==entrada){
                saida ="É um vegetal"
                break
            }

        }
        if(saida == ""){
            saida = "Não sei o que é isso"
        }
            return saida
    }
}

