package com.example.nsbm_weportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class LecDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec_dashboard)
        changeDash()
    }
    private fun changeDash() {
        val lecbtnm1 = findViewById<ImageButton>(R.id.LecInclassbtn)
        val lecbtnm2 = findViewById<ImageButton>(R.id.LecTimebtn)
        val lecbtnm3 = findViewById<ImageButton>(R.id.LecNoticebtn)


        lecbtnm1.setOnClickListener {
            val intent1 = Intent(this, LecInclassExam::class.java)
            startActivity(intent1)
        }
        lecbtnm2.setOnClickListener {
            val intent2 = Intent(this, LecTimetable::class.java)
            startActivity(intent2)
        }
        lecbtnm3.setOnClickListener {
            val intent3 = Intent(this, LecNotices::class.java)
            startActivity(intent3)
        }
    }
}