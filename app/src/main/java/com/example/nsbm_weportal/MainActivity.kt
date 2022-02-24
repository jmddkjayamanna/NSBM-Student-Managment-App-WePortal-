package com.example.nsbm_weportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.lang.StringBuilder
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

class MainActivity : AppCompatActivity() {


    private val database = FirebaseDatabase.getInstance("https://nsbm-weportal-77238-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private val databaseref=database.reference.child("login")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //Assigning XML compoenents to variables

        var username=findViewById<EditText>(R.id.Usernametext)
        var password=findViewById<EditText>(R.id.passwordtext)
        var logbutton=findViewById<Button>(R.id.loginBtn)

        // Create Next
        logbutton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                var username2 = username.getText().toString()
                var password2 = password.getText().toString()
                if (username2.isEmpty() or password2.isEmpty()) {
                    Toast.makeText(
                        this@MainActivity,
                        "Please enter all credentials",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    val run=databaseref.orderByChild("Username").equalTo(username2)
                    val valuelistener=object : ValueEventListener{
                        override fun onDataChange(snapshot: DataSnapshot) {
                            for (ds in snapshot.children) {

                                var pass= ds.child("Password").getValue().toString()
                                var type= ds.child("Type").getValue().toString()
                                if(pass.equals(password2))
                                {
                                    if(type.equals("Student"))
                                    {
                                        startActivity(Intent(this@MainActivity,StudentDash::class.java))
                                    }
                                    if(type.equals("Admin"))
                                    {
                                        startActivity(Intent(this@MainActivity,admindashboard::class.java))
                                    }
                                    if(type.equals("Lecturer")){
                                        startActivity(Intent(this@MainActivity,LecDashboard::class.java))
                                    }
                                }
                                else{
                                    Toast.makeText(this@MainActivity,"Invalid credentials",Toast.LENGTH_LONG).show()
                                }
                                
                            }

                        }


                        override fun onCancelled(error: DatabaseError) {
                            Log.d("Response", error.getMessage())
                        }
                    }
                    run.addListenerForSingleValueEvent(valuelistener)

                }

            }
})


    }


}
