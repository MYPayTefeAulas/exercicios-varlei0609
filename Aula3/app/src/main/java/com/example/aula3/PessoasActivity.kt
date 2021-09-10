package com.example.aula3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AlertDialogLayout
import com.example.aula3.databinding.ActivityPessoasBinding

class PessoasActivity : AppCompatActivity() {
    private lateinit var biding: ActivityPessoasBinding
    private var nome = ""
    private var idade = 0
    val listasPessoa = mutableListOf<Pessoa>()
    private var indiceAtual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityPessoasBinding.inflate(layoutInflater)
        setContentView(biding.root)

        biding.btSalvar.setOnClickListener{
            if(biding.entradaNome.text.isNullOrBlank()||biding.entradaIdade.text.isNullOrBlank())
            {
                biding.txtNome.text = "Insira todos os dados"
            }
            else{
                biding.txtNome.text = ""
                nome = biding.entradaNome.text.toString()
                biding.entradaNome.text.clear()
                idade= biding.entradaIdade.text.toString().toInt()
                biding.entradaIdade.text.clear()
                val pessoa = Pessoa(nome,idade)
                listasPessoa.add(pessoa)
            }

        }
        biding.btPrXimo.setOnClickListener{
            biding.txtNome.text = imprimePessoa()
        }
        biding.btZerar.setOnClickListener{
            biding.txtNome.text = ""
            listasPessoa.clear()
        }
    }
    fun imprimePessoa(): String{
         if(listasPessoa.size==0){
             return "Nenhum dado foi salvo"
         }
        if(indiceAtual >=listasPessoa.size) {
            indiceAtual = 0
            return "Fim da lista"

        }

            val pessoaAtual = listasPessoa[indiceAtual]
            indiceAtual++
            return "Nome: ${pessoaAtual.nome}, Idade: ${pessoaAtual.idade}"
        }


}