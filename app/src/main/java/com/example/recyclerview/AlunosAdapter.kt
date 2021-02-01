package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AlunosAdapter(val alunosList: List<Aluno>, val context: Context) :
    RecyclerView.Adapter<AlunoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AlunoViewHolder(LayoutInflater.from(context).inflate(R.layout.aluno_item, parent, false))

    override fun getItemCount() = alunosList.size

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        holder.name.text = alunosList[position].name
        holder.matricula.text = alunosList[position].matricula
    }
}