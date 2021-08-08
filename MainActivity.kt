package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener {view->
           getcalender(view)
        }
    }
    private fun getcalender(view: View){
        var mycalender=Calendar.getInstance()
        var year=mycalender.get(Calendar.YEAR)
        var month=mycalender.get(Calendar.MONTH)
        var day=mycalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, day ->
            val selectedDate="$day/${month+1}/$year"
            var textview1=findViewById<TextView>(R.id.textt)
            textview1.text=selectedDate
            var dob=Calendar.getInstance()
            dob.set(year,month,day)
            //  20/03/2021                                 24/03/2000=21
            var age=mycalender.get(Calendar.YEAR)-dob.get(Calendar.YEAR)
            if(mycalender.get(Calendar.DAY_OF_YEAR)<dob.get(Calendar.DAY_OF_YEAR))
            {
                age--
            }
            var textView4=findViewById<TextView>(R.id.textviwe4)
            textView4.text="Your age is $age"
        }
            ,year
            ,month
            ,day).show()//this value is the current date
    }

}