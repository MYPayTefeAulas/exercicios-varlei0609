package com.example.aula3
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.databinding.ActivityAgendaBinding

class AgendaActivity : AppCompatActivity() {
//=============================================================

    private lateinit var biding: ActivityAgendaBinding
    val agenda = Agenda()
    var contatoAtual  = Pessoa("","")

//============================================================

    override fun onCreate(savedInstanceState: Bundle?) {

//============================================================

        biding = ActivityAgendaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

//============================================================

        biding.btSalvarContato.setOnClickListener {
            val nome = biding.txtEntradaNomeAgenda.text.toString()
            val contato = biding.txtEntradaTelefoneAgenda.text.toString()
            salvarContato(nome,contato)

        }

//============================================================

        biding.btProximoAgenda.setOnClickListener {
            if(agenda.existeContato()){
                biding.txtSaidaAgenda.text = "Lista vazia"
            }else{
                contatoAtual = agenda.proximoContato()
                biding.txtEntradaNomeAgenda.setText(contatoAtual.nome)
                biding.txtEntradaTelefoneAgenda.setText(contatoAtual.contato)
            }

        }

//===========================================================

         biding.btDeletar.setOnClickListener {
             if(!agenda.existeContato()){
                 val nome = biding.txtEntradaNomeAgenda.text.toString()
                 val telefone = biding.txtEntradaTelefoneAgenda.text.toString()
                 if(nome == "" && telefone == ""){

                 }else{
                     biding.txtSaidaAgenda.setTextColor(resources.getColor(R.color.red))
                     biding.txtSaidaAgenda.text = "${contatoAtual.nome} foi removido"
                     agenda.removeContato(contatoAtual)
                     biding.txtEntradaNomeAgenda.text.clear()
                     biding.txtEntradaTelefoneAgenda.text.clear()
                 }

             }


         }
    }

//============================================================

    private fun salvarContato(nome: String, contato: String){

        if(nome.isNullOrBlank()){
            biding.txtSaidaAgenda.setTextColor(resources.getColor(R.color.purple_700))
            biding.txtSaidaAgenda.text = "Nome vazio"
        }else if(contato.isNullOrBlank()){
            biding.txtSaidaAgenda.setTextColor(resources.getColor(R.color.purple_700))
            biding.txtSaidaAgenda.text = "Telefone vazio"
    }else{
         val novoContato = Pessoa(nome,contato)

           if(agenda.salvarContato(novoContato)){
               biding.txtSaidaAgenda.setTextColor(resources.getColor(R.color.green))
                biding.txtSaidaAgenda.text = "Contato ${novoContato.nome} salvo"
                biding.txtEntradaNomeAgenda.text.clear()
                biding.txtEntradaTelefoneAgenda.text.clear()
            }else{
               biding.txtSaidaAgenda.setTextColor(resources.getColor(R.color.red))
                agenda.removeContato(novoContato)
                biding.txtSaidaAgenda.text = "ERRO: Contato já existe"
            }
        }
    }

    //==============================================================
}

