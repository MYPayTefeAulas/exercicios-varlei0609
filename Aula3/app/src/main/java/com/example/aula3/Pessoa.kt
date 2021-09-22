package com.example.aula3

class Pessoa {

    var nome = ""
    var idade = 0
    var contato: String = ""
    constructor(nome: String,idade: Int)
    {
        this.nome = nome
        this.idade = idade
    }
    constructor(nome: String, contato: String){
        this.nome = nome
        this.contato = contato
    }

}