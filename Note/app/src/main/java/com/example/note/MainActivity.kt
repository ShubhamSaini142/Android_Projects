package com.example.note

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.content.DialogInterface
import android.widget.AdapterView.OnItemLongClickListener
import android.content.SharedPreferences





class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
   companion object {
       var arrayAdapter: ArrayAdapter<String>? = null
       var notes =  ArrayList<String>()
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences =
            applicationContext.getSharedPreferences("com.example.note", MODE_PRIVATE)
        val set = sharedPreferences.getStringSet("notes", null) as HashSet<String>?

        if (set == null) {
            notes.add("Example Note")
        } else {
            notes =
                ArrayList(set) // to bring all the already stored data in the set to the notes ArrayList
        }

        listView = findViewById(R.id.listview)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notes)
        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { parent, view, position, id ->
            var intent : Intent = Intent(this,NoteEditorActivity::class.java)
            intent.putExtra("noteId",position)
            startActivity(intent)

            listView.onItemLongClickListener =
                OnItemLongClickListener { parent, view, position, id ->
                    AlertDialog.Builder(this@MainActivity)
                        .setIcon(android.R.drawable.alert_light_frame)
                        .setTitle("Delete?")
                        .setMessage("Are you sure you want to delete this note?")
                        .setPositiveButton("Yes",
                            DialogInterface.OnClickListener { dialog, which ->
                                notes.removeAt(position)
                                arrayAdapter!!.notifyDataSetChanged()
                            })
                        .setNegativeButton("No", null)
                        .show()
                    true
                }


        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater : MenuInflater = menuInflater
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if (item.itemId == R.id.add_note){
            var intent : Intent = Intent(this,NoteEditorActivity::class.java)
            startActivity(intent)
            return true
        }
        return false
    }

}