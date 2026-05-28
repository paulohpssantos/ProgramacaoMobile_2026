package com.example.cadastroalunoroom.repository

import com.example.cadastroalunoroom.dao.AlunoDao
import com.example.cadastroalunoroom.entity.AlunoEntity

class AlunoRepository (private val alunoDao: AlunoDao) {

    val alunos = alunoDao.listarTodos()

    suspend fun inserir(alunoEntity: AlunoEntity){
        alunoDao.inserir(alunoEntity)
    }
}