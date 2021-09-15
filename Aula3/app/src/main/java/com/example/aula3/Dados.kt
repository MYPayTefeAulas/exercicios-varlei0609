package com.example.aula3

class Dados(var numeroLados: Int) {
    fun lancar(numeroLados: Int): String{
        this.numeroLados = numeroLados
        val ladoSorteado =  (1..numeroLados).shuffled().first().toString()
        return ladoSorteado
        }

    }
