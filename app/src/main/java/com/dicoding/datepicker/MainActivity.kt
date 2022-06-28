package com.dicoding.datepicker

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {


    //var cal: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView  = findViewById(R.id.tv_date)
        textView.text = SimpleDateFormat("dd.MM.yyyy",Locale.getDefault()).format(System.currentTimeMillis())

        val cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
            textView.text = sdf.format(cal.time)

        }

        textView.setOnClickListener {
            DatePickerDialog(this@MainActivity, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

//        val dateSetListener = object: DatePickerDialog.OnDateSetListener{
//            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {
//                cal.set(Calendar.YEAR,year)
//                cal.set(Calendar.MONTH,monthOfYear)
//                cal.set(Calendar.DAY_OF_MONTH,monthOfYear)
//                updateDateInView()
//            }
//        }
//        binding.button.setOnClickListener(object: View.OnClickListener{
//            override fun onClick(view: View?) {
//                DatePickerDialog(this@MainActivity, dateSetListener,
//                    cal.get(Calendar.YEAR),
//                    cal.get(Calendar.MONTH),
//                    cal.get(Calendar.DAY_OF_MONTH)).show()
//            }
//        })
//    }
//    private fun updateDateInView(){
//        val myFormat = "dd/MM/yyyy"
//        val sdf = SimpleDateFormat(myFormat,Locale.US)
//        binding.tvDate.text = sdf.format(cal.time)
//    }
}

//        val picker = findViewById<DatePicker>(R.id.date_picker)
//        val today = Calendar.getInstance()
//        picker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH))  {
//            view, year, month, day ->
//            val month = month+1
//            val toast = "You have selected : $day/$month/$year"
//            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()