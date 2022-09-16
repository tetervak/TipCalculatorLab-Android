package ca.tetervak.tipcalculatorlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.tetervak.tipcalculatorlab.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            onCalculateTip()
        }

        showTipAmount(0.0)
    }

    private fun onCalculateTip() {

        val stringInTextField = binding.costOfService.text.toString()

        val tipCalculator = TipCalculator()
        with(tipCalculator) {
            costOfService = if (stringInTextField.isNotEmpty()) {
                stringInTextField.toDouble()
            } else 0.0
            tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
                R.id.option_twenty_percent -> 0.20
                R.id.option_eighteen_percent -> 0.18
                else -> 0.15
            }
            roundUpTip = binding.roundUpSwitch.isChecked
        }

        showTipAmount(tipCalculator.tipAmount)
    }

    private fun showTipAmount(tipAmount: Double){
        val formattedTip = NumberFormat.getCurrencyInstance().format(tipAmount)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}