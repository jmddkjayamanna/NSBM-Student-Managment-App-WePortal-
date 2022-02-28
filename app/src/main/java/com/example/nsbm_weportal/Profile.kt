package com.example.nsbm_weportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Profile : AppCompatActivity() {
    private val database =
        FirebaseDatabase.getInstance("https://nsbm-weportal-77238-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private val databaseref = database.reference.child("profile")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        Menu()
        var uname:String =MainActivity.getuname

        //get data
        var userimg=findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.profileimg)
        var username=findViewById<TextView>(R.id.proiflename)
        var userId=findViewById<TextView>(R.id.Profileid)
        var userbatch=findViewById<TextView>(R.id.profilebatch)
        var userdegree=findViewById<TextView>(R.id.profiledegree)
        var userEmail=findViewById<TextView>(R.id.profileemail)

        var btnlog=findViewById<Button>(R.id.btnlogout)
        btnlog.setOnClickListener {
            val intent3 = Intent(this, MainActivity::class.java)
            startActivity(intent3)
        }
        val run = databaseref.orderByChild("username").equalTo(uname)
        val valueListener=object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children)
                {
                    //Module

                    var u1= ds.child("Image").getValue().toString()
                    var u2= ds.child("Name").getValue().toString()
                    var u3= ds.child("Degree").getValue().toString()
                    var u4= ds.child("Batch").getValue().toString()
                    var u5= ds.child("Email").getValue().toString()
                    var u6= ds.child("Id").getValue().toString()



                    //Assign To textView

                   username.setText(u2)
                    userId.setText(u6)
                    userbatch.setText(u4)
                    userdegree.setText(u3)
                    userEmail.setText(u5)




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
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutP)
        val navView: NavigationView = findViewById(R.id.nav_viewP)
        val btn=findViewById<Button>(R.id.menuP)

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