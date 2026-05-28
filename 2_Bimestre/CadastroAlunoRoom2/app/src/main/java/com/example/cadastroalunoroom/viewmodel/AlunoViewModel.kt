package com.example.cadastroalunoroom.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cadastroalunoroom.entity.AlunoEntity
import com.example.cadastroalunoroom.repository.AlunoRepository
import kotlinx.coroutines.launch

class AlunoViewModel(private val repository: AlunoRepository) : ViewModel() {

    val alunos = repository.alunos

    fun adicionarAluno(ra: Int, nome: String) {

        viewModelScope.launch {
            val aluno = AlunoEntity(ra, nome)
            repository.inserir(aluno)
        }
    }

}