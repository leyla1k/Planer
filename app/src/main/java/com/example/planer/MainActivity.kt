package com.example.planer


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.view.View
import android.widget.*
import android.widget.CalendarView.OnDateChangeListener
import androidx.appcompat.app.AppCompatActivity


//не забудь что в этот раз работа с базой даннолй в отедльном потоке


class MainActivity : AppCompatActivity() {

    lateinit var mCalendarView: CalendarView
    lateinit var spinner: Spinner
    lateinit var adapter: ArrayAdapter<*>
    val context: Context = this

        //мб засунуть это куданибудь лучше скажем в ресурсы
    var tasks = arrayOf("add recurring task1", "Volvo2", "Volkswagen3", "change goal4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lateinit var intent: Intent
        mCalendarView = findViewById(R.id.calendar_view)
        spinner = findViewById(R.id.spinner2)




        mCalendarView.setOnDateChangeListener(OnDateChangeListener { _, year, month, dayOfMonth ->
            // При выборе любой даты отображаем Toast сообщение с данными о выбранной дате (Год, Месяц, День):
            Toast.makeText(
                this,
                """
                    Год: $year
                    Месяц: $month
                    День: $dayOfMonth
                    """.trimIndent(),
                Toast.LENGTH_SHORT
            ).show()

            intent =
                Intent(context, DayActivity::class.java)//че это вдруг пэкдж контекст. узнать!
            startActivity(intent)
        })




    }


    override fun onStart() {
        super.onStart()

        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tasks)

        // Set layout to use when the spinner with the list is displayed
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set Adapter to Spinner
        spinner.setAdapter(adapter)

        //это не в onCreate иначе метод перестает работать
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int ,
                id: Long
            ) {
//позишн всегда 0 что делать..
                if (position == 1) {
                    intent =
                        Intent(context, ActActivity::class.java)//че это вдруг пэкдж контекст. узнать!
                    startActivity(intent)
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

    }
}