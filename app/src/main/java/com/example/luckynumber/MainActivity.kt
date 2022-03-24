package com.example.luckynumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        var chancesLeftText: TextView = findViewById(R.id.textView3)
        chancesLeftText.text = "3"

        var newGameText: TextView = findViewById(R.id.textView4)
        var rollChances = 3

        var games = 0
        var totalGamesText: TextView = findViewById(R.id.textView8)
        totalGamesText.text = games.toString()

        rollButton.setOnClickListener {
            val luckyNum = generateLuckyNumber()
            displayLuckyNum(luckyNum)
            var diceSum = rollDices()
            rollChances = gameLogic(luckyNum, diceSum, rollChances)

            if(rollChances>0){
                newGameText.text = ""
            }
            else{
                newGameText.text = "New Game"
                diceSum = 0
                games++
            }

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

            totalGamesText.text = games.toString()



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

        val diceImage1: ImageView = findViewById(R.id.imageView3)
        val diceImage2: ImageView = findViewById(R.id.imageView)
        val diceImage3: ImageView = findViewById(R.id.imageView2)

        //diceImage1.setImageResource(R.drawable.dice_1)
        //diceImage2.setImageResource(R.drawable.dice_1)
        //diceImage3.setImageResource(R.drawable.dice_1)

        val drawableResource1 = when(diceVal1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when(diceVal2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource3 = when(diceVal3){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)
        diceImage3.setImageResource(drawableResource3)

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

