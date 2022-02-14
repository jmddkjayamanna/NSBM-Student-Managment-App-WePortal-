package com.example.nsbm_weportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class admindashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admindashboard)
        changeDash()


    }

    private fun changeDash()
    {
        val adminbtnm1 = findViewById<Button>(R.id.adminDash)
        val adminbtnm2 = findViewById<Button>(R.id.adminNotices)

        adminbtnm1.setOnClickListener {
            val intent2= Intent(this,admintimetable::class.java)
            startActivity(intent2)
        }
        adminbtnm2.setOnClickListener {
            val intent2= Intent(this,adminnotices::class.java)
            startActivity(intent2)
        }
    }

}