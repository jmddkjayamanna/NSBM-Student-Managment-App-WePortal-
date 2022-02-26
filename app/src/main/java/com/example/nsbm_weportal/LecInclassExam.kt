package com.example.nsbm_weportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class LecInclassExam : AppCompatActivity() {
    private val database =
        FirebaseDatabase.getInstance("https://nsbm-weportal-77238-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private val databaseref = database.reference.child("inClass_exams")

    var batchget=""
    var moduleget=""
    var batch= arrayOf("Click To Select Batch","18.2","19.1","19.2","20.1","20.2","20.3","21.1")
    var module= arrayOf("Click To Select Module","Java EE","Database Managment Systems","Programming With C","Mathamtics","Mobile Application Development","System Analysis & Design","Software Quality Assurance")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec_inclass_exam)
        Menu()

         var getbatch=findViewById<Spinner>(R.id.degreedetails)
        var getmodule=findViewById<Spinner>(R.id.modulespin)


        val arrAdapter=ArrayAdapter(getApplicationContext(),R.layout.custom_spinner_1,batch)
        getbatch.adapter=arrAdapter
        val arrAdapter2=ArrayAdapter(getApplicationContext(),R.layout.custom_spinner_1,module)
        getmodule.adapter=arrAdapter2

        getbatch.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
               batchget=batch.get(position)


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        getmodule.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                moduleget=module.get(position)


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        var search=findViewById<Button>(R.id.searchBTN)
        search.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val run = databaseref.orderByChild("Batch").equalTo(batchget)
                val valuelistener = object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        for (ds in snapshot.children) {

                            var check1=ds.child("Batch").getValue().toString()
                            if(batchget==check1)
                            {
                                Toast.makeText(
                                    this@LecInclassExam,
                                    "Exits data",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                            else{
                                Toast.makeText(
                                    this@LecInclassExam,
                                    "No data",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }

                    }

                    override fun onCancelled(error: DatabaseError) {

                    }




                }
                run.addListenerForSingleValueEvent(valuelistener)

            }
        })

    }
    private fun Menu()
    {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutA2)
        val navView: NavigationView = findViewById(R.id.nav_viewA2)
        val btn=findViewById<Button>(R.id.menuA2)

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