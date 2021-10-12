package com.example.aula3.Greeter

class PessoaGreeter{
    var nome = ""
    var profissao = ""
    var telefone = ""
    var idade = 0
    constructor(nome: String,profissao: String,telefone: String){
        this.nome = nome
        this.profissao = profissao
        this.telefone = telefone
    }
    constructor(nome: String, idade: Int){
        this.nome = nome
        this.idade = idade
    }
}