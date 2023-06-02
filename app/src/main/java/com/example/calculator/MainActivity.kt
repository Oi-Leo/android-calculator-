package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    enum class Operation {
        None,
        Add,
        Sub,
        Mult,
        Div
    }

    private lateinit var binding: ActivityMainBinding
    private var num1: Int = 0
    private var num2: Int = 0
    private var currentOperation: Operation = Operation.None

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.apply {
            btnZero.setOnClickListener {
                appendText("0")
            }
            btnOne.setOnClickListener {
                appendText("1")
            }
            btnTwo.setOnClickListener {
                appendText("2")
            }
            btnThree.setOnClickListener {
                appendText("3")
            }
            btnFour.setOnClickListener {
                appendText("4")
            }
            btnFive.setOnClickListener {
                appendText("5")
            }
            btnSix.setOnClickListener {
                appendText("6")
            }
            btnSeven.setOnClickListener {
                appendText("7")
            }
            btnEight.setOnClickListener {
                appendText("8")
            }
            btnNine.setOnClickListener {
                appendText("9")
            }
            btnAdd.setOnClickListener {
                if (editText.text.toString().isEmpty()) {
                    return@setOnClickListener
                }
                num1 = editText.text.toString().toInt()
                currentOperation = Operation.Add
                tvOperation.text = editText.text.toString()
                editText.text.clear()
            }
            btnClear.setOnClickListener {
                editText.text.clear()
                tvOperation.text = ""
                num1 = 0
                num2 = 0
                currentOperation = Operation.None
            }
            btnDivide.setOnClickListener {
                if (editText.text.toString().isEmpty()) {
                    return@setOnClickListener
                }
                num1 = editText.text.toString().toInt()
                currentOperation = Operation.Div
                tvOperation.text = editText.text.toString()
                editText.text.clear()
            }
            btnEqual.setOnClickListener {
                if (editText.text.toString().isEmpty()) {
                    return@setOnClickListener
                }
                num2 = editText.text.toString().toInt()
                editText.text.clear()
                calculate(currentOperation)
            }
            btnMultiply.setOnClickListener {
                if (editText.text.toString().isEmpty()) {
                    return@setOnClickListener
                }
                num1 = editText.text.toString().toInt()
                currentOperation = Operation.Mult
                tvOperation.text = editText.text.toString()
                editText.text.clear()
            }
            btnSub.setOnClickListener {
                if (editText.text.toString().isEmpty()) {
                    return@setOnClickListener
                }
                num1 = editText.text.toString().toInt()
                currentOperation = Operation.Sub
                tvOperation.text = editText.text.toString()
                editText.text.clear()
            }
        }

    }

    private fun calculate(operation: Operation) {
        when (operation) {
            Operation.None -> {}
            Operation.Add -> {
                val result = num1 + num2
                binding.tvOperation.text = result.toString()
            }

            Operation.Sub -> {
                val result = num1 - num2
                binding.tvOperation.text = result.toString()
            }

            Operation.Mult -> {
                val result = num1 * num2
                binding.tvOperation.text = result.toString()
            }

            Operation.Div -> {
                val result = num1 / num2
                binding.tvOperation.text = result.toString()
            }
        }
    }

    private fun appendText(text: String) {
        val currentValue = binding.editText.text.toString()
        val newText = currentValue + text
        binding.editText.setText(newText)
    }

}