package com.example.nsbm_weportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class LecNotices : AppCompatActivity() {
    private val database = FirebaseDatabase.getInstance("https://nsbm-weportal-77238-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private val databaseref = database.reference.child("notice")

    var batch= arrayOf("Click To Select Batch","18.2","19.1","19.2","20.1","20.2","20.3","21.1","All")
    var Degree= arrayOf("Click To Select Degree","Management Information Systems (UGC)","Management Information Systems (UCD)","Software Engineering (UGC)","Software Engineering (Plymoth)","All")

    var Selectedbatch=""
    var SelectedDegree=""
    var N =""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lec_notices)
        Menu()

        var getbatch=findViewById<Spinner>(R.id.batchspin)
        var getdegree=findViewById<Spinner>(R.id.degreespin)

        var noticebtn=findViewById<Button>(R.id.noticeAdd)

        //Spinner Part
        val arrAdapter= ArrayAdapter(getApplicationContext(),R.layout.custom_spinner_1,batch)
        getbatch.adapter=arrAdapter
        val arrAdapter2= ArrayAdapter(getApplicationContext(),R.layout.custom_spinner_1,Degree)
        getdegree.adapter=arrAdapter2

        getbatch.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Selectedbatch=batch.get(position)


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        getdegree.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                SelectedDegree=Degree.get(position)


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        noticebtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                InsertNotice()
            }
        })


    }
    private fun Menu()
    {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutA5)
        val navView: NavigationView = findViewById(R.id.nav_viewA5)
        val btn=findViewById<Button>(R.id.menuA5)

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
    private fun InsertNotice()
    {
        var noticeMSG=findViewById<EditText>(R.id.noticemsg)
        val Name="Mr Iman Ashly"
        val Batch=Selectedbatch
        val Degree=SelectedDegree


        val Snotice=Noticeclass(Batch,Degree,noticeMSG.getText().toString(),Name)
        databaseref.child(Name).setValue(Snotice).addOnSuccessListener {
            Toast.makeText(this,"Notice Added Succesfully",Toast.LENGTH_LONG).show()
        }.addOnFailureListener{
            it.printStackTrace();
        }


    }
}