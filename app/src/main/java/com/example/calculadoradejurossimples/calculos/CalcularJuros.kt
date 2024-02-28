package com.example.calculadoradejurossimples

fun calculateFees(capital: Double, taxa: Double, tempo: Double): Double {
    return capital * taxa / 100 * tempo
}

fun calculateAmount(capital: Double, juros: Double): Double {
    return capital + juros
}