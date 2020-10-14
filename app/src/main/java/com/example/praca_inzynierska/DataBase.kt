package com.example.praca_inzynierska

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import java.security.AccessControlContext

object Podstawowe_Dane: BaseColumns {

        const val Table_Name = "User_Base"
        const val Table_Column_Login = "Login"
        const val Table_Column_Wiek = "Wiek"
        const val Table_Column_Wzrost = "Wzrost"
        const val Table_Column_Waga = "Waga"
        const val Table_Column_Plec = "Płeć"
        const val Table_Column_Aktywnosc = "Aktywność"
        const val Table_Column_Uraz = "Uraz"
        const val Table_Column_Schorzenia = "Schorzenia"
        const val Table_Column_BMI = "BMI"
        const val Table_Column_l_zak_przed = "Liczba_ćwiczeń_zakresu_dla_przedramienia"
        const val Table_Column_l_zak_ram = "Liczba_ćwiczeń_zakresu_dla_ramienia"
        const val Table_Column_l_wzm_przed = "Liczba_ćwiczeń_wzmacniających_przedramię"
        const val Table_Column_l_wzm_ram = "Liczba_ćwiczeń_wzmacniających_ramię"
        const val Table_Column_liczba_serii = "Liczba_serii"
        const val Table_Column_liczba_powtorzen = "Liczba_powtórzeń"
        const val Table_Column_kg = "Obciążenie_start"
        const val Table_Column_dzien = "Dzień_rehabilitacji"
        const val Table_Column_szacowany_czas = "Szacowany_czas"
        const val Table_Column_suma_kg = "Suma_kg"
        const val Table_Column_suma_cwiczen = "Suma_cwiczen"
        const val Table_Column_suma_serii = "Suma_serii"
        const val Table_Column_suma_powtorzen = "Suma_powtorzen"
    }

object BasicCommand {

    const val SQL_Create_Table  =
        "CREATE TABLE ${Podstawowe_Dane.Table_Name} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${Podstawowe_Dane.Table_Column_Login} TEXT NOT NULL," +
                "${Podstawowe_Dane.Table_Column_Wiek} INTEGER NOT NULL," +
                "${Podstawowe_Dane.Table_Column_Wzrost} INTEGER NOT NULL," +
                "${Podstawowe_Dane.Table_Column_Waga} INTEGER NOT NULL," +
                "${Podstawowe_Dane.Table_Column_Plec} TEXT NOT NULL," +
                "${Podstawowe_Dane.Table_Column_Aktywnosc} TEXT NOT NULL," +
                "${Podstawowe_Dane.Table_Column_Uraz} TEXT NOT NULL," +
                "${Podstawowe_Dane.Table_Column_Schorzenia} TEXT NOT NULL," +
                "${Podstawowe_Dane.Table_Column_BMI} DOUBLE NOT NULL," +
                "${Podstawowe_Dane.Table_Column_l_zak_przed} INTEGER NOT NULL," +
                "${Podstawowe_Dane.Table_Column_l_zak_ram} INTEGER NOT NULL," +
                "${Podstawowe_Dane.Table_Column_l_wzm_przed} INTEGER NOT NULL," +
                "${Podstawowe_Dane.Table_Column_l_wzm_ram} INTEGER NOT NULL," +
                "${Podstawowe_Dane.Table_Column_liczba_serii} INTEGER NOT NULL," +
                "${Podstawowe_Dane.Table_Column_liczba_powtorzen} INTEGER NOT NULL," +
                "${Podstawowe_Dane.Table_Column_kg} DOUBLE NOT NULL," +
                "${Podstawowe_Dane.Table_Column_dzien} INTEGER NOT NULL," +
                "${Podstawowe_Dane.Table_Column_szacowany_czas} INTEGER NOT NULL," +
                "${Podstawowe_Dane.Table_Column_suma_kg} DOUBLE," +
                "${Podstawowe_Dane.Table_Column_suma_cwiczen} INTEGER," +
                "${Podstawowe_Dane.Table_Column_suma_serii} INTEGER," +
                "${Podstawowe_Dane.Table_Column_suma_powtorzen} INTEGER)"


    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS ${Podstawowe_Dane.Table_Name}"

    }

    class DataBaseHelper (context: Context): SQLiteOpenHelper(context, Podstawowe_Dane.Table_Name, null, DATABASE_VERSION) {

        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(BasicCommand.SQL_Create_Table)
        }
        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL(BasicCommand.SQL_DELETE_TABLE)
            onCreate(db)
        }


        companion object {
            const val DATABASE_VERSION = 1
        }

    }