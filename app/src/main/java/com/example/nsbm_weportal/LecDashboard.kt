package com.example.nsbm_weportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class LecDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec_dashboard)

        changeDash()
        Menu()

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
    private fun Menu()
    {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutA1)
        val navView: NavigationView = findViewById(R.id.nav_viewA1)
        val btn=findViewById<Button>(R.id.menuA1)

        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                drawerLayout.openDrawer(GravityCompat.START);
            }

        })


        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_dash -> {
                    this.startActivity(Intent(this,LecDashboard::class.java))
                    Toast.makeText(
                        applicationContext,
                        "Clicked Dashboard",
                        Toast.LENGTH_SHORT
                    ).show()}
                R.id.nav_profile -> {
                    Toast.makeText(
                    applicationContext,
                    "Clicked Profile",
                    Toast.LENGTH_SHORT
                ).show()
                    this.startActivity(Intent(this,Profile::class.java))}
                R.id.nav_notices -> Toast.makeText(
                    applicationContext,
                    "Clicked Notices",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_notifications -> Toast.makeText(
                    applicationContext,
                    "Clicked Notifications",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_help -> Toast.makeText(
                    applicationContext,
                    "Clicked Help",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_about -> Toast.makeText(
                    applicationContext,
                    "Clicked About",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_logout -> {
                    this.startActivity(Intent(this,MainActivity::class.java))
                    Toast.makeText(
                        applicationContext,
                        "Clicked Logout",
                        Toast.LENGTH_SHORT
                    ).show()}

            }
            true

        }


    }
}