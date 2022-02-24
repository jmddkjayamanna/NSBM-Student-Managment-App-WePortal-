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



                }

                })

            btn2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {


            }})
        btn3.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View?) {

                    }})
        btn4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {


                        }})
        btn5.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {


                            }})
        btn6.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {


                                }
                            })
        btn7.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {


            }
        })
        btn8.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {


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