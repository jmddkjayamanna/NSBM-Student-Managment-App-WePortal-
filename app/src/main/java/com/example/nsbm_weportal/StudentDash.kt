package com.example.nsbm_weportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class StudentDash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_dash)
        changeDash()
    }
    private fun changeDash() {
        val lecbtnm1 = findViewById<ImageButton>(R.id.s1)
        val lecbtnm2 = findViewById<ImageButton>(R.id.s2)
        val lecbtnm3 = findViewById<ImageButton>(R.id.s3)
        val lecbtnm4 = findViewById<ImageButton>(R.id.s4)


        lecbtnm1.setOnClickListener {
            val intent1 = Intent(this, StudentTimetable::class.java)
            startActivity(intent1)
        }
        lecbtnm2.setOnClickListener {
            val intent2 = Intent(this, StudentInclass::class.java)
            startActivity(intent2)
        }
        lecbtnm3.setOnClickListener {
            val intent3 = Intent(this, StudentAttendance::class.java)
            startActivity(intent3)
        }
        lecbtnm4.setOnClickListener {
            val intent4 = Intent(this, StudentResult::class.java)
            startActivity(intent4)
        }
    }
}