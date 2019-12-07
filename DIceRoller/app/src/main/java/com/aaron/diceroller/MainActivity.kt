package com.aaron.diceroller

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var mBtn: AppCompatButton
    lateinit var mTxt: AppCompatTextView
    lateinit var mImgDice1: AppCompatImageView
    lateinit var mImgDice2: AppCompatImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTxt = findViewById(R.id.txt_dice_label)
        mImgDice1 = findViewById(R.id.img_dice1)
        mImgDice2 = findViewById(R.id.img_dice2)
    }

    private fun getRandomDiceImage(): Int{
        val random = Random().nextInt(6) + 1
        val img = when (random) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        return img
    }

    fun rollDice(view: View) {
        mImgDice1.setImageResource(getRandomDiceImage())
        mImgDice2.setImageResource(getRandomDiceImage())
    }
}
