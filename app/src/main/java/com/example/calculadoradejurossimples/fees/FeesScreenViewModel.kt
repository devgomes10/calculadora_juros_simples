package com.example.calculadoradejurossimples.fees

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculadoradejurossimples.calculateAmount
import com.example.calculadoradejurossimples.calculateFees

class FeesScreenViewModel: ViewModel () {

    private val _capital = MutableLiveData<String>()
    val capital: LiveData<String> = _capital

    private val _rate = MutableLiveData<String>()
    val rate: LiveData<String> = _rate

    private val _time = MutableLiveData<String>()
    val time: LiveData<String> = _time

    private val _fees = MutableLiveData<Double>()
    val fees: LiveData<Double> = _fees

    private val _amount = MutableLiveData<Double>()
    val amount: LiveData<Double> = _amount

    fun onCapitalChanged(newCapital: String) {
        _capital.value = newCapital
    }

    fun onRateChanged(newRate: String) {
        _rate.value = newRate
    }

    fun onTimeChanged(newTime: String) {
        _time.value = newTime
    }

    fun calculateFeesViewModel () {
        _fees.value = calculateFees(
            capital = _capital.value!!.toDouble(),
            taxa = _rate.value!!.toDouble(),
            tempo = _time.value!!.toDouble()
        )
    }

    fun calculateAmountViewModel () {
        _amount.value = calculateAmount(
            capital = _capital.value!!.toDouble(),
            juros = _capital.value!!.toDouble()
        )
    }

}