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

class admindashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admindashboard)
        changeDash()
        Menu()


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
    private fun Menu()
    {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutL1)
        val navView: NavigationView = findViewById(R.id.nav_viewL1)
        val btn=findViewById<Button>(R.id.menul1)

        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                drawerLayout.openDrawer(GravityCompat.START);
            }

        })


        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_dash -> {
                    this.startActivity(Intent(this,admindashboard::class.java))
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