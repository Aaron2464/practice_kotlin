package com.aaron.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.aaron.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aaron")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
//        setContentView(R.layout.activity_main)
        binding.btnDone.setOnClickListener { clickHandlerFunction(it) }

    }

    fun clickHandlerFunction(view: View) {
        binding.apply {
            myName?.nickName = nickname_text.text.toString()
        }
        if (editText.text != null) {
            nickname_text.text = editText.text
            editText.visibility = View.GONE
            nickname_text.visibility = View.VISIBLE
            view.visibility = View.GONE
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
