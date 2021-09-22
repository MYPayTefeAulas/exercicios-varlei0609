package com.example.aula3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityTestesBinding

class TestesActivity : AppCompatActivity() {
    private lateinit var biding: ActivityTestesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        biding = ActivityTestesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        var lista = listOf("nome1","nome2","nome3")
        if(lista.contains("nome1")){
            biding.textView9.text = "opa"
        }
    }
}