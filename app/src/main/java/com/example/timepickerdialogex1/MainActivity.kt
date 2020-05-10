package com.example.timepickerdialogex1

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity(),TimePickerDialog.OnTimeSetListener {
var t = "10:10: AM"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_time.text = Calendar.getInstance().time.let { DateFormat.getTimeInstance().format(it) }
        bt_timepicker.setOnClickListener {
            TimePickerDialogEx().show(supportFragmentManager,"timepickerdialoge")
        }
    }


    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        Toast.makeText(this,"$hourOfDay:$minute",Toast.LENGTH_LONG).show()
        var c = Calendar.getInstance()
        c.set(Calendar.HOUR_OF_DAY,hourOfDay)
        c.set(Calendar.MINUTE,minute)
        var time = c.time
        DateFormat.getTimeInstance().format(time).let { tv_time.text = it }

    }
}
