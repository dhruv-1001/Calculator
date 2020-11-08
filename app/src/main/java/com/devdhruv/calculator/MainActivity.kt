package com.devdhruv.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var decimalPresent: Boolean = false

    fun numberClick(view: View) {
        if (newOperation) {
            answer.setText("")
        }
        newOperation = false
        val buttonPressed = view as Button
        var numberShown: String = answer.text.toString()
        when (buttonPressed.id) {
            R.id.zero -> {
                if (numberShown.length != 1) numberShown += "0"
            }
            R.id.one -> {
                numberShown += "1"
            }
            R.id.two -> {
                numberShown += "2"
            }
            R.id.three -> {
                numberShown += "3"
            }
            R.id.four -> {
                numberShown += "4"
            }
            R.id.five -> {
                numberShown += "5"
            }
            R.id.six -> {
                numberShown += "6"
            }
            R.id.seven -> {
                numberShown += "7"
            }
            R.id.eight -> {
                numberShown += "8"
            }
            R.id.nine -> {
                numberShown += "9"
            }
            R.id.decimal -> {
                if (!decimalPresent) {
                    numberShown += "."
                    decimalPresent = true
                }
            }
            R.id.signChange -> {
                if (numberShown[0] == '-') {
                    numberShown = numberShown.substring(1)
                } else {
                    numberShown = "-$numberShown"
                }
            }
        }

        answer.setText(numberShown)

    }

    private var operations: String = "+"
    var oldNumber = "0"
    var newOperation: Boolean = true

    fun operationClick(view: View) {

        val buttonPressed = view as Button
        when (buttonPressed.id) {
            R.id.multiplication -> {
                operations = "*"
            }
            R.id.division -> {
                operations = "/"
            }
            R.id.addition -> {
                operations = "+"
            }
            R.id.subtraction -> {
                operations = "-"
            }
        }
        oldNumber = answer.text.toString()
        newOperation = true
    }

    fun equalClick(view: View) {

        var newNumber = answer.text.toString()
        var finalNumber: Double? = null

        when (operations) {
            "*" -> {
                finalNumber = newNumber.toDouble() * oldNumber.toDouble()
            }
            "+" -> {
                finalNumber = newNumber.toDouble() + oldNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
        }
        answer.setText(finalNumber.toString())
        newOperation = true
        oldNumber = finalNumber.toString()
    }

    fun acClick(view: View){

        answer.setText("0")
        newOperation = true
        oldNumber = "0"
    }

    fun percentClick(view: View){

        var percentage:Double = answer.text.toString().toDouble()
        percentage /= 100
        answer.setText(percentage.toString())

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}