package com.example.praca_inzynierska

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ekran_glowny.*
import java.lang.reflect.Array
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import kotlin.time.hours


class ekran_glowny : AppCompatActivity() {


    class dane {
        companion object dane_do_cwiczen {
            var ID: Int = 0
            var login: String = ""
            var wiek: Int = 0
            var wzrost: Int = 0
            var waga: Int = 0
            var plec: String = ""
            var aktywnosc: String = ""
            var uraz: String = ""
            var schorzenie: String = ""
            var BMI: Double = 0.0
            var l_zak_przed: Int = 0
            var l_zak_ram: Int = 0
            var l_wzm_przed: Int = 0
            var l_wzm_ram: Int = 0
            var l_serii: Int = 0
            var l_powtorzen: Int = 0
            var obciazenie: Double = 0.0
            var dzien: Int = 0
            var szacowany_czas: Int = 0
            var suma_kg: Double = 0.0
            var suma_cwiczen: Int = 0
            var suma_serii: Int = 0
            var suma_powtorzen: Int = 0

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ekran_glowny)

        if (dane.dzien > dane.szacowany_czas)
        {
            Przycisk_cwiczenia.visibility = View.INVISIBLE
            Przycisk_cwiczenia.isClickable = false
        }


        Przycisk_zmiana_uzytkownika.setOnClickListener {

            var newActivity: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(newActivity)

        }
        Przycisk_o_aplikacji.setOnClickListener{
            var newActivity: Intent = Intent(applicationContext, O_aplikacji::class.java)
            startActivity(newActivity)
            println(dane.ID)
        }

        Przycisk_postepy.setOnClickListener{
            var newActivity: Intent = Intent(applicationContext, Postepy::class.java)
            startActivity(newActivity)
            println(dane.dzien)
            println(dane.szacowany_czas)
            println(dane.suma_kg)
            println(dane.suma_cwiczen)
            println(dane.suma_serii)
            println(dane.suma_powtorzen)
        }

        Przycisk_cwiczenia.setOnClickListener {

                var newActivity: Intent = Intent(applicationContext, Cwiczenia::class.java)
                startActivity(newActivity)

            /*println(dane.ID)
            println(dane.login)
            println(dane.wiek)
            println(dane.wzrost)
            println(dane.waga)
            println(dane.plec)
            println(dane.aktywnosc)
            println(dane.uraz)
            println(dane.schorzenie)
            println(dane.BMI)
            println(dane.l_zak_przed)
            println(dane.l_zak_ram)
            println(dane.l_wzm_przed)
            println(dane.l_wzm_ram)
            println(dane.l_serii)
            println(dane.l_powtorzen)
            println(dane.obciazenie)
            */println(dane.dzien)
            println(dane.szacowany_czas)
        }



        if(intent.hasExtra("ID"))
        {
            dane.ID = intent.getIntExtra("ID", -1)
            dane.login = intent.getStringExtra("Login")
            dane.wiek = intent.getIntExtra("Wiek", -1)
            dane.wzrost = intent.getIntExtra("Wzrost", -1)
            dane.waga = intent.getIntExtra("Waga", -1)
            dane.plec = intent.getStringExtra("Plec")
            dane.aktywnosc = intent.getStringExtra("Aktywnosc")
            dane.uraz = intent.getStringExtra("Uraz")
            dane.schorzenie = intent.getStringExtra("Schorzenie")
            dane.BMI = intent.getDoubleExtra("BMI", -1.0)
            dane.l_zak_przed = intent.getIntExtra("L_zak_przed", -1)
            dane.l_zak_ram = intent.getIntExtra("L_zak_ram", -1)
            dane.l_wzm_przed = intent.getIntExtra("L_wzm_przed", -1)
            dane.l_wzm_ram = intent.getIntExtra("L_wzm_ram", -1)
            dane.l_serii = intent.getIntExtra("L_serii", -1)
            dane.l_powtorzen = intent.getIntExtra("L_powtorzen", -1)
            dane.obciazenie = intent.getDoubleExtra("Obciazenie", -1.0)
            dane.dzien = intent.getIntExtra("Dzien", -1)
            dane.szacowany_czas = intent.getIntExtra("Szacowany_czas", -1)
            dane.suma_kg = intent.getDoubleExtra("Suma_kg",-1.0)
            dane.suma_cwiczen = intent.getIntExtra("Suma_cwiczen", -1)
            dane.suma_serii = intent.getIntExtra("Suma_serii", -1)
            dane.suma_powtorzen = intent.getIntExtra("Suma_powtorzen", -1)
        }
        else
        {
            println("Nie istnieje taki użytkownik!")
        }
        println(dane.login)
        zalogowany_jako.setText("Zalogowany jako: " + dane.login)
        dzien_rehabilitacji.setText("" + dane.dzien + " dzień ćwiczeń")
        }

}
