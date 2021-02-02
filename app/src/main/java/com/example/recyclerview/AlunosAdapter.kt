package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlunosAdapter(val alunosList: List<Aluno>) :
    RecyclerView.Adapter<AlunosAdapter.AlunoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlunosAdapter.AlunoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.aluno_item, parent, false)
        return AlunoViewHolder(view)
    }


    override fun getItemCount() = alunosList.size

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val name = holder.name
        name.text = alunosList[position].nome

        val matricula = holder.matricula
        matricula.text = alunosList[position].matricula
    }


    inner class AlunoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name by lazy { view.findViewById<TextView>(R.id.tv_name) }
        val matricula by lazy { view.findViewById<TextView>(R.id.tv_matricula) }
    }
}