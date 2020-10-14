package com.example.praca_inzynierska

import android.app.DownloadManager.COLUMN_ID
import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.praca_inzynierska.Podsumowanie.aktualizacja.dane_aktualizacja.suma_cwiczen_dzien
import com.example.praca_inzynierska.Podsumowanie.aktualizacja.dane_aktualizacja.suma_kg_dzien
import com.example.praca_inzynierska.Podsumowanie.aktualizacja.dane_aktualizacja.suma_powtorzen_dzien
import com.example.praca_inzynierska.Podsumowanie.aktualizacja.dane_aktualizacja.suma_serii_dzien
import kotlinx.android.synthetic.main.activity_ekran_glowny.*
import kotlinx.android.synthetic.main.activity_podsumowanie.*

class Podsumowanie : AppCompatActivity() {


    class aktualizacja {
        companion object dane_aktualizacja {
            /*var ID: Int = 0
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
            var suma_kg: Double = 0.0*/
            var suma_kg_dzien: Double = 0.0
            var suma_cwiczen_dzien: Int = 0
            var suma_serii_dzien: Int = 0
            var suma_powtorzen_dzien: Int = 0
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_podsumowanie)

        ekran_glowny.dane.dzien++

        var liczba_cw: Int = ekran_glowny.dane.l_zak_przed + ekran_glowny.dane.l_zak_ram + ekran_glowny.dane.l_wzm_przed + ekran_glowny.dane.l_wzm_ram
        var liczba_ser: Int = liczba_cw * ekran_glowny.dane.l_serii
        var liczba_pow: Int = liczba_ser * ekran_glowny.dane.l_powtorzen
        var trud: Int = 0
        var bol: Int = 0

        ilosc_cw_wykonanych.setText("Wykonałeś/aś w sumie " + liczba_cw + " ćwiczeń")
        ilosc_ser_wykonanych.setText("Wykonałeś/aś w sumie " + liczba_ser + " serii ćwiczeń")
        ilosc_pow_wykonanych.setText("Wykonałeś/aś w sumie " + liczba_pow + " powtórzeń")
        pod_ciez.setText("Podniosłeś/aś w sumie " + suma_kg_dzien + " kilogramów")

        if (ekran_glowny.dane.dzien >= ekran_glowny.dane.szacowany_czas)
        {
            pytania.text = getString(R.string.gratulacje)
            pyt_trud.visibility = TextView.INVISIBLE
            trud_edittext.visibility = TextView.INVISIBLE
            pyt_bol.visibility = TextView.INVISIBLE
            bol_edittext.visibility = TextView.INVISIBLE
        }

