package com.example.sql

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
import android.widget.Toast


val DATABASE_NAME = "MyDB"
val TABLE_NAME = "Users"
val COL_NAME = "name"
val COL_ID = "id"
val COL_AGE = "age"


class DataBaseHandler (context:Context): SQLiteOpenHelper (context, DATABASE_NAME,null,1){
    override fun onCreate(p0: SQLiteDatabase?) {
        val createTable ="CRATE TABLE "+ TABLE_NAME+"("+ COL_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_NAME + "VARCHAR(35)," + COL_AGE+"INTEGER)";
        p0?.execSQL(createTable)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
    fun insertData(user : User){
        val p0 = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME,user.name)
        cv.put(COL_AGE,user.age)
        var result = p0.insert(TABLE_NAME,null,cv)
        if(result == -1.toLong()){
           Toast.makeText(MainActivity(),"field",Toast.LENGTH_LONG).show()

        }
        else{
            Toast.makeText(MainActivity(),"Success",Toast.LENGTH_LONG).show()
        }

    }
}