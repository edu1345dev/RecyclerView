package com.example.recyclerview

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val recycler by lazy { findViewById<RecyclerView>(R.id.recycler_view) }
    val toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
    val button by lazy { findViewById<Button>(R.id.bt_add_alunos) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //seta a toolbar usando o suporte para action bar(barra superior)
        setSupportActionBar(toolbar)

        val alunos = getAlunos()

        recycler.layoutManager = LinearLayoutManager(this)

        //adapter with lambda function
        val adapter = AlunosAdapter(alunos) { aluno, position ->
            Toast.makeText(this@MainActivity, "$aluno, position = $position", Toast.LENGTH_LONG)
                .show()
        }

        //adapter with interface
        val adapterInterface = AlunosAdapterWithInterface(alunos, object : OnAlunoSelected{
            override fun retrieveAlunoAndPosition(aluno: Aluno, position: Int) {
                Toast.makeText(this@MainActivity, "$aluno, position = $position", Toast.LENGTH_LONG)
                    .show()
            }
        })

        recycler.adapter = adapter

        button.setOnClickListener {
            adapter.addAluno()
        }
    }

    private fun getAlunos(): MutableList<Aluno> {
        val alunosList = mutableListOf<Aluno>()

        for (index in 0..30) {
            val aluno = Aluno("Aluno $index", "Matricula $index")
            alunosList.add(aluno)
        }

        return alunosList
    }
}