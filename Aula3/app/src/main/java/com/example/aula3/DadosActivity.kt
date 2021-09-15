package com.example.aula3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityDadosBinding

class DadosActivity : AppCompatActivity() {
    private lateinit var biding: ActivityDadosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        biding = ActivityDadosBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        var lista1 = mutableListOf(1,2,3,4,5,6)
        var lista2 = mutableListOf(1,2,3,4,5,6,7,8,9,10)
        var lista3 = mutableListOf(1,2,3,4)
        biding.btOk1.setOnClickListener {
            lista1.clear()
            val tamanhoLista = biding.txtEntradaDado1.text.toString().toInt()
            biding.txtNumDado1.text = tamanhoLista.toString()
            for (x in 1..tamanhoLista){
                lista1.add(x)
            }
            biding.txtEntradaDado1.text.clear()
        }
        biding.btOk2.setOnClickListener {
            lista2.clear()
            val tamanhoLista = biding.txtEntradaDado2.text.toString().toInt()
            biding.txtNumDado2.text = tamanhoLista.toString()
            for (x in 1..tamanhoLista){
                lista2.add(x)
            }
            biding.txtEntradaDado1.text.clear()
        }
        biding.btOk3.setOnClickListener {
            lista3.clear()
            val tamanhoLista = biding.txtEntradaDado3.text.toString().toInt()
            biding.txtNumDado3.text = tamanhoLista.toString()
            for (x in 1..tamanhoLista){
                lista3.add(x)
            }
            biding.txtEntradaDado1.text.clear()
        }
        biding.btSortear.setOnClickListener {
            lista1.shuffle()
            lista2.shuffle()
            lista3.shuffle()
            biding.txtSaidaDado1.text = lista1[1].toString()
            biding.txtSaidaDado2.text = lista2[1].toString()
            biding.txtSaidaDado3.text = lista3[1].toString()
        }
    }
}