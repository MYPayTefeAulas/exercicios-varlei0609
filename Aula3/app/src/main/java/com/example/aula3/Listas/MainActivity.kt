package com.example.aula3.Listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var biding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        biding = ActivityMainBinding.inflate(layoutInflater)

         biding.trocarTexto.setOnClickListener{
             val num1 = biding.num1.text.toString().toFloat()
             val op = biding.op.text.toString()
             val num2 = biding.num2.text.toString().toFloat()
             when (op) {
                 "*" -> {
                     biding.resultado.text = (num1 * num2).toString()
                 }
                 "-" -> {
                     biding.resultado.text = (num1 - num2).toString()
                 }
                 "/" -> {
                     biding.resultado.text = (num1 / num2).toString()
                 }
                 "+" -> {
                     biding.resultado.text = (num1 + num2).toString()
                 }
                 else -> {
                     biding.resultado.text = "Escolha uma operação"
                 }
             }

             //biding.txtHello.text = trocaTexto2()
            // biding.txtHello.text = dobro()
//             print("Resultado da soma: ")
//             biding.txtHello.text = mult()


         }
        val view = biding.root
        setContentView(view)
    }
//    fun trocarTexto(){
//        biding.txtHello.text = "oi\n lalala"
//    }
    fun trocarTexto(): String{
        return "oi\n lalala"
    }

//    fun trocaTexto2(): String{
//        return biding.txtInput.text.toString()
//    }
//    fun dobro(): String{
//       val textoEntrada =  biding.txtInput.text.toString()
//        val numero = textoEntrada.toInt()
//        val dobro = numero * 2
//        return dobro.toString()
//    }
//    fun mult(): String{
//       val num1 =  biding.txtInput.text.toString().toInt()
//        val num2 = biding.txtInput2.text.toString().toInt()
//        val mult = num1 * num2
//        return mult.toString()
//    }
}