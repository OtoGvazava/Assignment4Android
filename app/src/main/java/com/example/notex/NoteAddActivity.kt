package com.example.notex

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NoteAddActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "MutatingSharedPrefs")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_add)

        findViewById<Button>(R.id.noteAddSubmitButton).setOnClickListener {
            val sharedPreferences = getSharedPreferences("NOTES", MODE_PRIVATE)
            var notes = sharedPreferences.getStringSet("notes", setOf<String>())
            notes?.add(findViewById<EditText>(R.id.noteMultiLineText).text.toString())
            sharedPreferences.edit().putStringSet("notes", notes).apply()
            val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
        }
    }
}