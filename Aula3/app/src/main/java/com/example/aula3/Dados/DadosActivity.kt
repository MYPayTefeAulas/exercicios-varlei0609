package com.example.aula3.Dados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityDadosBinding

class DadosActivity : AppCompatActivity() {//Início
    private lateinit var biding: ActivityDadosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        biding = ActivityDadosBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

        // ******************** Objetos da classe Dados ******************************

        val dado1 = Dados(6)// Dado 1
        val dado2 = Dados(10)// Dado 2
        val dado3 = Dados(4)// Dado 3

        // *************************************************


        // ******************** Configurações do botão de Ok do dado 1 ****************

        biding.btOk1.setOnClickListener {
            if(!biding.txtEntradaDado1.text.isNullOrBlank()&&biding.txtEntradaDado1.text.toString().toInt()!=0){// será executado somente se o campo que altera o numero de lados do dado for preenchido
                val numeroLados = biding.txtEntradaDado1.text.toString().toInt()// variavel que recebe a o numero, que representa a quantidade de lados, que será digitado
                dado1.numeroLados = numeroLados// alterando o número de lados do dado 1 que inicialmente é 6, para a quantidade de lados que foi digitada
                biding.txtNumDado1.text = numeroLados.toString()// alterando o texto, que mostra a quantidade de lados que o dado 1 possui, para o valor que foi digitado
                biding.txtEntradaDado1.text.clear()// limpando o campo após ser digitada a quantidade do número de lados que o dado irá possuir
            }

        }
        // ****************************************************************************


        // ******************** Configurações do botão de Ok do dado 2 ****************

        biding.btOk2.setOnClickListener {
            if(!biding.txtEntradaDado2.text.isNullOrBlank()&&biding.txtEntradaDado2.text.toString().toInt()!=0)// será executado somente se o campo que altera o numero de lados do dado for preenchido
            {
                val numeroLados = biding.txtEntradaDado2.text.toString().toInt()// variavel que recebe a o numero, que representa a quantidade de lados, que será digitado
                dado2.numeroLados = numeroLados// alterando o número de lados do dado 2 que inicialmente é 10, para a quantidade de lados que foi digitada
                biding.txtNumDado2.text = numeroLados.toString()// alterando o texto, que mostra a quantidade de lados que o dado 2 possui, para o valor que foi digitado
                biding.txtEntradaDado2.text.clear()// limpando o campo após ser digitada a quantidade do número de lados que o dado irá possuir
            }

        }

        // ****************************************************************************


        // ******************** Configurações do botão de Ok do dado 3 ****************

        biding.btOk3.setOnClickListener {
            if(!biding.txtEntradaDado3.text.isNullOrBlank()&&biding.txtEntradaDado3.text.toString().toInt()!=0){// variavel que recebe a o numero, que representa a quantidade de lados, que será digitado
                val numeroLados = biding.txtEntradaDado3.text.toString().toInt()// variavel que recebe a o numero, que representa a quantidade de lados, que será digitado
                dado3.numeroLados = numeroLados// alterando o número de lados do dado 3 que inicialmente é 4, para a quantidade de lados que foi digitada
                biding.txtNumDado3.text = numeroLados.toString()// alterando o texto, que mostra a quantidade de lados que o dado 3 possui, para o valor que foi digitado
                biding.txtEntradaDado3.text.clear()// limpando o campo após ser digitada a quantidade do número de lados que o dado irá possuir
            }

        }

        // ****************************************************************************


        // ******************** Configurações do botão Sortear ************************

        biding.btSortear.setOnClickListener {
            biding.txtSaidaDado1.text = dado1.lancar()// mostrando o primeiro valor do intervalo que vai de  1 até o número de lados do dado 1
            biding.txtSaidaDado2.text = dado2.lancar()// mostrando o primeiro valor do intervalo que vai de  1 até o número de lados do dado 2
            biding.txtSaidaDado3.text = dado3.lancar()// mostrando o primeiro valor do intervalo que vai de  1 até o número de lados do dado 3
        }

        // ****************************************************************************
    }
}// fim