package com.example.aula3

class Agenda {
    private val listaContatos = mutableListOf<Pessoa>()
    private var indiceAtual = -1

    fun salvarContato(novoContato: Pessoa): Boolean{
   var auxiliar = true
    for (x in 0..listaContatos.size -1){
    if (listaContatos[x].contato == novoContato.contato){
        auxiliar = false
        break
    }
}
        return if (auxiliar){
            listaContatos.add(novoContato)
            true
        }else false
    }
    fun removeContato(contatoARemover: Pessoa): Boolean{

            listaContatos.remove(contatoARemover)
        indiceAtual -=1
            return true
    }
    fun proximoContato():Pessoa{
        if(indiceAtual < -1){
            indiceAtual = 0
        }
        else if(indiceAtual >= listaContatos.size -1){
            indiceAtual = 0
        }else{
            indiceAtual++
        }
     return listaContatos[indiceAtual]
    }

    fun existeContato(): Boolean{
        if(listaContatos.isEmpty()){
            return true
        }
        return false
    }
    }