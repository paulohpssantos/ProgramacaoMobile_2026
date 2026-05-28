package com.example.cadastroalunoroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cadastroalunoroom.adapter.AlunoAdapter
import com.example.cadastroalunoroom.database.AppDatabase
import com.example.cadastroalunoroom.database.DatabaseProvider
import com.example.cadastroalunoroom.repository.AlunoRepository
import com.example.cadastroalunoroom.telas.TelaAluno
import com.example.cadastroalunoroom.viewmodel.AlunoViewModel


class MainActivity : ComponentActivity() {

    private lateinit var alunoAdapter: AlunoAdapter
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = DatabaseProvider.getDatabase(this)

        val repository = AlunoRepository(db.alunoDao())
        val viewModel = AlunoViewModel(repository)
        setContent {
            TelaAluno(viewModel)
        }


    }

//    private fun carregarAlunos() {
//        CoroutineScope(Dispatchers.IO).launch {
//            val lista = db.alunoDao().listarTodos()
//
//            withContext(Dispatchers.Main){
//                alunoAdapter.atualizarLista(lista)
//            }
//        }
//    }
//
//    private fun adicionarAluno(){
//
//        //Carregar o layout
//        val viewDialog = layoutInflater
//            .inflate(R.layout.dialog_cadastro_aluno,null)
//
//        //carregar os componentes
//        val edRa = viewDialog.findViewById<EditText>(R.id.edRa)
//        val edNome = viewDialog.findViewById<EditText>(R.id.edNome)
//
//        //Criar o dialog
//        val dialog = MaterialAlertDialogBuilder(this)
//            .setTitle("Cadastrar Aluno")
//            .setView(viewDialog)
//            .setCancelable(false)
//            .setPositiveButton("Salvar" , null)
//            .setNegativeButton("Cancelar"){
//                dialogInterface, i -> dialogInterface.dismiss()
//            }
//            .create()
//
//        dialog.show()
//
//        //Evento botão salvar
//        dialog.getButton(AlertDialog.BUTTON_POSITIVE)
//            .setOnClickListener {
//
//                val ra = edRa.text.toString().trim()
//                val nome = edNome.text.toString().trim()
//
//                //validar os campos
//                if(ra.isEmpty()){
//                    edRa.error = "Digite o RA"
//                    return@setOnClickListener
//                }
//                if(nome.isEmpty()){
//                    edNome.error = "Digite o Nome"
//                    return@setOnClickListener
//                }
//
//                CoroutineScope(Dispatchers.IO).launch {
//
//                    val novoAluno = AlunoEntity(
//                        ra.toInt(),
//                        nome
//                    )
//                    //gravando aluno na tabela do banco de dados
//                    db.alunoDao().inserir(novoAluno)
//
//                    //carregar a lista de alunos
//                    carregarAlunos()
//
//                    //Toast.makeText(this@MainActivity,
//                      //  "Aluno cadastrado com sucesso", Toast.LENGTH_LONG).show()
//
//                    dialog.dismiss()
//                }
//
//        }






//    }
}

