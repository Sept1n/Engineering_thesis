package com.example.praca_inzynierska

fun ObliczanieBMI() {
    var wzrost_float: Float = static.wzrost.toFloat()

    static.BMI = ((wzrost_float.toDouble()/100)*(wzrost_float.toDouble())/100)
    static.BMI = static.waga.toDouble()/static.BMI
}

fun Initial_values() {

    var liczbaserii: Double = static.liczba_serii.toDouble()
    var liczbapowtorzen: Double = static.liczba_powtorzen.toDouble()

    when (static.wiek)
    {
        in 18..30 -> liczbaserii = liczbaserii + 0.7
        in 31..50 -> liczbaserii = liczbaserii + 0.3
        in 51..70 -> liczbaserii = liczbaserii + 0.1
    }
    when (static.wiek)
    {
        in 18..30 -> liczbapowtorzen = liczbapowtorzen + 1.5
        in 31..50 -> liczbapowtorzen = liczbapowtorzen + 0.8
        in 51..70 -> liczbapowtorzen = liczbapowtorzen + 0.4
    }
    when (static.BMI)
    {
        in 0..19 -> liczbaserii = liczbaserii
        in 19..25 -> liczbaserii = liczbaserii + 1
        in 25..30 -> liczbaserii = liczbaserii
        in 30..40 -> liczbaserii = liczbaserii - 0.5
        else -> liczbaserii = liczbaserii - 1
    }
    when (static.BMI)
    {
        in 0..19 -> liczbapowtorzen = liczbapowtorzen
        in 19..25 -> liczbapowtorzen = liczbapowtorzen +2
        in 25..30 -> liczbapowtorzen = liczbapowtorzen
        in 30..40 -> liczbapowtorzen = liczbapowtorzen - 1
        else -> liczbapowtorzen = liczbapowtorzen - 2

    }
    when (static.plec)
    {
        "mężczyzna" -> liczbaserii = liczbaserii + 0.5
        "kobieta" -> liczbaserii = liczbaserii
    }
    when (static.plec)
    {
        "mężczyzna" -> liczbapowtorzen = liczbapowtorzen + 2
        "kobieta" -> liczbapowtorzen = liczbapowtorzen
    }
    when (static.aktywnosc)
    {
        "brak" -> liczbaserii = liczbaserii - 0.5
        "niewielka" -> liczbaserii = liczbaserii
        "umiarkowana" -> liczbaserii = liczbaserii + 0.5
        "wysoka" -> liczbaserii = liczbaserii + 1
        "bardzo wysoka" -> liczbaserii = liczbaserii + 1.5
    }
    when (static.aktywnosc)
    {
        "brak" -> liczbapowtorzen = liczbapowtorzen - 0.5
        "niewielka" -> liczbapowtorzen = liczbapowtorzen
        "umiarkowana" -> liczbapowtorzen = liczbapowtorzen + 0.5
        "wysoka" -> liczbapowtorzen = liczbapowtorzen + 1
        "bardzo wysoka" -> liczbapowtorzen = liczbapowtorzen + 1.5
    }
    when (static.schorzenie)
    {
        "tak" -> liczbaserii = liczbaserii - 1
        "nie" -> liczbaserii = liczbaserii
    }
    when (static.plec)
    {
        "tak" -> liczbapowtorzen = liczbapowtorzen - 2
        "nie" -> liczbapowtorzen = liczbapowtorzen + 2
    }
    when (static.uraz)
    {
        "przedramię", "całość" -> static.l_zak_przed = 2
        "ramię" -> static.l_zak_przed = 1
    }
    when (static.uraz)
    {
        "przedramię" -> static.l_zak_ram = 1
        "ramię", "całość" -> static.l_zak_ram = 2
    }
    when (static.uraz)
    {
        "przedramię", "całość" -> static.l_wzm_przed = 2
        "ramię" -> static.l_wzm_przed = 1
    }
    when (static.uraz)
    {
        "przedramię" -> static.l_wzm_ram = 1
        "ramię", "całość" -> static.l_wzm_ram = 2
    }
    when (static.schorzenie)
    {
        "tak" -> static.obciazenie = 0.5
        "nie" -> static.obciazenie = 1.0
    }

    static.liczba_serii = liczbaserii.toInt()
    if (static.liczba_serii > 4) static.liczba_serii = 4
    static.liczba_powtorzen = liczbapowtorzen.toInt()
    if (static.liczba_powtorzen > 12) static.liczba_powtorzen = 12
    if (static.liczba_serii < 2) static.liczba_serii = 2
    if (static.liczba_powtorzen < 8) static.liczba_powtorzen = 8

}