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

class StudentResult : AppCompatActivity() {
    companion object {
        var YScheck :String=String()

    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_result)
        Menu()

        val btn1=findViewById<ImageButton>(R.id.btny1s1)
        val btn2=findViewById<ImageButton>(R.id.btny1s2)
        val btn3=findViewById<ImageButton>(R.id.btny2s1)
        val btn4=findViewById<ImageButton>(R.id.btny2s2)
        val btn5=findViewById<ImageButton>(R.id.btny3s1)
        val btn6=findViewById<ImageButton>(R.id.btny3s2)
        val btn7=findViewById<ImageButton>(R.id.btny4s1)
        val btn8=findViewById<ImageButton>(R.id.btny4s2)



            btn1.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View?) {
                Toast.makeText(this@StudentResult,"Year 1 Semester 1 Results",Toast.LENGTH_LONG).show()
                    YScheck="Y1S1"
                    startActivity(Intent(this@StudentResult,StudentResultDisplay::class.java))


                }
                })

            btn2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Toast.makeText(this@StudentResult,"Year 1 Semester 2 Results",Toast.LENGTH_LONG).show()
                YScheck="Y1S2"
                startActivity(Intent(this@StudentResult,StudentResultDisplay::class.java))

            }})
        btn3.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View?) {
                        Toast.makeText(this@StudentResult,"Year 2 Semester 1 Results",Toast.LENGTH_LONG).show()
                        YScheck="Y2S1"
                        startActivity(Intent(this@StudentResult,StudentResultDisplay::class.java))

                    }})
        btn4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Toast.makeText(this@StudentResult,"Year 2 Semester 2 Results",Toast.LENGTH_LONG).show()
                YScheck="Y2S2"
                startActivity(Intent(this@StudentResult,StudentResultDisplay::class.java))

                        }})
        btn5.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Toast.makeText(this@StudentResult,"Year 3 Semester 1 Results",Toast.LENGTH_LONG).show()
                YScheck="Y3S1"
                startActivity(Intent(this@StudentResult,StudentResultDisplay::class.java))

                            }})
        btn6.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Toast.makeText(this@StudentResult,"Year 3 Semester 2 Results",Toast.LENGTH_LONG).show()
                YScheck="Y3S2"
                startActivity(Intent(this@StudentResult,StudentResultDisplay::class.java))

                                }
                            })
        btn7.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Toast.makeText(this@StudentResult,"Year 4 Semester 1 Results",Toast.LENGTH_LONG).show()
                YScheck="Y4S1"
                startActivity(Intent(this@StudentResult,StudentResultDisplay::class.java))

            }
        })
        btn8.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Toast.makeText(this@StudentResult,"Year 4 Semester 2 Results",Toast.LENGTH_LONG).show()
                YScheck="Y4S2"
                startActivity(Intent(this@StudentResult,StudentResultDisplay::class.java))

            }})
    }
    private fun Menu()
    {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutS5)
        val navView: NavigationView = findViewById(R.id.nav_viewS5)
        val btn=findViewById<Button>(R.id.menuS5)

        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                drawerLayout.openDrawer(GravityCompat.START);
            }

        })


        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_dash -> {
                    this.startActivity(Intent(this,StudentDash::class.java))
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