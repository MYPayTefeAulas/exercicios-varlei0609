package com.example.aula3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.Agenda.AgendaActivity
import com.example.aula3.Dados.DadosActivity
import com.example.aula3.Listas.ListasActivity
import com.example.aula3.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {
    private lateinit var biding: ActivityTelaInicialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        biding = ActivityTelaInicialBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        biding.btAgenda.setOnClickListener {
            val intent = Intent(this, AgendaActivity::class.java)
            startActivity(intent)
        }

        biding.btDados.setOnClickListener {
            val intent = Intent(this, DadosActivity::class.java)
            startActivity(intent)
        }
        biding.btListas.setOnClickListener {
            val intent = Intent(this, ListasActivity::class.java)
            startActivity(intent)
        }
    }
}