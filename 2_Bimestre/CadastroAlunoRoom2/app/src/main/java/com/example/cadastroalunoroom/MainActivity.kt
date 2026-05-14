package com.example.cadastroalunoroom

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cadastroalunoroom.adapter.AlunoAdapter
import com.example.cadastroalunoroom.database.AppDatabase
import com.example.cadastroalunoroom.database.DatabaseProvider
import com.example.cadastroalunoroom.entity.AlunoEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    private lateinit var alunoAdapter: AlunoAdapter
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        //carregando os componentes da tela
        val recyclerViewAluno = findViewById<RecyclerView>(R.id.rvALunos)
        val btAdicionarAluno = findViewById<Button>(R.id.btAdicionarAluno)

        //carregando a base de dados
        db = DatabaseProvider.getDatabase(this)

        //carregar o adapter
        alunoAdapter = AlunoAdapter(emptyList())
        recyclerViewAluno.layoutManager = LinearLayoutManager(this)
        recyclerViewAluno.adapter = alunoAdapter

        carregarAlunos()

        btAdicionarAluno.setOnClickListener {
            adicionarAluno()
        }

    }

    private fun carregarAlunos() {
        CoroutineScope(Dispatchers.IO).launch {
            val lista = db.alunoDao().listarTodos()

            withContext(Dispatchers.Main){
                alunoAdapter.atualizarLista(lista)
            }
        }
    }

    private fun adicionarAluno(){
        CoroutineScope(Dispatchers.IO).launch {

            val novoAluno = AlunoEntity(ra = 123, nome = "Juca")
            val novoAluno1 = AlunoEntity(ra = 456, nome = "Maria")
            val novoAluno2 = AlunoEntity(ra = 678, nome = "Jose")

            //gravando aluno na tabela do banco de dados
            db.alunoDao().inserir(novoAluno)
            db.alunoDao().inserir(novoAluno1)
            db.alunoDao().inserir(novoAluno2)

            //carregar a lista de alunos
            carregarAlunos()
        }
    }
}

