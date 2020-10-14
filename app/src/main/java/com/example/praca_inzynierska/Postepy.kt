package com.example.praca_inzynierska

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_postepy.*

class Postepy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postepy)

        pod_log.setText("Zalogowany jako: " + ekran_glowny.dane.login)

        pod_wiek.setText("Wiek: " + ekran_glowny.dane.wiek + " lata")

        pod_wzrost.setText("Wzrost: " + ekran_glowny.dane.wzrost + " cm")

        pod_waga.setText("Waga: " + ekran_glowny.dane.waga + " kg")

        pod_plec.setText("Płeć: " +ekran_glowny.dane.plec)

        when (ekran_glowny.dane.aktywnosc)
        {
            "brak" -> pod_aktywnosc.setText("Aktywność fizyczna uprawiana 0 razy w tygodniu")
            "niewielka" -> pod_aktywnosc.setText("Aktywność fizyczna uprawiana 1-2 razy w tygodniu")
            "umiarkowana" -> pod_aktywnosc.setText("Aktywność fizyczna uprawiana 3-4 razy w tygodniu")
            "wysoka" -> pod_aktywnosc.setText("Aktywność fizyczna uprawiana 4-5 razy w tygodniu")
            "bardzo wysoka" -> pod_aktywnosc.setText("Aktywność fizyczna uprawiana więcej niż 5 razy w tygodniu")
        }

        pod_uraz.setText("Uraz: " + ekran_glowny.dane.uraz)

        pod_BMI.setText("BMI: " +ekran_glowny.dane.BMI.toInt())

        pod_cw.setText("W sumie wykonano " +ekran_glowny.dane.suma_cwiczen + " ćwiczeń")

        pod_serie.setText("W sumie wykonano " + ekran_glowny.dane.suma_serii + " serii ćwiczeń")

        pod_powtorzenia.setText("W sumie wykonano "+ ekran_glowny.dane.suma_powtorzen + " powtórzeń ćwiczeń")

        pod_obciazenie.setText("Aktualne obciążenie wynosi " + ekran_glowny.dane.obciazenie + " kg")

        pod_szac_czas.setText("Do końca rehabilitacji zostało " + (ekran_glowny.dane.szacowany_czas - ekran_glowny.dane.dzien) + " dni")

        pod_pod_kg.setText("W sumie podniesiono " +ekran_glowny.dane.suma_kg.toInt() + " kg")
    }
}
