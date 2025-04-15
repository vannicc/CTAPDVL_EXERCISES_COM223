package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var textViewUserName: TextView
    private lateinit var textViewUser: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity) // Make sure this is your correct layout file name

        textViewUserName = findViewById(R.id.textViewUserName)
        textViewUser = findViewById(R.id.textViewUser)

        // Get data from Intent
        val userName = intent.getStringExtra("textViewUserName")

        // Set it to TextView
        textViewUserName.text = userName
        textViewUser.text = userName
    }
}
