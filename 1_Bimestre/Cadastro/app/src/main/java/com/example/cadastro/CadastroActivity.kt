package com.example.cadastro

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cadastro.model.Aluno
import com.example.cadastro.repository.AlunoRepository

class CadastroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val edRaAluno = findViewById<EditText>(R.id.edRaAluno)
        val edNomeAluno = findViewById<EditText>(R.id.edNomeAluno)
        val btSalvar = findViewById<Button>(R.id.btSalvar)
        btSalvar.setOnClickListener {

            val ra = edRaAluno.text.toString()
            val nome = edNomeAluno.text.toString()
            val aluno = Aluno(ra, nome)

            AlunoRepository.listaAlunos.add(aluno)

            finish()
        }

    }
}