package com.example.planner

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.planer.DayActivity
import com.example.planer.R

//не забудь что в этот раз работа с базой даннолй в отедльном потоке


class MainActivity : AppCompatActivity() {

    var mCalendarView: CalendarView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCalendarView = findViewById(R.id.calendar_view)


        mCalendarView?.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth ->
            // При выборе любой даты отображаем Toast сообщение с данными о выбранной дате (Год, Месяц, День):
            Toast.makeText(this@MainActivity,
                """
                    Год: $year
                    Месяц: $month
                    День: $dayOfMonth
                    """.trimIndent(),
                Toast.LENGTH_SHORT).show()

            val intent = Intent(this@MainActivity, DayActivity::class.java)
            startActivity(intent)
        })
    }



}