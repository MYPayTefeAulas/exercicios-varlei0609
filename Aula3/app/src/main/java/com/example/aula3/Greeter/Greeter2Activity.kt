package com.example.aula3.Greeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.PessoaGreeter
import com.example.aula3.databinding.ActivityGreeter2Binding

class Greeter2Activity : AppCompatActivity() {
    private lateinit var biding: ActivityGreeter2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        biding = ActivityGreeter2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        var indiceAtual = 0
        val greeter1  = Greeter("Nome","Profissão","Telefone")
        val greeter2  = Greeter("Olá","vi aqui que você é ","e seu telefone é ")
        val greeter3 = Greeter("","","")
       val listasPessoas = mutableListOf<PessoaGreeter>()
        val pessoa1 = PessoaGreeter("Varlei","Estudante","000000000000")
        listasPessoas.add(pessoa1)
        val pessoa2 = PessoaGreeter("João","Hippie","11111111111")
        listasPessoas.add(pessoa2)
        val pessoa3 = PessoaGreeter("Pedro","Homem Bomba","9999999999999")
        listasPessoas.add(pessoa3)
        var greeterAtual = greeter1
        biding.btProximo.setOnClickListener {
            var pessoaAtual = listasPessoas[indiceAtual]
            biding.txtSaidaGreeter2.text = greeterAtual.greet2(pessoaAtual)
            if(indiceAtual == listasPessoas.size - 1){
                indiceAtual = 0
            }
            else
            {
                indiceAtual++
            }
        }
        biding.btProximoGreeter.setOnClickListener {
            if(greeterAtual == greeter1){
                biding.numGreeter.text = "2"
                greeterAtual = greeter2
            }else if(greeterAtual == greeter2){
                biding.numGreeter.text = "3"
                greeterAtual = greeter3
            }else{
                biding.numGreeter.text = "1"
                greeterAtual = greeter1
            }
        }

    }
}