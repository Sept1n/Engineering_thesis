package com.example.praca_inzynierska

import android.app.Application
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.graphics.toColorInt
import kotlinx.android.synthetic.main.activity_dodanie_uzytkownika.*
import kotlin.coroutines.coroutineContext
import android.content.Context
import android.opengl.Visibility
import android.text.InputType
import java.security.MessageDigest

class static {
    companion object plec {
        var login: String = ""
        var wiek: Int = 0
        var wzrost: Int = 0
        var waga: Int = 0
        var plec: String = ""
        var aktywnosc: String = ""
        var uraz: String = ""
        var schorzenie: String = ""
        var BMI: Double = 0.0
        var l_zak_przed: Int = 0 //liczba ćwiczeń startowych na zakres dla przedramienia, aktualizowana w oparciu o ocenę użytkownika po każym dniu
        var l_zak_ram: Int = 0 //liczba ćwiczeń startowych na zakres dla ramienia, aktualizowana w oparciu o ocenę użytkownika po każym dniu
        var l_wzm_przed: Int = 0 //liczba ćwiczeń startowych na wzmocnienie dla przedramienia, aktualizowana w oparciu o ocenę użytkownika po każym dniu
        var l_wzm_ram: Int = 0 //liczba ćwiczeń startowych na wzmocnienie dla ramienia, aktualizowana w oparciu o ocenę użytkownika po każym dniu
        var liczba_serii: Int = 2 //minimalna liczba serii, aktualizowana w oparciu o ocenę użytkownika po każym dniu
        var liczba_powtorzen: Int = 8 //minimalna liczba powtórzeń, aktualizowane w oparciu o ocenę użytkownika po każym dniu
        var obciazenie: Double = 1.0 //obciążenie na start, aktualizowane w oparciu o ocenę użytkownika po każym dniu
        var dzien: Int = 1 //aktualny dzień rehabilitacji
        var szacowany_czas: Int = 21 //szacowany czas rehabilitacji, aktualizowany co trzy dni
        var suma_kg: Double = 0.0 //Zliczanie kilogramów
        var suma_cwiczen: Int = 0
        var suma_serii: Int =0
        var suma_powtorzen: Int = 0
    }
}

fun obslugaEditLogin (login: EditText, sprawdzenie_loginu: TextView)
{
    login.addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if(login.length() == 0) sprawdzenie_loginu.visibility = TextView.INVISIBLE
            static.login = login.text.toString()
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            if (login.length() < 4)
            {
                sprawdzenie_loginu.setText("Za krótka nazwa")
                sprawdzenie_loginu.visibility = TextView.VISIBLE
                sprawdzenie_loginu.setTextColor("#ff0000".toColorInt())
            }
            else
            {
                sprawdzenie_loginu.setText("Odpowiednia nazwa")
                sprawdzenie_loginu.visibility = TextView.VISIBLE
                sprawdzenie_loginu.setTextColor("#008000".toColorInt())
            }
        }
    })

}
fun obslugaEditWiek (wiek_uzytkownika: EditText, sprawdzenie_wieku: TextView)
{
    wiek_uzytkownika.addTextChangedListener(object: TextWatcher
    {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            if(wiek_uzytkownika.text.toString() == "")
            {
                sprawdzenie_wieku.visibility = TextView.INVISIBLE
                sprawdzenie_wieku.hint = "Wiek [lata]"
            }
            else
            {
                if (static.wiek < 18 || static.wiek > 80) {
                    static.wiek = wiek_uzytkownika.text.toString().toInt()
                    sprawdzenie_wieku.setText("Błędne dane")
                    sprawdzenie_wieku.visibility = TextView.VISIBLE
                    sprawdzenie_wieku.setTextColor("#ff0000".toColorInt())

                } else {
                    static.wiek = wiek_uzytkownika.text.toString().toInt()
                    sprawdzenie_wieku.setText("Poprawne dane")
                    sprawdzenie_wieku.visibility = TextView.VISIBLE
                    sprawdzenie_wieku.setTextColor("#008000".toColorInt())
                }
            }
        }
    })
}

