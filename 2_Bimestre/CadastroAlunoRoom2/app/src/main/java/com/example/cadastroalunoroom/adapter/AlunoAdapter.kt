package com.example.cadastroalunoroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cadastroalunoroom.entity.AlunoEntity

class AlunoAdapter(private var lista: List<AlunoEntity>) :
    RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlunoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1,
                parent, false) as TextView
        return AlunoViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: AlunoViewHolder,
        position: Int
    ) {
        val aluno  = lista[position]
        holder.itemView.text = "Ra: ${aluno.ra} - Nome: ${aluno.nome}"
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun atualizarLista(novaLista: List<AlunoEntity>) {
        lista = novaLista
        notifyDataSetChanged()
    }

    class AlunoViewHolder(val itemView: TextView) :
        RecyclerView.ViewHolder(itemView)

}