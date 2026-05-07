package com.example.cadastroalunoroom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cadastroalunoroom.dao.AlunoDao
import com.example.cadastroalunoroom.entity.AlunoEntity

@Database(entities = [AlunoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun alunoDao(): AlunoDao
}