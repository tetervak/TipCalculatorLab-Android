package ca.tetervak.tipcalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    var amountInput by mutableStateOf("")
        private set

    var tipInput by mutableStateOf("")
        private set

    var roundUp by mutableStateOf(false)
        private set

    fun updateAmountInput(newInput: String) {
        amountInput = newInput
    }

    fun updateTipInput(newInput: String) {
        tipInput = newInput
    }

    fun updateRoundUp(newRoundUp: Boolean) {
        roundUp = newRoundUp
    }


    fun calculateTip(): Double {
        val amount = amountInput.toDoubleOrNull() ?: 0.0
        val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
        return calculateTip(amount, tipPercent, roundUp)
    }

    private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): Double {
        var tip = tipPercent / 100 * amount
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        return tip
    }
}