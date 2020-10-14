package com.example.praca_inzynierska

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import android.provider.BaseColumns._ID
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.app.ActivityCompat.recreate
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.users_row.view.*


class UserViewAdapter(val context: Context, val db: SQLiteDatabase): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val userRow = layoutInflater.inflate(R.layout.users_row,parent,false)
        return MyViewHolder(userRow)
    }

    override fun getItemCount(): Int {

        val cursor = db.query(Podstawowe_Dane.Table_Name, null, null, null,
            null, null, null)
        val liczba_wierszy = cursor.count
        cursor.close()

        return liczba_wierszy
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val userRow = holder.view.wiersz_user
        val context: Context = holder.view.context
        val deleteAccount = holder.view.wiersz_user2

        val cursor = db.query(Podstawowe_Dane.Table_Name, null, BaseColumns._ID + "=?",
            arrayOf(holder.adapterPosition.plus(1).toString()), null, null, null)

            if(cursor.moveToFirst()) {

                    userRow.setText(cursor.getString(1))
            }


        userRow.setOnClickListener{


                val intent: Intent = Intent(context,ekran_glowny::class.java)

                val id_user = holder.adapterPosition.plus(1)
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



                if(cursor.moveToFirst())
                {
                    login = cursor.getString(1)
                    wiek = cursor.getInt(2)
                    wzrost = cursor.getInt(3)
                    waga = cursor.getInt(4)
                    plec = cursor.getString(5)
                    aktywnosc = cursor.getString(6)
                    uraz = cursor.getString(7)
                    schorzenie = cursor.getString(8)
                    BMI = cursor.getDouble(9)
                    l_zak_przed = cursor.getInt(10)
                    l_zak_ram = cursor.getInt(11)
                    l_wzm_przed = cursor.getInt(12)
                    l_wzm_ram = cursor.getInt(13)
                    l_serii = cursor.getInt(14)
                    l_powtorzen = cursor.getInt(15)
                    obciazenie = cursor.getDouble(16)
                    dzien = cursor.getInt(17)
                    szacowany_czas = cursor.getInt(18)
                    suma_kg = cursor.getDouble(19)
                    suma_cwiczen = cursor.getInt(20)
                    suma_serii = cursor.getInt(21)
                    suma_powtorzen = cursor.getInt(22)
                }
                intent.putExtra("ID",id_user)
                intent.putExtra("Login",login)
                intent.putExtra("Wiek", wiek)
                intent.putExtra("Wzrost", wzrost)
                intent.putExtra("Waga", waga)
                intent.putExtra("Plec", plec)
                intent.putExtra("Aktywnosc", aktywnosc)
                intent.putExtra("Uraz", uraz)
                intent.putExtra("Schorzenie", schorzenie)
                intent.putExtra("BMI", BMI)
                intent.putExtra("L_zak_przed", l_zak_przed)
                intent.putExtra("L_zak_ram", l_zak_ram)
                intent.putExtra("L_wzm_przed", l_wzm_przed)
                intent.putExtra("L_wzm_ram", l_wzm_ram)
                intent.putExtra("L_serii", l_serii)
                intent.putExtra("L_powtorzen", l_powtorzen)
                intent.putExtra("Obciazenie", obciazenie)
                intent.putExtra("Dzien", dzien)
                intent.putExtra("Szacowany_czas", szacowany_czas)
                intent.putExtra("Suma_kg", suma_kg)
                intent.putExtra("Suma_cwiczen", suma_cwiczen)
                intent.putExtra("Suma_serii", suma_serii)
                intent.putExtra("Suma_powtorzen", suma_powtorzen)

                context.startActivity(intent)
            println(id_user)
            println(login)
            println(wiek)
            println(wzrost)
            println(waga)
            println(plec)
            println(uraz)
            println(schorzenie)
            println(BMI)
            println(l_zak_przed)
            println(l_zak_ram)
            println(l_wzm_przed)
            println(l_wzm_ram)
            println(l_serii)
            println(l_powtorzen)
            println(obciazenie)
            println(dzien)
            println(szacowany_czas)
            println(suma_kg)
            println(suma_cwiczen)
            println(suma_serii)
            println(suma_powtorzen)
        }

        deleteAccount.setOnClickListener {

            val id_user = holder.adapterPosition.plus(1)

            val alertDialog = AlertDialog.Builder(context).create()
            alertDialog.setTitle("Usuwanie konta")
            alertDialog.setMessage("Czy na pewno chcesz usunąć konto? Po zaakceptowaniu stracisz wszystkie swoje postępy")

            alertDialog.setButton(
                AlertDialog.BUTTON_POSITIVE, "Tak"
            ) { dialog, which -> dialog.dismiss() }

            alertDialog.setButton(
                AlertDialog.BUTTON_NEGATIVE, "Nie"
            ) { dialog, which -> dialog.dismiss() }
            alertDialog.show()

            val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
            val btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)

            val layoutParams = btnPositive.layoutParams as LinearLayout.LayoutParams
            layoutParams.weight = 10f
            btnPositive.layoutParams = layoutParams
            btnNegative.layoutParams = layoutParams

            btnNegative.setOnClickListener {
                alertDialog.cancel()
            }
            btnPositive.setOnClickListener {
                val dbHelper = DataBaseHelper(context)

                val db: SQLiteDatabase = dbHelper.writableDatabase

                db.delete(Podstawowe_Dane.Table_Name, BaseColumns._ID + "=" + id_user, arrayOf())

                Toast.makeText(
                    context,
                    "Użytkownik został usunięty, zaktualizuj listę",
                    Toast.LENGTH_LONG
                ).show()

                alertDialog.cancel()

            }

        }



        }
    }


class MyViewHolder (val view: View): RecyclerView.ViewHolder(view)