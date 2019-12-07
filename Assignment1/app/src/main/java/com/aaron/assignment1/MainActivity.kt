package com.aaron.assignment1

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var mBtnLeft: AppCompatButton
    lateinit var mBtnRight: AppCompatButton
    lateinit var mTxtQuestion: TextView
    var leftColorNum = 0
    var rightColorNum = 0

    var colorlist = mutableListOf(
        R.color.blue_sky to "Skyblue", R.color.blue_ice,R.color.black, R.color.grey
        , R.color.lime, R.color.red_chili, R.color.red_rust, R.color.red_dark
        , R.color.red, R.color.white
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBtnLeft = findViewById(R.id.btnLeft)
        mBtnRight = findViewById(R.id.btnRight)
        mTxtQuestion = findViewById(R.id.txtQuestion)
        txtScore.text = getString(R.string.app_name)
        setRightBtnColor()
    }

    fun returnLeftColor(view: View) {
        setLeftBtnColor()
    }

    fun returnRightColor(view: View) {
        setRightBtnColor()
    }

    private fun setRightBtnColor() {
        rightColorNum = returnBtnColor()
        mBtnRight.setBackgroundColor(getColor(rightColorNum))
    }

    private fun setLeftBtnColor() {
        leftColorNum = returnBtnColor()
        mBtnLeft.setBackgroundColor(getColor(leftColorNum))
    }

    private fun returnBtnColor(): Int {
        return when (genRandomNum()) {
            1 -> R.color.blue_sky
            2 -> R.color.blue_ice
            3 -> R.color.black
            4 -> R.color.grey
            5 -> R.color.lime
            6 -> R.color.red_chili
            7 -> R.color.red_rust
            8 -> R.color.red_dark
            9 -> R.color.red
            else -> R.color.white
        }
    }

    private fun genRandomNum(): Int {
        return Random.nextInt(10) + 1
    }
}
