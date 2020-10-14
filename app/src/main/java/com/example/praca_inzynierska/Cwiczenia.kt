package com.example.praca_inzynierska

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import kotlinx.android.synthetic.main.activity_cwiczenia.*
import kotlin.random.Random
import android.view.View as View1

var liczba_pod_cie_suma: Double = 0.0                               //sumaryczna liczba cwiczeń w ciągu dnia
var liczba_serii = ekran_glowny.dane.l_serii                        //liczba serii w danym ćwiczeniu
var licznik_cwiczen: Int = 1                                        //ilość wykonanych ćwiczeń
var licznik_serii: Int = 1                                          //ilość wykonanych serii w ćwiczeniu
var los_pier_cw: Int = 0                                            //losowanie pierwszego ćwiczenia
var los_drug_cw: Int = 0                                            //losowanie drugiego ćwiczenia
var l_cw_zak_przed: Int = 4                                         //liczba potencjalnych ćwiczeń na zakres przedramię
var l_cw_zak_ram: Int = 4                                           //liczba potencjalnych ćwiczeń na zakres ramię
var l_cw_wzm_przed: Int = 3                                         //liczba potencjalnych ćwiczeń na wzmocnienie przedramię
var l_cw_wzm_ram: Int = 6                                           //liczba potencjalnych ćwiczeń na wzmocnienie ramię

