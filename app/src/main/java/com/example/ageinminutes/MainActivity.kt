package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var tvDate : TextView ?= null
    var tvTime : TextView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateBtn : Button = findViewById(R.id.btnDate)

        tvDate = findViewById(R.id.selectedDate)

        tvTime = findViewById(R.id.tvAgeMins)

        dateBtn.setOnClickListener {
            datePicker()
        }

    }

    private fun datePicker(){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val date = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd:DatePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view,selectedYear,selectedMonth,dayOfMonth ->

                val selectedDate : String = "$dayOfMonth/${selectedMonth+1}/$selectedYear"
                tvDate?.text = selectedDate

                val sdf:SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy",Locale.UK)
                val theDate = sdf.parse(selectedDate)

                theDate?.let {
                    val selectedDateInMinutes = theDate.time/60000

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                    currentDate?.let {
                        val currentTimeInMinutes = currentDate.time/60000

                        val timeDifferenceInMinutes = currentTimeInMinutes - selectedDateInMinutes
                        tvTime?.text = timeDifferenceInMinutes.toString()
                    }
                }



            },
            year,
            month,
            date)

        dpd.datePicker.maxDate = System.currentTimeMillis()-86400000
        dpd.show()

    }
}