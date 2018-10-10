package com.kotlin.restaurant.restaurantorder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_order.*

class MainOrder : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_order)
    }

    fun order(view: View){
        var finalResult = getString(R.string.final_Order)
        val starter = starter_checkBox.isChecked
        val main = main_checkBox.isChecked
        if (!starter && !main)
            Toast.makeText(this, getString(R.string.message), Toast.LENGTH_SHORT).show()
        else {
            if (starter) finalResult += "\n * ${getString(R.string.starter)}"
            if (main) finalResult += "\n * ${getString(R.string.main)}"
        }
        finalOrder_textView.text = finalResult
    }
}

