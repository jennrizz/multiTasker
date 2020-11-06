package com.example.multitasker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        supportActionBar?.setDisplayShowHomeEnabled(true);
        getSupportActionBar()?.setIcon(R.drawable.logo)
        setTitle("Task Activity")
        val camerabtn = findViewById<Button>(R.id.camerabtn)
        camerabtn.setOnClickListener { go_Camera() }
    }

    private fun go_Camera(){
        val uri = Uri.parse("content://camera")
        val inter = Intent(Intent.ACTION_CAMERA_BUTTON,uri)
        startActivity(inter)
    }
}