        do_ekran_glowny.setOnClickListener(){

            suma_powtorzen_dzien = (suma_kg_dzien / ekran_glowny.dane.obciazenie).toInt()
            ekran_glowny.dane.suma_powtorzen =
                ekran_glowny.dane.suma_powtorzen + suma_powtorzen_dzien

            if (trud_edittext.text.toString() == "" || trud_edittext.text.toString().toInt() < 0 || trud_edittext.text.toString().toInt() > 10)
            {
                Toast.makeText(applicationContext, "Niepoprawna wartość w polu z trudnością", Toast.LENGTH_LONG).show()
            }
            if (bol_edittext.text.toString() == "" || bol_edittext.text.toString().toInt() < 0 || bol_edittext.text.toString().toInt() > 10)
            {
                Toast.makeText(applicationContext, "Niepoprawna wartość w polu z bólem", Toast.LENGTH_LONG).show()
            }
            else
            {
                if (trud_edittext.text.toString() == "" || bol_edittext.text.toString() == "")
            {

            }
            else {
                    trud = trud_edittext.text.toString().toInt()
                    bol = bol_edittext.text.toString().toInt()

                    println(trud)
                    println(bol)

                    when (trud) {
                        in 0..4 -> ekran_glowny.dane.l_powtorzen = ekran_glowny.dane.l_powtorzen + 1
                        in 5..6 -> ekran_glowny.dane.l_powtorzen
                        in 7..10 -> ekran_glowny.dane.l_powtorzen = ekran_glowny.dane.l_powtorzen - 1
                    }
                    when (bol) {
                        in 0..4 -> ekran_glowny.dane.l_powtorzen = ekran_glowny.dane.l_powtorzen + 1
                        in 5..6 -> ekran_glowny.dane.l_powtorzen
                        in 7..10 -> ekran_glowny.dane.l_powtorzen = ekran_glowny.dane.l_powtorzen - 1
                    }

                    if (trud <= 4 && bol <= 4) {
                        ekran_glowny.dane.szacowany_czas = ekran_glowny.dane.szacowany_czas - 1
                    }
                    if (trud >= 7 && bol >= 7) {
                        ekran_glowny.dane.szacowany_czas = ekran_glowny.dane.szacowany_czas + 1
                    }

                    if (ekran_glowny.dane.l_powtorzen > 16) {
                        ekran_glowny.dane.l_serii = ekran_glowny.dane.l_serii + 1
                        ekran_glowny.dane.l_powtorzen = ekran_glowny.dane.l_powtorzen - 8
                    }
                    if (ekran_glowny.dane.l_powtorzen < 8) {
                        ekran_glowny.dane.l_serii = ekran_glowny.dane.l_serii - 1
                        ekran_glowny.dane.l_powtorzen = ekran_glowny.dane.l_powtorzen + 4
                    }

                    if (trud <= 2 && bol <= 2) {
                        ekran_glowny.dane.obciazenie = ekran_glowny.dane.obciazenie + 0.5
                        if (ekran_glowny.dane.obciazenie > 2) ekran_glowny.dane.obciazenie = 2.0
                    }
                    if (trud >= 8 && bol >= 8) {
                        ekran_glowny.dane.obciazenie = ekran_glowny.dane.obciazenie - 0.5
                        if (ekran_glowny.dane.obciazenie < 0.5) ekran_glowny.dane.obciazenie = 0.5
                    }

                    ekran_glowny.dane.suma_kg = ekran_glowny.dane.suma_kg + suma_kg_dzien

                    suma_cwiczen_dzien =
                        ekran_glowny.dane.l_zak_przed + ekran_glowny.dane.l_zak_ram + ekran_glowny.dane.l_wzm_przed + ekran_glowny.dane.l_wzm_ram
                    ekran_glowny.dane.suma_cwiczen =
                        ekran_glowny.dane.suma_cwiczen + suma_cwiczen_dzien

                    suma_serii_dzien = suma_cwiczen_dzien * ekran_glowny.dane.l_serii
                    ekran_glowny.dane.suma_serii = ekran_glowny.dane.suma_serii + suma_serii_dzien



                    val dbHelper = DataBaseHelper(applicationContext)

                    val db: SQLiteDatabase = dbHelper.writableDatabase

                    val save_info = Toast.makeText(
                        applicationContext,
                        "Dane zostały zaktualizowane",
                        Toast.LENGTH_SHORT
                    ).show()

                    val values = ContentValues()

                    values.put(Podstawowe_Dane.Table_Column_Login, ekran_glowny.dane.login)
                    values.put(Podstawowe_Dane.Table_Column_Wiek, ekran_glowny.dane.wiek)
                    values.put(Podstawowe_Dane.Table_Column_Wzrost, ekran_glowny.dane.wzrost)
                    values.put(Podstawowe_Dane.Table_Column_Waga, ekran_glowny.dane.waga)
                    values.put(Podstawowe_Dane.Table_Column_Plec, ekran_glowny.dane.plec)
                    values.put(Podstawowe_Dane.Table_Column_Aktywnosc, ekran_glowny.dane.aktywnosc)
                    values.put(Podstawowe_Dane.Table_Column_Uraz, ekran_glowny.dane.uraz)
                    values.put(
                        Podstawowe_Dane.Table_Column_Schorzenia,
                        ekran_glowny.dane.schorzenie
                    )
                    values.put(Podstawowe_Dane.Table_Column_BMI, ekran_glowny.dane.BMI)
                    values.put(
                        Podstawowe_Dane.Table_Column_l_zak_przed,
                        ekran_glowny.dane.l_zak_przed
                    )
                    values.put(Podstawowe_Dane.Table_Column_l_zak_ram, ekran_glowny.dane.l_zak_ram)
                    values.put(
                        Podstawowe_Dane.Table_Column_l_wzm_przed,
                        ekran_glowny.dane.l_wzm_przed
                    )
                    values.put(Podstawowe_Dane.Table_Column_l_wzm_ram, ekran_glowny.dane.l_wzm_ram)
                    values.put(Podstawowe_Dane.Table_Column_liczba_serii, ekran_glowny.dane.l_serii)
                    values.put(
                        Podstawowe_Dane.Table_Column_liczba_powtorzen,
                        ekran_glowny.dane.l_powtorzen
                    )
                    values.put(Podstawowe_Dane.Table_Column_kg, ekran_glowny.dane.obciazenie)
                    values.put(Podstawowe_Dane.Table_Column_dzien, ekran_glowny.dane.dzien)
                    values.put(
                        Podstawowe_Dane.Table_Column_szacowany_czas,
                        ekran_glowny.dane.szacowany_czas
                    )
                    values.put(Podstawowe_Dane.Table_Column_suma_kg, ekran_glowny.dane.suma_kg)
                    values.put(
                        Podstawowe_Dane.Table_Column_suma_cwiczen,
                        ekran_glowny.dane.suma_cwiczen
                    )
                    values.put(
                        Podstawowe_Dane.Table_Column_suma_serii,
                        ekran_glowny.dane.suma_serii
                    )
                    values.put(
                        Podstawowe_Dane.Table_Column_suma_powtorzen,
                        ekran_glowny.dane.suma_powtorzen
                    )

                    db.update(
                        Podstawowe_Dane.Table_Name,
                        values,
                        "$COLUMN_ID = " + ekran_glowny.dane.ID,
                        null
                    )
                    db.close()
                    println(ekran_glowny.dane.suma_kg)
                    println(ekran_glowny.dane.dzien)
                    save_info

                    var newActivity: Intent = Intent(applicationContext, ekran_glowny::class.java)
                    startActivity(newActivity)
                    println(ekran_glowny.dane.l_powtorzen)
                    println(ekran_glowny.dane.obciazenie)
                    println(ekran_glowny.dane.szacowany_czas)

                }
            }
        }
    }
}
