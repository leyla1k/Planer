package com.example.planer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TaskRecycleAdapter(private val names: List<String>) : RecyclerView.Adapter<TaskRecycleAdapter.TaskViewHolder>() {




    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val largeEditText: EditText = itemView.findViewById(R.id.editTextTask)
        val smallTextView: TextView = itemView.findViewById(R.id.textViewSmall)





    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item_task, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.largeEditText.setText(names[position])
        holder.smallTextView.text = "Период повторения: "
    }

    override fun getItemCount(): Int { //Возвращает количество элементов списка.
        return names.size
    }




}



