package com.example.aula3.Greeter

import com.example.aula3.PessoaGreeter

class Greeter{
    private var prefixo  = ""
    private var sufixo   = ""

    private var parte1   = ""
    private var parte2   = ""
    private var parte3   = ""

    constructor(prefixo: String, sufixo: String){
        this.prefixo = prefixo
        this.sufixo = sufixo
    }
    constructor( parte1: String, parte2: String, parte3: String){
        this.parte1 = parte1
        this.parte2 = parte2
        this.parte3 = parte3
    }

    fun greet(nome: String): String{
        val cumprimentoAtual = "$prefixo $nome $sufixo"
        return cumprimentoAtual
    }
    fun greet2(pessoa1 : PessoaGreeter): String{

        return "$parte1: ${pessoa1.nome} $parte2: ${pessoa1.profissao} $parte3: ${pessoa1.telefone}"
    }
    fun greet3(pessoa: PessoaGreeter): String{
        val cumprimentoAtual = "$prefixo ${pessoa.nome} $sufixo ${pessoa.idade}"
        return cumprimentoAtual
    }
}
