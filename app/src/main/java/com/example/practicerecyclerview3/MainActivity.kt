package com.example.practicerecyclerview3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val todoList = ArrayList<ToDoData>()
    private lateinit var recyclerView: RecyclerView
    private val adapter = RecyclerAdapter(todoList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val button: Button = findViewById(R.id.button)
        val editText: EditText = findViewById(R.id.editText)
        button.setOnClickListener {
            val addData = ToDoData(editText.text.toString())
            todoList.add(addData)
            adapter.notifyItemInserted(todoList.lastIndex)
            editText.text = null
        }
    }
}