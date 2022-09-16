package ca.tetervak.tipcalculatorlab

class TipCalculator {

    var costOfService: Double = 0.0
    var tipPercentage: Double = 0.15
    var roundUpTip: Boolean = true

    val tipAmount: Double
        get(){
            var tip = tipPercentage * costOfService
            if(roundUpTip) tip = kotlin.math.ceil(tip)
            return tip
        }
}