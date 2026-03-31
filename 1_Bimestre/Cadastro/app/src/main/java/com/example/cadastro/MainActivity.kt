package com.example.cadastro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cadastro.adapter.AlunoAdapter
import com.example.cadastro.repository.AlunoRepository
import com.example.cadastro.ui.theme.CadastroTheme

class MainActivity : ComponentActivity() {

    private lateinit var adapterAlunos : AlunoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        //Carrega a lista de alunos no recycler view
        val rvAlunos = findViewById<RecyclerView>(R.id.rvAlunos)

        adapterAlunos = AlunoAdapter(AlunoRepository.listaAlunos)

        rvAlunos.layoutManager = LinearLayoutManager(this)
        rvAlunos.adapter = adapterAlunos

        val btAbrirTela = findViewById<Button>(R.id.btAbrirTela)

        btAbrirTela.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }
    //atualiza a lista ao voltar na tela
    override fun onResume() {
        super.onResume()
        adapterAlunos.notifyDataSetChanged()
    }
}

