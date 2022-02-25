package com.example.nsbm_weportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class StudentResultDisplay : AppCompatActivity() {
    private val database =
        FirebaseDatabase.getInstance("https://nsbm-weportal-77238-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private val databaseref = database.reference.child("result")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_result_display)
        Menu()
        backbtn()
        //Year Select and Username getting
        var uname:String =MainActivity.getuname
        var YS:String=StudentResult.YScheck
        var unameYS:String=""+uname+""+YS

        var head=findViewById<Button>(R.id.head)
        if(YS=="Y1S1")
        {
            head.setText("Year 1 Semester 1 Results")
        }
        if(YS=="Y1S2")
        {
            head.setText("Year 1 Semester 2 Results")
        }
        if(YS=="Y2S1")
        {
            head.setText("Year 2 Semester 1 Results")
        }
        if(YS=="Y2S2")
        {
            head.setText("Year 2 Semester 2 Results")
        }
        if(YS=="Y3S1")
        {
            head.setText("Year 3 Semester 1 Results")
        }
        if(YS=="Y3S2")
        {
            head.setText("Year 3 Semester 2 Results")
        }
        if(YS=="Y4S1")
        {
            head.setText("Year 4 Semester 1 Results")
        }
        if(YS=="Y4S2")
        {
            head.setText("Year 4 Semester 2 Results")
        }

        // Assign Varibles
        //Module
        var M1=findViewById<TextView>(R.id.M1)
        var M2=findViewById<TextView>(R.id.M2)
        var M3=findViewById<TextView>(R.id.M3)
        var M4=findViewById<TextView>(R.id.M4)
        var M5=findViewById<TextView>(R.id.M5)

        //Grade
        var G1=findViewById<TextView>(R.id.G1)
        var G2=findViewById<TextView>(R.id.G2)
        var G3=findViewById<TextView>(R.id.G3)
        var G4=findViewById<TextView>(R.id.G4)
        var G5=findViewById<TextView>(R.id.G5)
        //DB Data retrive

        val run = databaseref.orderByChild("UnameRs").equalTo(unameYS)
        val valueListener=object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children)
                {
                    //Module
                    var m1= ds.child("Module1").getValue().toString()
                    var m2= ds.child("Module2").getValue().toString()
                    var m3= ds.child("Module3").getValue().toString()
                    var m4= ds.child("Module4").getValue().toString()
                    var m5= ds.child("Module5").getValue().toString()

                    //Grade
                    var g1= ds.child("Grade1").getValue().toString()
                    var g2= ds.child("Grade2").getValue().toString()
                    var g3= ds.child("Grade3").getValue().toString()
                    var g4= ds.child("Grade4").getValue().toString()
                    var g5= ds.child("Grade5").getValue().toString()

                    //Assign To textView
                    M1.setText(m1)
                    M2.setText(m2)
                    M3.setText(m3)
                    M4.setText(m4)
                    M5.setText(m5)

                    G1.setText(g1)
                    G2.setText(g2)
                    G3.setText(g3)
                    G4.setText(g4)
                    G5.setText(g5)

                }
            }


            override fun onCancelled(error: DatabaseError) {
                Log.d("Response", error.getMessage())
            }
        }
        run.addListenerForSingleValueEvent(valueListener)


    }
    private fun Menu()
    {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val btn=findViewById<Button>(R.id.menus6)

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

    private fun backbtn()
    {
        var rback=findViewById<ImageButton>(R.id.Resultback)
        rback.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                startActivity(Intent(this@StudentResultDisplay,StudentResult::class.java))
            }
        })


    }


}