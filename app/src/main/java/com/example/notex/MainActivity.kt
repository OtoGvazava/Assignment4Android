package com.example.notex

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.addNoteButton).setOnClickListener {
            val noteAddActivity = Intent(this, NoteAddActivity::class.java)
            startActivity(noteAddActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences = this.getSharedPreferences("NOTES", MODE_PRIVATE)
        val notes = sharedPreferences.getStringSet("notes", null)
        if (notes != null && notes.size > 0) {
            findViewById<TextView>(R.id.textView2).text = notes.first().toString()
        } else {
            findViewById<TextView>(R.id.textView2).text = "no data"
        }
    }
}