package com.example.planer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CalendarView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


//используем шэред преференсес
class ActActivity : AppCompatActivity() {

     var TAG: String = "Проверка нажатия на элементы ресайкл"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewTask)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = TaskRecycleAdapter(getCatList())
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun getCatList(): List<String> {//эту функцию потом заменим на ту что берет данные из бд
        return this.resources.getStringArray(R.array.cat_names).toList()
    }



}