package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val recycler by lazy { findViewById<RecyclerView>(R.id.recycler_view) }
    val toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //seta a toolbar usando o suporte para action bar(barra superior)
        setSupportActionBar(toolbar)

        val alunos = getAlunos()
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = AlunosAdapter(alunos, this)
    }

    private fun getAlunos(): List<Aluno> {
        val alunosList = mutableListOf<Aluno>()
        for (index in 0..30) {
            alunosList.add(Aluno(name = "Aluno $index", matricula = "Matricula $index"))
        }
        return alunosList.toList()
    }
}