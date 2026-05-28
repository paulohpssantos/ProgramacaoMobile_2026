package com.example.cadastroalunoroom.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cadastroalunoroom.entity.AlunoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AlunoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(aluno: AlunoEntity)

    @Query("SELECT * FROM aluno ORDER BY nome ASC")
    fun listarTodos(): Flow<List<AlunoEntity>>
}