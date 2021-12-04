package com.example.thirdapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import java.lang.Exception
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val click=findViewById<Button>(R.id.button)
        val guess=findViewById<TextInputLayout>(R.id.number)
        var view=findViewById<TextView>(R.id.text1)
        val num=Random.nextInt(0,1000)
        click.setOnClickListener{
            val guess1=guess.editText?.text?.toString()
            try {
                view.setText("")
                val guess2 = if (guess1.isNullOrEmpty()) 0
                else guess1.toInt()
                if(guess2==num){
                    view.text="You are right"
                }
                else if(guess2<num){
                    view.text="No :) the number is bigger"
                }
                else
                    view.text="No :) the number is smaller"

            }
            catch (e:Exception){
               view.setText("Please Enter a number")
            }

        }
    }
}