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
        biding.btPesquisar.setOnClickListener {

        var contato = biding.txtEntradaPesquisa.text.toString()

            pesquisar(contato)
        }
        biding.btEditar.setOnClickListener {
            val nome = biding.txtEntradaNomeAgenda.text.toString()
            val contato = biding.txtEntradaTelefoneAgenda.text.toString()
            if(nome!=""&&contato!=""){
                if(agenda.existeContato()){
                    biding.txtSaidaAgenda.text = "Agenda vazia"

                }else{
                    if(agenda.contatoExiste(contato)) {
                        contatoAtual.nome = nome
                        contatoAtual.contato = contato
                        biding.txtSaidaAgenda.text = "Edição realizada"
                        biding.txtEntradaNomeAgenda.text.clear()
                        biding.txtEntradaTelefoneAgenda.text.clear()
                    }else{
                        biding.txtSaidaAgenda.text = "Erro: ontato já existe"
                    }
                }



            }else{
                biding.txtSaidaAgenda.text = "Existem campos vazios"
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
    fun pesquisar(contato: String){
        if(contato == ""){
            biding.txtSaidaAgenda.text = ("Campo de pesquisa vazio")
        }else{
            if(agenda.pesquisarContato(contato).nome == ""){
                biding.txtSaidaAgenda.text = "O contato/nome $contato não consta na lista"
            }else{
                if (!agenda.existeContato()){
                    biding.txtEntradaTelefoneAgenda.setText(agenda.pesquisarContato(contato).contato)
                    biding.txtEntradaNomeAgenda.setText(agenda.pesquisarContato(contato).nome)
                }
            }

        }
    }
}

