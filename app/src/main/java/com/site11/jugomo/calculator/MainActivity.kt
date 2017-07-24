package com.site11.jugomo.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btNumber(view: View) {
        if(isNewOp) {
            editText.setText("")
        }
        isNewOp = false

        val sel = view as Button
        var value: String = editText.text.toString()

        when (sel.id) {
            bt1.id -> {
                value += "1"
            }
            bt2.id -> {
                value += "2"
            }
            bt3.id -> {
                value += "3"
            }
            bt4.id -> {
                value += "4"
            }
            bt5.id -> {
                value += "5"
            }
            bt6.id -> {
                value += "6"
            }
            bt7.id -> {
                value += "7"
            }
            bt8.id -> {
                value += "8"
            }
            bt9.id -> {
                value += "9"
            }
            bt0.id -> {
                value += "0"
            }
            btDot.id -> {
                value += "."
            }
            btPlusMinus.id -> {
                value = "-" + value
            }
        }
        editText.setText(value)
    }

    var op = "*"
    var old: String = ""
    var isNewOp = true

    fun btOpEvent(view: View) {
        var btSel = view as Button

        when(btSel.id) {
            btMul.id -> {
                op = "*"
            }
            btDiv.id -> {
                op = "/"
            }
            btPlus.id -> {
                op = "+"
            }
            btMinus.id -> {
                op = "-"
            }
        }

        old = editText.text.toString()
        isNewOp = true
    }

    fun btEqualEvent(view: View) {
        var newNumber = editText.text.toString()
        var finalNumber: Double? = null

        when(op) {
            "*" -> {
                finalNumber = old.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = old.toDouble() / newNumber.toDouble()
            }
            "+" -> {
                finalNumber = old.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = old.toDouble() - newNumber.toDouble()
            }
        }

        editText.setText(finalNumber.toString())
        isNewOp = true
    }

    fun btPercent(view: View ){
        val number: Double = editText.text.toString().toDouble() / 100

        editText.setText(number.toString())
        isNewOp = true
    }

    fun btClean(view: View) {
        editText.setText("0")
        isNewOp = true
    }

}
