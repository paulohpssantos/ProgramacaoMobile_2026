package com.example.cadastro.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.cadastro.R
import com.example.cadastro.model.Aluno

class AlunoAdapter(private val listaAlunos: List<Aluno>):
    RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder>()  {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlunoViewHolder {
        val view = LayoutInflater
            .from( parent.context)
            .inflate(R.layout.item_list, parent, false)

        return AlunoViewHolder(view)

    }

    //Responsável por adicionar os dados do aluno na tela
    override fun onBindViewHolder(
        holder: AlunoViewHolder,
        position: Int
    ) {
        val aluno = listaAlunos[position]
        holder.tvNome.text = aluno.nome;
        holder.tvRa.text = aluno.ra;
    }

    override fun getItemCount(): Int {
        return listaAlunos.size
    }

    class AlunoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvRa = itemView.findViewById<TextView>(R.id.tvRa)
        val tvNome = itemView.findViewById<TextView>(R.id.tvNome)
    }

}