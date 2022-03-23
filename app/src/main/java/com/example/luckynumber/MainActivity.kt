package com.example.luckynumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val chancesLeftText: TextView = findViewById(R.id.textView3)
        var rollChances = 3
        rollButton.setOnClickListener {
            val luckyNum = generateLuckyNumber()
            displayLuckyNum(luckyNum)
            val diceSum = rollDices()
            rollChances = gameLogic(luckyNum, diceSum, rollChances)

            if(rollChances >    0){
                if(diceSum == luckyNum){
                    Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Roll Please", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "GAME OVER", Toast.LENGTH_SHORT).show()
                rollChances = 3
            }
            chancesLeftText.text = rollChances.toString()

        }
    }

    fun gameLogic(luckyNum: Int, diceSum: Int, chances: Int): Int{
        var count = chances
        if(luckyNum == diceSum || luckyNum != diceSum){
            count--
        }
        return count
    }

    private fun generateLuckyNumber(): Int {
        return (3..18).random()
    }

    private fun displayLuckyNum(num: Int) {
        val luckyNumText: TextView = findViewById(R.id.textView)
        luckyNumText.text = num.toString()
    }

    fun rollDices(): Int{
        val dice1 = Dice1(6)
        val dice2 = Dice2(6)
        val dice3 = Dice3(6)

        val diceVal1 = dice1.roll()
        val diceVal2 = dice2.roll()
        val diceVal3 = dice3.roll()

        val diceSum = diceVal1 + diceVal2 + diceVal3

        val textForDice1: TextView = findViewById(R.id.textView6)
        val textForDice2: TextView = findViewById(R.id.textView7)
        val textForDice3: TextView = findViewById(R.id.textView8)

        textForDice1.text = diceVal1.toString()
        textForDice2.text = diceVal2.toString()
        textForDice3.text = diceVal3.toString()

        return diceSum
    }




}


class Dice1(private val numSides: Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}

class Dice2(private val numSides: Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}

class Dice3(private val numSides: Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}

