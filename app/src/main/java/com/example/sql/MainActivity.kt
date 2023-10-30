package com.example.sql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var btn_insert : Button
        lateinit var etvName : EditText
        lateinit var etvAge : EditText
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_insert = findViewById(R.id.btn_insert)
        etvName  = findViewById(R.id.etvName)
        etvAge = findViewById(R.id.etvAge)
        btn_insert.setOnClickListener {
            if(etvName.text.toString().length>0 && etvAge.text.toString().length>0){
                var user = User(etvName.text.toString(),etvAge.text.toString().toInt());
                var db = DataBaseHandler(context = this)
                db.insertData(user)

            }
            else{
                Toast.makeText(this,"enter data",Toast.LENGTH_SHORT).show()
            }
        }

    }
}