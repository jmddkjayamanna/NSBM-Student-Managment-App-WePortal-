package com.example.nsbm_weportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat




class StudentDash : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_dash)
        changeDash()
        Menu()

    }


 private fun Menu()
{
    val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutS)
    val navView: NavigationView = findViewById(R.id.nav_viewS)
    val btn=findViewById<Button>(R.id.menuS)

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
            R.id.nav_profile -> {Toast.makeText(
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
    private fun changeDash() {
        val lecbtnm1 = findViewById<ImageButton>(R.id.s1)
        val lecbtnm2 = findViewById<ImageButton>(R.id.s2)
        val lecbtnm3 = findViewById<ImageButton>(R.id.s3)
        val lecbtnm4 = findViewById<ImageButton>(R.id.s4)


        lecbtnm1.setOnClickListener {
            val intent1 = Intent(this, StudentTimetable::class.java)
            startActivity(intent1)
        }
        lecbtnm2.setOnClickListener {
            val intent2 = Intent(this, StudentInclass::class.java)
            startActivity(intent2)
        }
        lecbtnm3.setOnClickListener {
            val intent3 = Intent(this, StudentAttendance::class.java)
            startActivity(intent3)
        }
        lecbtnm4.setOnClickListener {
            val intent4 = Intent(this, StudentResult::class.java)
            startActivity(intent4)
        }
    }

}

