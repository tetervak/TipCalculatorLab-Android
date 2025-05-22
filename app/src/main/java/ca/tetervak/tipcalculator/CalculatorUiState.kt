package ca.tetervak.tipcalculator

data class CalculatorUiState(
    val amountInput: String = "",
    val tipInput: String = "",
    val roundUp: Boolean = false,
    val tip: Double = 0.0
)
