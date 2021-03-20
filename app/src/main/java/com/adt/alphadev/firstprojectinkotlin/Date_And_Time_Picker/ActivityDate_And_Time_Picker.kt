package com.adt.alphadev.firstprojectinkotlin.Date_And_Time_Picker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adt.alphadev.firstprojectinkotlin.R
import kotlinx.android.synthetic.main.activity_date__and__time__picker.*
import java.text.SimpleDateFormat
import java.util.*

class ActivityDate_And_Time_Picker : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date__and__time__picker)

        setDate()

        et_time.setOnClickListener {
           setTime();
        }

    }


    fun setDate(){
        val myCalender = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalender.set(Calendar.YEAR, year)
            myCalender.set(Calendar.MONTH, month)
            myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalender)
        }

        et_date.setOnClickListener {
           DatePickerDialog(this, datePicker, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH),
           myCalender.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        et_date.setText(sdf.format(myCalendar.time))
    }

    private fun setTime() {
        val currentTime = Calendar.getInstance()
        val startHour = currentTime.get(Calendar.HOUR_OF_DAY)
        val startMinute = currentTime.get(Calendar.MINUTE)

        TimePickerDialog(this, TimePickerDialog.OnTimeSetListener{ view, hourOfDay, minute ->
            et_time.setText("$hourOfDay:$minute")
        }, startHour, startMinute, false).show()
    }

}