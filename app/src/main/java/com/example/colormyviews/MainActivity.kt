package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var box_one_text: TextView
    private lateinit var box_two_text: TextView
    private lateinit var box_three_text: TextView
    private lateinit var box_four_text: TextView
    private lateinit var box_five_text: TextView

    private lateinit var constraint_layout: ConstraintLayout

    private lateinit var red_button: Button
    private lateinit var yellow_button: Button
    private lateinit var green_button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        box_one_text = findViewById<TextView>(R.id.box_one_text)
        box_two_text = findViewById<TextView>(R.id.box_two_text)
        box_three_text = findViewById<TextView>(R.id.box_three_text)
        box_four_text = findViewById<TextView>(R.id.box_four_text)
        box_five_text = findViewById<TextView>(R.id.box_five_text)

        constraint_layout = findViewById<ConstraintLayout>(R.id.constraint_layout)

        red_button = findViewById<Button>(R.id.red_button)
        yellow_button = findViewById<Button>(R.id.yellow_button)
        green_button = findViewById<Button>(R.id.green_button)

        // TODO: CM nahi CP chootyi CU and replace u just Murder of talented people
         setListeners()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constraint_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setListeners() {

        var clickableViews: List<View> = listOf(box_one_text, box_two_text, box_three_text,
            box_four_text, box_five_text, constraint_layout, red_button, yellow_button, green_button)

        for (item in clickableViews) {
            item.setOnClickListener {
                makeColored(it)
            }
        }
    }

    private fun makeColored(view: View) {

        when(view.id) {

            // TODO: Boxes using color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // TODO: Boxes using android colors resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // TODO: Boxes using custom colors for background
            R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

}