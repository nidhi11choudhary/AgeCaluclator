package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectDate.setOnClickListener { view->
            datePicker(view)

        }

    }
        fun datePicker(view : View){
            val myCalender = Calendar.getInstance()
            val year = myCalender.get(Calendar.YEAR)
            val month = myCalender.get(Calendar.MONTH)
            val day = myCalender.get(Calendar.DAY_OF_MONTH)

          val dpd =  DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener {
                        view, selectedYear, selcetedMonth, selectedDayOfMonth ->

                    val selectedDate = "$selectedDayOfMonth/${selcetedMonth+1}/$selectedYear"
                 showselectDate.setText(selectedDate)
                   val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                    val date = sdf.parse(selectedDate)
                      val dateinMinutes = date!!.time / 3600000
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinutes = currentDate!!.time / 3600000
                val diff = ( currentDateInMinutes - dateinMinutes ) / 24

                showAge.setText(diff.toString())
                },
                year, month, day)

            dpd.datePicker.setMaxDate(Date().time - 86400000)
            dpd.show()
            }
        }
