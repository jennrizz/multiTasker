package com.example.multitasker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btnLogin = findViewById<Button>(R.id.login)
        btnLogin.setOnClickListener {
            proceed()
        }
    }

    private fun proceed() {
        val input_name = findViewById<EditText>(R.id.txtPersonName).text.toString()
        val input_password = findViewById<EditText>(R.id.txtPassword).text.toString()
        if (input_name.isEmpty() || input_password.isEmpty()) {
            Toast.makeText(this, "Empty Fields is not Allowed!",Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Welcome $input_name",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, TaskActivity::class.java))
        }
    }
}
