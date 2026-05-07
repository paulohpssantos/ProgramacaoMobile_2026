package com.example.cadastroalunoroom.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aluno")
data class AlunoEntity(
    @PrimaryKey val ra: Int,
    val nome: String
)