class Cwiczenia : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cwiczenia)

        val linearLayout = findViewById(R.id.linear_Layout) as LinearLayout
        val imageView = ImageView(this)
        var mainScrollView: ScrollView = findViewById(R.id.scroll_view)
        var sprawdzanie_wartosci: Boolean = true

        cwiczenie_nazwa.setText("")
        cwiczenie_licznik.setText("")
        opis_cwiczenia.setText("")
        serie_obciazenie.setText("")
        przejdz_dalej.setText("Rozpocznij")
        ilosc_powtorzen.setText("")
        wpisana_wartosc.visibility = TextView.INVISIBLE

        fun Context.hideKeyboard(view: View1) {
            val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

                przejdz_dalej.setOnClickListener() {

                    println("Cwiczenie: " + licznik_cwiczen)
                    println("Seria: " + licznik_serii)
                    println("Suma podniesiona kg: " + liczba_pod_cie_suma)

                    if(licznik_cwiczen == 1 || licznik_cwiczen == 2 || licznik_cwiczen == 3 || licznik_cwiczen == 4 || (licznik_cwiczen == 5 && licznik_serii == 1))
                    {
                        cwiczenie_licznik.setText("Ćwiczenie: " + licznik_cwiczen + "   Seria: " + licznik_serii)
                    }

                    linearLayout.removeView(imageView)
                    if (licznik_cwiczen == 0 && licznik_serii == 0) {
                        val intent: Intent = Intent(applicationContext, ekran_glowny::class.java)
                        applicationContext.startActivity(intent)
                    }
                    if (licznik_cwiczen == 1 && licznik_serii <= liczba_serii && licznik_serii != 0) {
                        if (los_pier_cw == 0) {
                            los_pier_cw = Random.nextInt(1, l_cw_zak_przed)
                        } else {

                        }
                        //cwiczenie_licznik.setText("Ćwiczenie: " + licznik_cwiczen + "   Seria: " + licznik_serii)
                        przejdz_dalej.setText("Następna seria")
                        serie_obciazenie.visibility = TextView.INVISIBLE
                        ilosc_powtorzen.visibility = TextView.INVISIBLE
                        wpisana_wartosc.visibility = TextView.INVISIBLE

                        if (los_pier_cw == 1) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_przed_1)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_przed_1)
                            imageView.setImageResource(R.drawable.zak_przed_dol_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_przed_dol_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_dol_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_dol_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_pier_cw == 2) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_przed_2)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_przed_2)
                            imageView.setImageResource(R.drawable.zak_przed_gora_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_przed_gora_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_gora_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_gora_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }

                        if (los_pier_cw == 3) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_przed_3)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_przed_3)
                            imageView.setImageResource(R.drawable.zak_przed_ten_po)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_przed_ten_po).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_ten_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_ten_po)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_pier_cw == 4) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_przed_4)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_przed_4)
                            imageView.setImageResource(R.drawable.zak_przed_golf_po)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_przed_golf_po).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_golf_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_golf_po)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        mainScrollView.fullScroll((ScrollView.FOCUS_UP))
                        if (liczba_serii == licznik_serii) {
                            przejdz_dalej.setText("Następne ćwiczenie")
                        }
                    }

                    if (licznik_cwiczen == 2 && licznik_serii <= liczba_serii && licznik_serii != 0 && ekran_glowny.dane.l_zak_przed == 2) {
                        if (los_drug_cw == 0) {
                            while (los_drug_cw == los_pier_cw || los_drug_cw == 0) {
                                los_drug_cw = Random.nextInt(1, l_cw_zak_przed)
                            }
                        } else {

                        }
                        //cwiczenie_licznik.setText("Ćwiczenie: " + licznik_cwiczen + "   Seria: " + licznik_serii)
                        przejdz_dalej.setText("Następna seria")
                        serie_obciazenie.visibility = TextView.INVISIBLE
                        ilosc_powtorzen.visibility = TextView.INVISIBLE
                        wpisana_wartosc.visibility = TextView.INVISIBLE

                        if (los_drug_cw == 1) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_przed_1)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_przed_1)
                            imageView.setImageResource(R.drawable.zak_przed_dol_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_przed_dol_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_dol_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_dol_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_drug_cw == 2) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_przed_2)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_przed_2)
                            imageView.setImageResource(R.drawable.zak_przed_gora_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_przed_gora_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_gora_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_gora_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }

                        if (los_drug_cw == 3) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_przed_3)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_przed_3)
                            imageView.setImageResource(R.drawable.zak_przed_ten_po)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_przed_ten_po).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_ten_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_ten_po)
                                    linearLayout.addView(imageView)
                                }
                            }

                        }
                        if (los_drug_cw == 4) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_przed_4)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_przed_4)
                            imageView.setImageResource(R.drawable.zak_przed_golf_po)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_przed_golf_po).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_golf_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_przed_golf_po)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        mainScrollView.fullScroll((ScrollView.FOCUS_UP))
                        if (liczba_serii == licznik_serii) {
                            przejdz_dalej.setText("Następne ćwiczenie")
                        }
                    }

                    if (licznik_cwiczen == 3 && licznik_serii <= liczba_serii && licznik_serii != 0) {
                        if (los_pier_cw == 0) {
                            los_pier_cw = Random.nextInt(1, l_cw_zak_ram)
                        } else {

                        }
                        //cwiczenie_licznik.setText("Ćwiczenie: " + licznik_cwiczen + "   Seria: " + licznik_serii)
                        przejdz_dalej.setText("Następna seria")
                        serie_obciazenie.visibility = TextView.INVISIBLE
                        ilosc_powtorzen.visibility = TextView.INVISIBLE
                        wpisana_wartosc.visibility = TextView.INVISIBLE
                        if (los_pier_cw == 1) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_ram_1)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_ram_1)
                            imageView.setImageResource(R.drawable.zak_ram_tric_kok_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_ram_tric_kok_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_tric_kok_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_tric_kok_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_pier_cw == 2) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_ram_2)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_ram_2)
                            imageView.setImageResource(R.drawable.zak_ram_tric_sc_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_ram_tric_sc_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_tric_sc_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_tric_sc_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }

                        if (los_pier_cw == 3) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_ram_3)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_ram_3)
                            imageView.setImageResource(R.drawable.zak_ram_bic_sc_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_ram_bic_sc_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_bic_sc_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_bic_sc_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_pier_cw == 4) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_ram_4)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_ram_4)
                            imageView.setImageResource(R.drawable.zak_ram_bic_czwor_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_ram_bic_czwor_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_bic_czwor_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_bic_czwor_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        mainScrollView.fullScroll((ScrollView.FOCUS_UP))
                        if (liczba_serii == licznik_serii) {
                            przejdz_dalej.setText("Następne ćwiczenie")
                        }
                    }

                    if (licznik_cwiczen == 4 && licznik_serii <= liczba_serii && licznik_serii != 0 && ekran_glowny.dane.l_zak_ram == 2) {
                        if (los_drug_cw == 0) {
                            while (los_drug_cw == los_pier_cw || los_drug_cw == 0) {
                                los_drug_cw = Random.nextInt(1, l_cw_zak_ram)
                            }
                        } else {

                        }
                        //cwiczenie_licznik.setText("Ćwiczenie: " + licznik_cwiczen + "   Seria: " + licznik_serii)
                        przejdz_dalej.setText("Następna seria")
                        serie_obciazenie.visibility = TextView.INVISIBLE
                        ilosc_powtorzen.visibility = TextView.INVISIBLE
                        wpisana_wartosc.visibility = TextView.INVISIBLE

                        if (los_drug_cw == 1) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_ram_1)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_ram_1)
                            imageView.setImageResource(R.drawable.zak_ram_tric_kok_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_ram_tric_kok_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_tric_kok_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_tric_kok_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_drug_cw == 2) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_ram_2)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_ram_2)
                            imageView.setImageResource(R.drawable.zak_ram_tric_sc_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_ram_tric_sc_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_tric_sc_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_tric_sc_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }

                        if (los_drug_cw == 3) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_ram_3)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_ram_3)
                            imageView.setImageResource(R.drawable.zak_ram_bic_sc_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_ram_bic_sc_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_bic_sc_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_bic_sc_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_drug_cw == 4) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_zak_ram_4)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_zak_ram_4)
                            imageView.setImageResource(R.drawable.zak_ram_bic_czwor_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.zak_ram_bic_czwor_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_bic_czwor_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.zak_ram_bic_czwor_przed)
                                    linearLayout.addView(imageView)
                                }
                            }

                        }
                        mainScrollView.fullScroll((ScrollView.FOCUS_UP))
                        if (liczba_serii == licznik_serii) {
                            przejdz_dalej.setText("Następne ćwiczenie")
                        }
                    }

                    if (licznik_cwiczen == 5 && licznik_serii <= liczba_serii && licznik_serii != 0) {
                        if (los_pier_cw == 0) {
                            los_pier_cw = Random.nextInt(1, l_cw_wzm_przed)
                        } else {

                        }
                        //cwiczenie_licznik.setText("Ćwiczenie: " + licznik_cwiczen + "   Seria: " + licznik_serii)
                        serie_obciazenie.visibility = TextView.VISIBLE
                        ilosc_powtorzen.visibility = TextView.VISIBLE
                        wpisana_wartosc.visibility = TextView.VISIBLE
                        przejdz_dalej.setText("Następna seria")
                        serie_obciazenie.setText("Obciążenie: " + ekran_glowny.dane.obciazenie + " kg")
                        ilosc_powtorzen.setText("Powtórzenia: " +ekran_glowny.dane.l_powtorzen)

                        if (los_pier_cw == 1) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_przed_1)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_przed_1)
                            imageView.setImageResource(R.drawable.wzm_przed_na_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_przed_na_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_przed_na_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_przed_na_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_pier_cw == 2) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_przed_2)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_przed_2)
                            imageView.setImageResource(R.drawable.wzm_przed_pod_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_przed_pod_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_przed_pod_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_przed_pod_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }

                        if (los_pier_cw == 3) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_przed_3)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_przed_3)
                            imageView.setImageResource(R.drawable.wzm_przed_boczny_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_przed_boczny_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_przed_boczny_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_przed_boczny_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        mainScrollView.fullScroll((ScrollView.FOCUS_UP))
                        if (liczba_serii == licznik_serii) {
                            przejdz_dalej.setText("Następne ćwiczenie")
                        }
                    }

                    if (licznik_cwiczen == 6 && licznik_serii <= liczba_serii && licznik_serii != 0 && ekran_glowny.dane.l_wzm_przed == 2) {
                        if (los_drug_cw == 0) {
                            while (los_drug_cw == los_pier_cw || los_drug_cw == 0) {
                                los_drug_cw = Random.nextInt(1, l_cw_wzm_przed)
                            }
                        } else {

                        }

                        przejdz_dalej.setText("Następna seria")
                        serie_obciazenie.setText("Obciążenie: " + ekran_glowny.dane.obciazenie + " kg")
                        ilosc_powtorzen.setText("Powtórzenia: " +ekran_glowny.dane.l_powtorzen)
                            serie_obciazenie.visibility = TextView.VISIBLE
                            ilosc_powtorzen.visibility = TextView.VISIBLE
                            wpisana_wartosc.visibility = TextView.VISIBLE

                        if (los_drug_cw == 1) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_przed_1)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_przed_1)
                            imageView.setImageResource(R.drawable.wzm_przed_na_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_przed_na_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_przed_na_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_przed_na_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_drug_cw == 2) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_przed_2)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_przed_2)
                            imageView.setImageResource(R.drawable.wzm_przed_pod_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_przed_pod_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_przed_pod_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_przed_pod_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }

                        if (los_drug_cw == 3) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_przed_3)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_przed_3)
                            imageView.setImageResource(R.drawable.wzm_przed_boczny_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_przed_boczny_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_przed_boczny_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_przed_boczny_przed)
                                    linearLayout.addView(imageView)
                                }
                            }

                        }
                        mainScrollView.fullScroll((ScrollView.FOCUS_UP))
                        if (liczba_serii == licznik_serii) {
                            przejdz_dalej.setText("Następne ćwiczenie")
                        }
                    }
                    if (licznik_cwiczen == 7 && licznik_serii <= liczba_serii && licznik_serii != 0) {
                        if (los_pier_cw == 0) {
                            los_pier_cw = Random.nextInt(1, l_cw_wzm_ram)
                        } else {

                        }

                        przejdz_dalej.setText("Następna seria")
                        serie_obciazenie.setText("Obciążenie: " + ekran_glowny.dane.obciazenie + " kg")
                        ilosc_powtorzen.setText("Powtórzenia: " +ekran_glowny.dane.l_powtorzen)
                        serie_obciazenie.visibility = TextView.VISIBLE
                        ilosc_powtorzen.visibility = TextView.VISIBLE
                        wpisana_wartosc.visibility = TextView.VISIBLE

                        if (los_pier_cw == 1) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_ram_1)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_ram_1)
                            imageView.setImageResource(R.drawable.wzm_ram_tri_stoj_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_ram_tri_stoj_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_tri_stoj_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_tri_stoj_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_pier_cw == 2) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_ram_2)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_ram_2)
                            imageView.setImageResource(R.drawable.wzm_ram_tri_poch_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_ram_tri_poch_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_tri_poch_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_tri_poch_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }

                        if (los_pier_cw == 3) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_ram_3)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_ram_3)
                            imageView.setImageResource(R.drawable.wzm_ram_tri_lez_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_ram_tri_lez_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_tri_lez_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_tri_lez_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_pier_cw == 4) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_ram_4)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_ram_4)
                            imageView.setImageResource(R.drawable.wzm_ram_bic_stoj_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_ram_bic_stoj_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_bic_stoj_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_bic_stoj_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_pier_cw == 5) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_ram_5)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_ram_5)
                            imageView.setImageResource(R.drawable.wzm_ram_bic_siedz_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_ram_bic_siedz_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_bic_siedz_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_bic_siedz_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }

                        if (los_pier_cw == 6) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_ram_6)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_ram_6)
                            imageView.setImageResource(R.drawable.wzm_ram_bic_stoj_rot_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_ram_bic_stoj_rot_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_bic_stoj_rot_po)
                                    linearLayout.addView(imageView)
                                } else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_bic_stoj_rot_przed)
                                    linearLayout.addView(imageView)
                                }
                            }

                        }
                        mainScrollView.fullScroll((ScrollView.FOCUS_UP))
                        if (liczba_serii == licznik_serii) {
                            przejdz_dalej.setText("Następne ćwiczenie")
                        }
                    }
                    if (licznik_cwiczen == 8 && licznik_serii <= liczba_serii && licznik_serii != 0 && ekran_glowny.dane.l_wzm_ram == 2) {
                        if (los_drug_cw == 0) {
                            while (los_drug_cw == los_pier_cw || los_drug_cw == 0) {
                                los_drug_cw = Random.nextInt(1, l_cw_wzm_ram)
                            }
                        } else {

                        }

                        przejdz_dalej.setText("Następna seria")
                        serie_obciazenie.setText("Obciążenie: " + ekran_glowny.dane.obciazenie + " kg")
                        ilosc_powtorzen.setText("Powtórzenia: " +ekran_glowny.dane.l_powtorzen)
                        serie_obciazenie.visibility = TextView.VISIBLE
                        ilosc_powtorzen.visibility = TextView.VISIBLE
                        wpisana_wartosc.visibility = TextView.VISIBLE

                        if (los_drug_cw == 1) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_ram_1)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_ram_1)
                            imageView.setImageResource(R.drawable.wzm_ram_tri_stoj_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_ram_tri_stoj_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_tri_stoj_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_tri_stoj_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_drug_cw == 2) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_ram_2)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_ram_2)
                            imageView.setImageResource(R.drawable.wzm_ram_tri_poch_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_ram_tri_poch_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_tri_poch_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_tri_poch_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }

                        if (los_drug_cw == 3) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_ram_3)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_ram_3)
                            imageView.setImageResource(R.drawable.wzm_ram_tri_lez_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_ram_tri_lez_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_tri_lez_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_tri_lez_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_drug_cw == 4) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_ram_4)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_ram_4)
                            imageView.setImageResource(R.drawable.wzm_ram_bic_stoj_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_ram_bic_stoj_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_bic_stoj_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_bic_stoj_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }
                        if (los_drug_cw == 5) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_ram_5)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_ram_5)
                            imageView.setImageResource(R.drawable.wzm_ram_bic_siedz_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_ram_bic_siedz_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_bic_siedz_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_bic_siedz_przed)
                                    linearLayout.addView(imageView)
                                }
                            }
                        }

                        if (los_drug_cw == 6) {
                            cwiczenie_nazwa.text = getString(R.string.cwiczenie_nazwa_wzm_ram_6)
                            opis_cwiczenia.text = getString(R.string.opis_cwiczenia_wzm_ram_6)
                            imageView.setImageResource(R.drawable.wzm_ram_bic_stoj_rot_przed)
                            linearLayout.addView(imageView)
                            imageView.setOnClickListener() {
                                if (imageView.getDrawable().getConstantState() == resources.getDrawable(R.drawable.wzm_ram_bic_stoj_rot_przed).getConstantState()) {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_bic_stoj_rot_po)
                                    linearLayout.addView(imageView)
                                }
                                else {
                                    linearLayout.removeView(imageView)
                                    imageView.setImageResource(R.drawable.wzm_ram_bic_stoj_rot_przed)
                                    linearLayout.addView(imageView)
                                }
                            }

                        }
                        mainScrollView.fullScroll((ScrollView.FOCUS_UP))
                        if (liczba_serii == licznik_serii) {
                            przejdz_dalej.setText("Następne ćwiczenie")
                        }

                    }
                    if (przejdz_dalej.text.toString() == "Zakończ") {
                        przejdz_dalej.setOnClickListener() {

                            licznik_serii = 1
                            licznik_serii = 1

                            val intent = Intent(this, ekran_glowny::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                            this.startActivity(intent)
                        }

                    }

                    if((licznik_cwiczen == 5 || licznik_cwiczen == 6 || licznik_cwiczen == 7 || licznik_cwiczen == 8) && sprawdzanie_wartosci == true)
                    {
                        if(wpisana_wartosc.text.toString() == "" || wpisana_wartosc.text.toString().toDouble() <= 0.0 || wpisana_wartosc.text.toString().toDouble() > ekran_glowny.dane.l_powtorzen.toDouble())
                        {
                            mainScrollView.fullScroll((ScrollView.FOCUS_UP))
                            cwiczenie_licznik.setText("Ćwiczenie: " + licznik_cwiczen + "   Seria: " + licznik_serii)
                        }
                        else {


                            if (licznik_serii == liczba_serii  && licznik_cwiczen == 5 && ekran_glowny.dane.l_wzm_przed == 1 && ekran_glowny.dane.l_wzm_ram == 2)
                            {
                                licznik_cwiczen = licznik_cwiczen + 2
                                licznik_serii = 1
                                sprawdzanie_wartosci = true
                                liczba_pod_cie_suma = wpisana_wartosc.text.toString().toDouble() * ekran_glowny.dane.obciazenie + liczba_pod_cie_suma
                                Podsumowanie.aktualizacja.suma_kg_dzien = liczba_pod_cie_suma
                                wpisana_wartosc.setText("")
                                przejdz_dalej.callOnClick()
                            }
                            if (licznik_serii == liczba_serii && licznik_cwiczen == 7 && ekran_glowny.dane.l_wzm_ram == 1 && ekran_glowny.dane.l_wzm_przed == 2)
                            {
                                licznik_cwiczen++
                                licznik_serii = 1
                                sprawdzanie_wartosci = true
                                liczba_pod_cie_suma = wpisana_wartosc.text.toString().toDouble() * ekran_glowny.dane.obciazenie + liczba_pod_cie_suma
                                Podsumowanie.aktualizacja.suma_kg_dzien = liczba_pod_cie_suma
                                wpisana_wartosc.setText("")
                                przejdz_dalej.callOnClick()
                            }
                            if(licznik_serii == liczba_serii)
                            {
                                licznik_serii = 1
                                licznik_cwiczen++
                                sprawdzanie_wartosci = true
                                liczba_pod_cie_suma = wpisana_wartosc.text.toString().toDouble() * ekran_glowny.dane.obciazenie + liczba_pod_cie_suma
                                Podsumowanie.aktualizacja.suma_kg_dzien = liczba_pod_cie_suma
                                wpisana_wartosc.setText("")
                                przejdz_dalej.callOnClick()
                            }
                            else sprawdzanie_wartosci = false

                            if ( sprawdzanie_wartosci == false)
                            {
                                if(!(wpisana_wartosc.text.toString() == "") && licznik_serii != liczba_serii )
                                {
                                    liczba_pod_cie_suma = wpisana_wartosc.text.toString().toDouble() * ekran_glowny.dane.obciazenie + liczba_pod_cie_suma
                                    Podsumowanie.aktualizacja.suma_kg_dzien = liczba_pod_cie_suma
                                    sprawdzanie_wartosci = true
                                    mainScrollView.fullScroll((ScrollView.FOCUS_UP))
                                    licznik_serii = licznik_serii + 1
                                    cwiczenie_licznik.setText("Ćwiczenie: " + licznik_cwiczen + "   Seria: " + licznik_serii)
                                    if(licznik_cwiczen == 6 && licznik_serii == 1 && ekran_glowny.dane.l_wzm_przed == 2 && ekran_glowny.dane.l_wzm_ram == 1)
                                    {
                                        while (los_drug_cw == los_pier_cw || los_drug_cw == 0) {
                                            los_drug_cw = Random.nextInt(1, l_cw_wzm_przed)
                                        }
                                    }
                                    if(licznik_cwiczen == 8 && licznik_serii == 1 && ekran_glowny.dane.l_wzm_ram == 2 && ekran_glowny.dane.l_wzm_przed == 1)
                                    {
                                        while (los_drug_cw == los_pier_cw || los_drug_cw == 0) {
                                            los_drug_cw = Random.nextInt(1, l_cw_wzm_ram)
                                        }
                                    }

                                }
                            }
                        }

                    }

                    if (licznik_serii == liczba_serii && licznik_cwiczen == 1 && ekran_glowny.dane.l_zak_przed == 1) {
                        licznik_cwiczen++
                        licznik_serii = 0
                    }
                    if (licznik_serii == liczba_serii && licznik_cwiczen == 3 && ekran_glowny.dane.l_zak_ram == 1)  {
                        licznik_cwiczen++
                        licznik_serii = 0
                    }
                    /*if (licznik_serii == liczba_serii && licznik_cwiczen == 5 && ekran_glowny.dane.l_wzm_przed == 1) {
                        licznik_cwiczen++
                        licznik_serii = 0
                    }
                    if (licznik_serii == liczba_serii && licznik_cwiczen == 7 && ekran_glowny.dane.l_wzm_ram == 1) {
                        licznik_cwiczen++
                        licznik_serii = 0
                    }
*/
                    if (licznik_cwiczen % 2 == 0 && licznik_serii == liczba_serii) {
                        los_pier_cw = 0
                        los_drug_cw = 0

                    }
                    if ((licznik_serii == liczba_serii || licznik_serii == 0) && (licznik_cwiczen == 1 || licznik_cwiczen == 2 || licznik_cwiczen == 3 || licznik_cwiczen == 4)) {
                        licznik_cwiczen++
                        licznik_serii = 1
                        sprawdzanie_wartosci = false
                    }

                    if (sprawdzanie_wartosci == true && (licznik_cwiczen == 1 || licznik_cwiczen == 2 || licznik_cwiczen == 3 || licznik_cwiczen == 4))
                    {
                        licznik_serii = licznik_serii + 1
                    }

                    if(licznik_cwiczen == 1 || licznik_cwiczen == 2 || licznik_cwiczen == 3 || licznik_cwiczen == 4)
                    {
                        sprawdzanie_wartosci = true
                    }
                    if((licznik_cwiczen == 5 && licznik_serii == 1) || (licznik_cwiczen == 7 && licznik_serii == 1))
                    {
                        sprawdzanie_wartosci = true
                    }

                    if (licznik_serii == liczba_serii || (licznik_cwiczen == 6 && licznik_serii ==0))
                    {
                        przejdz_dalej.setText("Następne ćwiczenie")
                    }
                    if ((licznik_cwiczen == 8 && licznik_serii == liczba_serii) || (licznik_cwiczen == 7 && licznik_serii == liczba_serii && ekran_glowny.dane.l_zak_ram == 1)) {
                        przejdz_dalej.setText("Zakończ")
                    }
                    if (przejdz_dalej.text.toString() == "Zakończ") {
                        przejdz_dalej.setOnClickListener() {
                            if(wpisana_wartosc.text.toString() == "" || wpisana_wartosc.text.toString().toDouble() <= 0.0 || wpisana_wartosc.text.toString().toDouble() > ekran_glowny.dane.l_powtorzen.toDouble())
                            {
                                sprawdzanie_wartosci = true
                            }
                            else {
                                liczba_pod_cie_suma = liczba_pod_cie_suma + ekran_glowny.dane.obciazenie * wpisana_wartosc.text.toString().toDouble()
                                Podsumowanie.aktualizacja.suma_kg_dzien = liczba_pod_cie_suma
                                val intent = Intent(this, Podsumowanie::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                this.startActivity(intent)
                                licznik_cwiczen = 1
                                licznik_serii = 1
                            }

                        }

                    }

                    println("Suma podniesiona kg: " + liczba_pod_cie_suma)
                    println("Cwiczenie: " + licznik_cwiczen)
                    println("Seria: " + licznik_serii)
                    println(Podsumowanie.aktualizacja.suma_kg_dzien)
                    wpisana_wartosc.setText("")
                    wpisana_wartosc.hint = getString(R.string.Wykonane_powtorzenia)
                    hideKeyboard(it)
                    mainScrollView.fullScroll((ScrollView.FOCUS_UP))

                }

    }


}
