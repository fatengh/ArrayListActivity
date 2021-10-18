package com.example.arraylistactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var edAdd: EditText
    private lateinit var edGet: EditText

    private lateinit var btnAdd: Button
    private lateinit var btnGet: Button

    private lateinit var tvGet: TextView

    var names = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edAdd = findViewById(R.id.edAdd)
        edGet = findViewById(R.id.edGet)

        btnAdd = findViewById(R.id.btnAdd)
        btnGet = findViewById(R.id.btnGet)

        tvGet = findViewById(R.id.tvGet)


        btnAdd.setOnClickListener {
            addNames()
        }
        btnGet.setOnClickListener {
            getNames()
        }

    }

    fun addNames() {
        if (edAdd.textSize != 0f) {
            names.add("${edAdd.text}")
            edAdd.text.clear()
        } else {
            Toast.makeText(applicationContext, "You should enter any name", Toast.LENGTH_LONG)
                .show()
        }
    }

    fun getNames() {
        var index = edGet.text.toString().toInt()
        if (index >= names.size) {
            Toast.makeText(applicationContext, "Index out of range", Toast.LENGTH_LONG).show()
        } else {
            tvGet.text = names[index]
            edGet.text.clear()
        }
    }

}