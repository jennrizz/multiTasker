package com.example.multitasker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        supportActionBar?.setDisplayShowHomeEnabled(true);
        getSupportActionBar()?.setIcon(R.drawable.logo)
        setTitle("Task Activity")
        val camerabtn = findViewById<Button>(R.id.camerabtn)
        val btngit = findViewById<Button>(R.id.gitbtn)
        val btncalendar = findViewById<Button>(R.id.calendarbtn)
        val btnnav = findViewById<Button>(R.id.navbtn)
        val btnApp = findViewById<Button>(R.id.viewappbtn)
        btngit.setOnClickListener { visit_gitpage() }
        camerabtn.setOnClickListener { open_Camera() }
        btncalendar.setOnClickListener { view_Calendar_reminder() }
        btnnav.setOnClickListener { gMaps_nav() }
        btnApp.setOnClickListener { viewApp() }
    }

    private fun open_Camera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(intent)
    }
    private fun view_Calendar_reminder(){
        val insertReminder = Intent(Intent.ACTION_INSERT)
            .setData(CalendarContract.Events.CONTENT_URI)
            .putExtra(CalendarContract.Events.TITLE, "SUBMISSION CC17 ACTIVITY")
            .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false)
            .putExtra(CalendarContract.Events.EVENT_LOCATION, "Baguio")
            .putExtra(Intent.EXTRA_EMAIL, "rizz@gmail.com")
            .putExtra(CalendarContract.Events.DESCRIPTION, "CC17 Activity")
            .putExtra(CalendarContract.Events.ACCESS_LEVEL, CalendarContract.Events.ACCESS_PRIVATE)
            .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_FREE)
        startActivity(insertReminder)
    }
    private fun visit_gitpage(){
        val uri = Uri.parse("https://github.com/jennrizz/multiTasker")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    private fun gMaps_nav(){
        val user_input = findViewById<EditText>(R.id.txtinput).text.toString()
        val mapIntent: Uri? = Uri.parse("$user_input")
        try{
            val intent = Intent(Intent.ACTION_VIEW, mapIntent)
            startActivity(intent)
        }
        catch (e: Exception){
            Toast.makeText(this, "Error $user_input is invalid! Enter a valid URL/URI", Toast.LENGTH_LONG).show()
            Toast.makeText (this, "Error found:  $e", Toast.LENGTH_SHORT).show()
        }
    }

    private fun viewApp(){
        val appUri = findViewById<EditText>(R.id.txtinput).text.toString()
        val externalAppIntent = Uri.parse("$appUri")
        try{
            val intent = Intent(Intent.ACTION_VIEW, externalAppIntent)
            startActivity(intent)
        }
        catch (e: java.lang.Exception){
            Toast.makeText(this, "Error $appUri is invalid! Enter a valid URL/URI", Toast.LENGTH_LONG).show()
            Toast.makeText (this, "Error found:  $e", Toast.LENGTH_SHORT).show()
        }
    }


}