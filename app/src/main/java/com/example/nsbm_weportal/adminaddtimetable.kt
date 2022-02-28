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
import java.util.*

class adminaddtimetable : AppCompatActivity() {

    private val database = FirebaseDatabase.getInstance("https://nsbm-weportal-77238-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private val databaseref = database.reference.child("notice")

    var batch= arrayOf("Click To Select Batch","18.2","19.1","19.2","20.1","20.2","20.3","21.1","All")
    var Degree= arrayOf("Click To Select Degree","Management Information Systems (UGC)","Management Information Systems (UCD)","Software Engineering (UGC)","Software Engineering (Plymoth)","All")
    var module= arrayOf("Click To Select Module","OPP with JAVA","Software Quality Assurance","Mobile Application Development")
    var Lectuerer= arrayOf("Click To Select Lecturer","Mr Iaman Ashly","Mr Mohomed Safraz","Ms Pavithra Subashini")
    var time= arrayOf("Click To Select Time","9.00Am - 12.00Pm","1.00pm-4.00pm")
    var mode= arrayOf("Click To Select Mode","Hybrid","Online","Physical")
    var hall= arrayOf("Click To Select Hall","L1001","L1003","L009")

    var Selectedbatch=""
    var SelectedDegree=""
    var N =""
    var SelecteModule=""
    var SelectedLect=""
    var SelectedTime=""
    var SelectedMode=""
    var SelectedHall=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adminaddtimetable)
        Menu()
        var getbatch=findViewById<Spinner>(R.id.batcha)
        var getdegree=findViewById<Spinner>(R.id.degreea)
        var getmodule=findViewById<Spinner>(R.id.modulea)
        var getlect=findViewById<Spinner>(R.id.lectuerera)
        var gettime=findViewById<Spinner>(R.id.timea)
        var getdate=findViewById<DatePicker>(R.id.datea)
        var getmode=findViewById<Spinner>(R.id.modea)
        var gethall=findViewById<Spinner>(R.id.halla)
        var addbtn=findViewById<Button>(R.id.addtime)

        val arrAdapter= ArrayAdapter(getApplicationContext(),R.layout.custom_spinner_1,batch)
        getbatch.adapter=arrAdapter
        val arrAdapter2= ArrayAdapter(getApplicationContext(),R.layout.custom_spinner_1,Degree)
        getdegree.adapter=arrAdapter2
        val arrAdapter3= ArrayAdapter(getApplicationContext(),R.layout.custom_spinner_1,module)
        getmodule.adapter=arrAdapter3
        val arrAdapter4= ArrayAdapter(getApplicationContext(),R.layout.custom_spinner_1,Lectuerer)
        getlect.adapter=arrAdapter4
        val arrAdapter5= ArrayAdapter(getApplicationContext(),R.layout.custom_spinner_1,time)
        gettime.adapter=arrAdapter5
        val arrAdapter6= ArrayAdapter(getApplicationContext(),R.layout.custom_spinner_1,mode)
        getmode.adapter=arrAdapter6
        val arrAdapter7= ArrayAdapter(getApplicationContext(),R.layout.custom_spinner_1,hall)
        gethall.adapter=arrAdapter7

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
        getmodule.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                SelecteModule=module.get(position)


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        getlect.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                SelectedLect=Lectuerer.get(position)


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        gettime.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                SelectedTime=time.get(position)


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        getmode.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                SelectedMode=mode.get(position)


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        gethall.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                SelectedHall=hall.get(position)


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }
    private fun Menu()
    {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutL2)
        val navView: NavigationView = findViewById(R.id.nav_viewL2)
        val btn=findViewById<Button>(R.id.menul2)

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

    private fun InsertTimetble()
    {
        var noticeMSG=findViewById<EditText>(R.id.noticemsg)
        val Name="Mr Iman Ashly"
        val Batch=Selectedbatch
        val Degree=SelectedDegree


        val Atimetable=Noticeclass(Batch,Degree,noticeMSG.getText().toString(),Name)
        databaseref.child(Name).setValue(Atimetable).addOnSuccessListener {
            Toast.makeText(this,"Notice Added Succesfully",Toast.LENGTH_LONG).show()
        }.addOnFailureListener{
            it.printStackTrace();
        }


    }
}