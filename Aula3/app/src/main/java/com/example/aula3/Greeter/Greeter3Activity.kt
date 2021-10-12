package com.example.aula3.Greeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityGreeter3Binding

class Greeter3Activity : AppCompatActivity() {
    private lateinit var biding: ActivityGreeter3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        biding = ActivityGreeter3Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        val greeter1  = Greeter("Nome:","Idade: ")
        val greeter2  = Greeter("Olá","sua idade é ")
        val greeter3 = Greeter("Oi","vi que sua idade é ")
        val listaPessoa = mutableListOf<PessoaGreeter>()
        var indiceAtual = 0
        var greeterAtual = greeter1
        biding.btSalvarGreeter3.setOnClickListener {
            if(biding.txtEntradaNomeGreeter3.text.isNullOrBlank()||biding.txtEntradaIdadereeter3.text.isNullOrBlank()){
                biding.txtSaidaGreeter3.text = "Preencha todos os campos"
            }
            else
            {
                val nome = biding.txtEntradaNomeGreeter3.text.toString()
                biding.txtEntradaNomeGreeter3.text.clear()
                val idade = biding.txtEntradaIdadereeter3.text.toString().toInt()
                biding.txtEntradaIdadereeter3.text.clear()
                val pessoa = PessoaGreeter(nome,idade)
                listaPessoa.add(pessoa)
            }

        }
        biding.imprimirProximoGreeter3.setOnClickListener {
            if(listaPessoa.size == 0){
                biding.txtSaidaGreeter3.text = "Nenhum dado foi salvo"
            }else
            {
                val pessoaAtual = listaPessoa[indiceAtual]
                indiceAtual++
                biding.txtSaidaGreeter3.text = greeterAtual.greet3(pessoaAtual)
                if(indiceAtual >=listaPessoa.size){
                    indiceAtual = 0
                }
            }

    }
        biding.btProximoGreeter3.setOnClickListener {
            if(greeterAtual == greeter1){
                biding.numGreeter3.text = "2"
                greeterAtual = greeter2
            }else if(greeterAtual == greeter2){
                biding.numGreeter3.text = "3"
                greeterAtual = greeter3
            }else{
                biding.numGreeter3.text = "1"
                greeterAtual = greeter1
            }
        }
        }
}