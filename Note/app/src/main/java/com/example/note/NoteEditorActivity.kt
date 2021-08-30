package com.example.note

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import android.text.Editable

import android.text.TextWatcher
import android.content.SharedPreferences







class NoteEditorActivity : AppCompatActivity() {
    lateinit var editText: EditText
    var noteId : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_editor)
        editText = findViewById(R.id.edtText)
        intent.getIntExtra("noteId", -1)
        if (noteId!=-1){
            editText.setText(MainActivity.notes[noteId])
        }
        else
        {
            MainActivity.notes.add("");                // as initially, the note is empty
            noteId = MainActivity.notes.size - 1;
          //  MainActivity.arrayAdapter.notifyDataSetChanged()
        }
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                MainActivity.notes[noteId] = s.toString()
                MainActivity.arrayAdapter?.notifyDataSetChanged()


                val sharedPreferences = applicationContext.getSharedPreferences(
                    "com.example.note",
                    Context.MODE_PRIVATE
                )
                val set = HashSet(MainActivity.notes)
                sharedPreferences.edit().putStringSet("notes", set).apply()
            }

            override fun afterTextChanged(s: Editable) {}
        })

    }
}

