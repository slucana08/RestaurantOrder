package com.kotlin.restaurant.restaurantorder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {

    var starter: String? = null
    var main: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        starter_RadioGroup.visibility = View.GONE
        main_RadioGroup.visibility = View.GONE
        starter = ""
        main = ""
        accept_Button.setOnClickListener {
            var finalMenu = getString(R.string.final_Order)
            if (starter != "") finalMenu += "\n${getString(R.string.starter) + ": " + starter}"
            if (main != "") finalMenu += "\n${getString(R.string.main_course) + ": " + main}"
            if (finalMenu == getString(R.string.final_Order))
                Toast.makeText(this, getString(R.string.message), Toast.LENGTH_LONG).show()
            menu_order_textView.text = finalMenu
        }
        starter_checkBox.setOnClickListener {
            if (starter_checkBox.isChecked) {
                starter_RadioGroup.visibility = View.VISIBLE
            } else {
                starter_RadioGroup.visibility = View.GONE
                starter_RadioGroup.clearCheck()
                starter = ""
            }
        }
        main_checkBox.setOnClickListener {
            if (main_checkBox.isChecked) {
                main_RadioGroup.visibility = View.VISIBLE
            } else {
                main_RadioGroup.visibility = View.GONE
                main_RadioGroup.clearCheck()
                main = ""
            }
        }
    }

    fun orderSelected(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.starter1_RadioButton -> {
                    if (checked) starter = getString(R.string.starter1)
                }
                R.id.starter2_RadioButton -> {
                    if (checked) starter = getString(R.string.starter2)
                }
                R.id.starter3_RadioButton -> {
                    if (checked) starter = getString(R.string.starter3)
                }
                R.id.main1_RadioButton -> {
                    if (checked) main = getString(R.string.main1)
                }
                R.id.main2_RadioButton -> {
                    if (checked) main = getString(R.string.main2)
                }
                R.id.main3_RadioButton -> {
                    if (checked) main = getString(R.string.main3)
                }
            }
        }
    }
}
