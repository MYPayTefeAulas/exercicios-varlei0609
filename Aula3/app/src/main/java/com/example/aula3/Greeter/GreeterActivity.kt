package com.example.aula3.Greeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.Greeter.Greeter
import com.example.aula3.databinding.ActivityGreeterBinding

class GreeterActivity : AppCompatActivity() {
    private lateinit var biding: ActivityGreeterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityGreeterBinding.inflate(layoutInflater)
        setContentView(biding.root)

        val greeter1 = Greeter("Olá",", como vai?")

        val greeter2 = Greeter("Bem vindo",",como vai você?")
        var listaNomes = mutableListOf<String>()
        var indiceAtual = 0
        var greeterAtual = greeter1
        listaNomes.add("varlei")
        listaNomes.add("João")
        listaNomes.add("Pedro")

        biding.imprimirProximo.setOnClickListener {
            biding.txtSaidaGreeter.text = greeterAtual.greet(listaNomes[indiceAtual])
            if(indiceAtual == listaNomes.size-1){
                indiceAtual = 0
            }else{
                indiceAtual++
            }
        }
        biding.btTrocarGreeter.setOnClickListener {
            if(greeterAtual == greeter1){
                biding.numeroGreeter.text = "2"
                greeterAtual = greeter2
            }else{
                biding.numeroGreeter.text = "1"
                greeterAtual = greeter1
            }
        }

    }
}