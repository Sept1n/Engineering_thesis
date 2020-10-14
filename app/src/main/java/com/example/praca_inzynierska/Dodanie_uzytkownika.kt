package com.example.praca_inzynierska

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dodanie_uzytkownika.*



class Dodanie_uzytkownika : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dodanie_uzytkownika)

        /*potwierdz.setOnClickListener {
            println(static.login)
            println(static.wiek)
            println(static.wzrost)
            println(static.waga)
            println(static.plec)
            println(static.aktywnosc)
            println(static.uraz)
            println(static.schorzenie)
            println(static.BMI)
        }*/
        anuluj.setOnClickListener{
            System.exit(-1)
        }
    }


    override fun onUserInteraction() {
        super.onUserInteraction()

        obslugaEditLogin(login, sprawdzenie_loginu)
        obslugaEditWiek(wiek_uzytkownika, sprawdzenie_wieku)
        obslugaEditWzrost(wzrost_uzytkownika, sprawdzenie_wzrost)
        obslugaEditWaga(waga_uzytkownika, sprawdzenie_wagi)
        RadioGroupPlec().obslugaRadioGroup_plec(opcja_mezczyzna, opcja_kobieta)
        RadioGroupAktywnosc().obslugaRadioGroup_aktywnosc(
            aktywnosc_brak,
            aktywnosc_niewielka,
            aktywnosc_umiarkowana,
            aktywnosc_wysoka,
            aktywnosc_bardzo_wysoka
        )
        RadioGroupUraz().obslugaRadioGroup_uraz(uraz_przedramie, uraz_ramie, uraz_calosc)
        RadioGroupSchorzenia().obslugaRadioGroup_schorzenia(opcja_tak, opcja_nie)

        potwierdz.setOnClickListener {
            if (static.login.length < 4)
            {
                Toast.makeText(applicationContext,"Brak lub błędnie wypełnione pole login", Toast.LENGTH_LONG).show()
            }
            if (static.wiek < 18 || static.wiek > 80 || static.wiek == 0)
            {
                Toast.makeText(applicationContext,"Brak lub błędnie wypełnione pole wiek", Toast.LENGTH_LONG).show()
            }
            if (static.wzrost < 120 || static.wzrost > 250 || static.wzrost == 0)
            {
                Toast.makeText(applicationContext,"Brak lub błędnie wypełnione pole wzrost", Toast.LENGTH_LONG).show()
            }
            if (static.waga < 40 || static.waga > 150 || static.waga == 0)
            {
                Toast.makeText(applicationContext,"Brak lub błędnie wypełnione pole waga", Toast.LENGTH_LONG).show()
            }
            if (static.plec == "")
            {
                Toast.makeText(applicationContext,"Brak zaznaczonego pola płeć", Toast.LENGTH_LONG).show()
            }
            if (static.aktywnosc == "")
            {
                Toast.makeText(applicationContext,"Brak zaznaczonego pola aktywność", Toast.LENGTH_LONG).show()
            }
            if (static.uraz == "")
            {
                Toast.makeText(applicationContext,"Brak zaznaczonego pola uraz", Toast.LENGTH_LONG).show()
            }
            if (static.schorzenie == "")
            {
                Toast.makeText(applicationContext,"Brak zaznaczonego pola schorzenie", Toast.LENGTH_LONG).show()
            }
            else
            {
                ObliczanieBMI()
                Initial_values()

                val dbHelper = DataBaseHelper(applicationContext)

                val db: SQLiteDatabase = dbHelper.writableDatabase

                val save_info = Toast.makeText(applicationContext, "Zapisano nowego Użytkownika", Toast.LENGTH_SHORT).show()

                val values = ContentValues()
                values.put(Podstawowe_Dane.Table_Column_Login,static.login)
                values.put(Podstawowe_Dane.Table_Column_Wiek, static.wiek)
                values.put(Podstawowe_Dane.Table_Column_Wzrost, static.wzrost)
                values.put(Podstawowe_Dane.Table_Column_Waga, static.waga)
                values.put(Podstawowe_Dane.Table_Column_Plec, static.plec)
                values.put(Podstawowe_Dane.Table_Column_Aktywnosc, static.aktywnosc)
                values.put(Podstawowe_Dane.Table_Column_Uraz, static.uraz)
                values.put(Podstawowe_Dane.Table_Column_Schorzenia, static.schorzenie)
                values.put(Podstawowe_Dane.Table_Column_BMI, static.BMI)
                values.put(Podstawowe_Dane.Table_Column_l_zak_przed, static.l_zak_przed)
                values.put(Podstawowe_Dane.Table_Column_l_zak_ram, static.l_zak_ram)
                values.put(Podstawowe_Dane.Table_Column_l_wzm_przed, static.l_wzm_przed)
                values.put(Podstawowe_Dane.Table_Column_l_wzm_ram, static.l_wzm_ram)
                values.put(Podstawowe_Dane.Table_Column_liczba_serii, static.liczba_serii)
                values.put(Podstawowe_Dane.Table_Column_liczba_powtorzen, static.liczba_powtorzen)
                values.put(Podstawowe_Dane.Table_Column_kg, static.obciazenie)
                values.put(Podstawowe_Dane.Table_Column_dzien, static.dzien)
                values.put(Podstawowe_Dane.Table_Column_szacowany_czas, static.szacowany_czas)
                values.put(Podstawowe_Dane.Table_Column_suma_kg, static.suma_kg)
                values.put(Podstawowe_Dane.Table_Column_suma_cwiczen, static.suma_cwiczen)
                values.put(Podstawowe_Dane.Table_Column_suma_serii, static.suma_serii)
                values.put(Podstawowe_Dane.Table_Column_suma_powtorzen, static.suma_powtorzen)

                db.insertOrThrow(Podstawowe_Dane.Table_Name, null, values)

                save_info

                println(static.login)
                println(static.wiek)
                println(static.wzrost)
                println(static.waga)
                println(static.plec)
                println(static.aktywnosc)
                println(static.uraz)
                println(static.schorzenie)
                println(static.BMI)
                println(static.liczba_serii)
                println(static.liczba_powtorzen)
                println(static.l_zak_przed)
                println(static.l_zak_ram)
                println(static.l_wzm_przed)
                println(static.l_wzm_ram)
                println(static.obciazenie)
                println(static.dzien)
                println(static.szacowany_czas)

                var newActivity: Intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(newActivity)
            }
        }
    }

}