fun obslugaEditWzrost (wzrost_uzytkownika: EditText, sprawdzenie_wzrostu: TextView)
{
    wzrost_uzytkownika.addTextChangedListener(object: TextWatcher
    {
        override fun afterTextChanged(s: Editable?) {
            //if(static.wzrost.toString().isNullOrEmpty()) sprawdzenie_wzrostu.visibility = TextView.INVISIBLE
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            if(wzrost_uzytkownika.text.toString() == "")
            {
                sprawdzenie_wzrostu.visibility = TextView.INVISIBLE
                sprawdzenie_wzrostu.hint = "Wzrost [cm]"
            }
            else {
                if (static.wzrost < 120 || static.wzrost > 250) {
                    static.wzrost = wzrost_uzytkownika.text.toString().toInt()
                    sprawdzenie_wzrostu.setText("Błędne dane")
                    sprawdzenie_wzrostu.visibility = TextView.VISIBLE
                    sprawdzenie_wzrostu.setTextColor("#ff0000".toColorInt())
                } else {
                    static.wzrost = wzrost_uzytkownika.text.toString().toInt()
                    sprawdzenie_wzrostu.setText("Poprawne dane")
                    sprawdzenie_wzrostu.visibility = TextView.VISIBLE
                    sprawdzenie_wzrostu.setTextColor("#008000".toColorInt())
                }
            }
        }
    })
}
fun obslugaEditWaga (waga_uzytkownika: EditText, sprawdzenie_waga: TextView)
{

    waga_uzytkownika.addTextChangedListener(object: TextWatcher
    {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            if(waga_uzytkownika.text.toString() == "")
            {
                sprawdzenie_waga.visibility = TextView.INVISIBLE
                sprawdzenie_waga.hint = "Waga [kg]"
            }
            else {
            if(static.waga < 40 || static.waga > 150)
            {
                static.waga = waga_uzytkownika.text.toString().toInt()
                sprawdzenie_waga.setText("Błędne dane")
                sprawdzenie_waga.visibility = TextView.VISIBLE
                sprawdzenie_waga.setTextColor("#ff0000".toColorInt())
            }
            else
            {
                static.waga = waga_uzytkownika.text.toString().toInt()
                sprawdzenie_waga.setText("Poprawne dane")
                sprawdzenie_waga.visibility = TextView.VISIBLE
                sprawdzenie_waga.setTextColor("#008000".toColorInt())
            }
        }}
    })
}

class RadioGroupPlec (var plec: String = "") {

fun obslugaRadioGroup_plec (opcja_mezczyzna: RadioButton, opcja_kobieta: RadioButton) {


    if(opcja_mezczyzna.isChecked) plec = "mężczyzna"
    if (opcja_kobieta.isChecked) plec = "kobieta"

    static.plec = plec
    }
}

class RadioGroupAktywnosc (var aktywnosc: String = "") {

    fun obslugaRadioGroup_aktywnosc (aktywnosc_brak: RadioButton, aktywnosc_niewielka: RadioButton, aktywnosc_umiarkowana: RadioButton, aktywnosc_wysoka: RadioButton, aktywnosc_bardzo_wysoka: RadioButton) {

        if(aktywnosc_brak.isChecked) aktywnosc = "brak"
        if (aktywnosc_niewielka.isChecked) aktywnosc = "niewielka"
        if(aktywnosc_umiarkowana.isChecked) aktywnosc = "umiarkowana"
        if (aktywnosc_wysoka.isChecked) aktywnosc = "wysoka"
        if(aktywnosc_bardzo_wysoka.isChecked) aktywnosc = "bardzo wysoka"

        static.aktywnosc = aktywnosc
    }
}

class RadioGroupUraz (var uraz: String = "") {

    fun obslugaRadioGroup_uraz (uraz_przedramie: RadioButton, uraz_ramie: RadioButton, uraz_calosc: RadioButton) {

        if(uraz_przedramie.isChecked) uraz = "przedramię"
        if (uraz_ramie.isChecked) uraz = "ramię"
        if(uraz_calosc.isChecked) uraz = "całość"

        static.uraz = uraz
    }
}

class RadioGroupSchorzenia (var schorzenia: String = "") {

    fun obslugaRadioGroup_schorzenia (opcja_tak: RadioButton, opcja_nie: RadioButton) {

        if(opcja_tak.isChecked) schorzenia = "tak"
        if (opcja_nie.isChecked) schorzenia = "nie"

        static.schorzenie = schorzenia
    }
}







