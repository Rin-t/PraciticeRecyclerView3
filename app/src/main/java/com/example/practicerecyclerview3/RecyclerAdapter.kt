package com.example.practicerecyclerview3

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val todoList: ArrayList<ToDoData>): RecyclerView.Adapter<RecyclerAdapter.ViewHolderItem>() {

    inner class ViewHolderItem(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewHolder: TextView = itemView.findViewById(R.id.textView)

        init {
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                val listPosition = todoList[position].todo

                AlertDialog.Builder(itemView.context)
                    .setTitle(listPosition)
                    .setMessage("削除しますか？")
                    .setPositiveButton("はい")  { _, _ ->
                        todoList.removeAt(position)
                        notifyItemRemoved(position)
                    }
                    .setNegativeButton("いいえ", null)
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        val item = LayoutInflater.from(parent.context).
        inflate(R.layout.todo_item, parent,false)
        return  ViewHolderItem(item)
    }

    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
        holder.textViewHolder.text = todoList[position].todo
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}