package com.example.aula3.RPG

import com.example.aula3.Dados.Dados

class Guerreiro(

    val nome: String,
    var forcaAtaque: Int,
    var vidaMaxima: Int
) {
    val dados =  Dados(4)
    var vidaAtual = vidaMaxima
    var ataque = forcaAtaque + dados.incremento()
    fun atacar(guerreiro: Guerreiro){

            ataque = forcaAtaque + dados.incremento()
            guerreiro.vidaAtual -= ataque


    }

}