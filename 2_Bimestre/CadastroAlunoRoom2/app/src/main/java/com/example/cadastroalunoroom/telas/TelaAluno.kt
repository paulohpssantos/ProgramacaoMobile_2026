package com.example.cadastroalunoroom.telas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cadastroalunoroom.viewmodel.AlunoViewModel
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TelaAluno(viewModel: AlunoViewModel){

    val context = LocalContext.current

    val alunos by viewModel.alunos
        .collectAsStateWithLifecycle(initialValue = emptyList())

    var mostarDialog by remember {
        mutableStateOf(false)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {mostarDialog = true}
            ) {
                Text("+")
            }
        }
    ){
        padding ->
        LazyColumn (
            modifier = Modifier.padding(padding).fillMaxSize()
        ){
           items(alunos){ aluno ->
               Card (
                   modifier = Modifier.fillMaxWidth().padding(8.dp)
               ){
                   Column (
                       modifier = Modifier.padding(16.dp)
                   ){
                       Text(text = "RA: ${aluno.ra}")
                       Text(text = "Nome: ${aluno.nome}")
                   }
               }
           }
        }
    }



}