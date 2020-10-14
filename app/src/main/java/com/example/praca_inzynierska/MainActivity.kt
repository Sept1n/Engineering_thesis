package com.example.praca_inzynierska

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        new_user.setOnClickListener {
            var newActivity: Intent = Intent(applicationContext, Dodanie_uzytkownika::class.java)
            startActivity(newActivity)
        }
        aktualizuj.setOnClickListener(){
            var newActivity: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(newActivity)
            finish()
        }

        //Widok w formie listy
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)

        val dbHelper = DataBaseHelper(applicationContext)

        val db: SQLiteDatabase = dbHelper.writableDatabase

        recycler_view.adapter = UserViewAdapter(applicationContext, db)

    }

}
