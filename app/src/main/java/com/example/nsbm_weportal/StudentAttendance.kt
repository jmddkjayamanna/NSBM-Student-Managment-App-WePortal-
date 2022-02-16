package com.example.nsbm_weportal

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.google.android.material.navigation.NavigationView

private const val CAMERA_REQUEST_CODE=101
class StudentAttendance : AppCompatActivity() {

    private lateinit var codeScanner: CodeScanner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_attendance)
        Menu()
        setupPermissions()
        codeScanner()
    }
    private fun Menu()
    {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutS2)
        val navView: NavigationView = findViewById(R.id.nav_viewS2)
        val btn=findViewById<Button>(R.id.menuS2)

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
    private fun codeScanner() {
        val scannerView = findViewById<CodeScannerView>(R.id.codeScannerView)
        val attendencebtn = findViewById<Button>(R.id.button54)

        var check: String

        codeScanner = CodeScanner(this, scannerView)

        codeScanner.apply {
            camera = CodeScanner.CAMERA_BACK
            formats = CodeScanner.ALL_FORMATS

            autoFocusMode = AutoFocusMode.SAFE
            scanMode = ScanMode.CONTINUOUS
            isAutoFocusEnabled = true
            isFlashEnabled = false

            decodeCallback = DecodeCallback {
                runOnUiThread {
                    check = it.text
                    if (check.isEmpty()) {
                        attendencebtn.visibility = View.INVISIBLE

                    } else {
                        attendencebtn.visibility = View.VISIBLE
                        attendencebtn.setOnClickListener {
                            val openURL = Intent(Intent.ACTION_VIEW)

                            openURL.data = Uri.parse(check)
                            startActivity(openURL)
                        }
                    }
                }

            }


            errorCallback = ErrorCallback {
                runOnUiThread {
                    Log.e("Main", "Camera initialization error: ${it.message}")
                }
            }
        }
        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }

    }


    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            this, arrayOf(android.Manifest.permission.CAMERA),
            CAMERA_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)


        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(
                        this, "You need the camera permission to be able for using this app",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    //sucessful
                }

            }

        }


    }
}