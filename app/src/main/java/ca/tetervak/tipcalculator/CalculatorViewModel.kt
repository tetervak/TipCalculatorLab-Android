package ca.tetervak.tipcalculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(CalculatorUiState())
    val uiState = _uiState.asStateFlow()

    private val amountInput: String
    get() = _uiState.value.amountInput

    private val tipInput: String
    get() = _uiState.value.tipInput

    private val roundUp: Boolean
    get() = _uiState.value.roundUp


    fun updateAmountInput(newInput: String) {
        _uiState.value = _uiState.value.copy(
            amountInput = newInput,
            tip = calculateTip()
        )
    }

    fun updateTipInput(newInput: String) {
        _uiState.value = _uiState.value.copy(
            tipInput = newInput,
            tip = calculateTip()
        )
    }

    fun updateRoundUp(newRoundUp: Boolean) {
        _uiState.value = _uiState.value.copy(
            roundUp = newRoundUp,
            tip = calculateTip()
        )
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