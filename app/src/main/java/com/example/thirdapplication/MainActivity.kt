package com.example.thirdapplication

import android.content.Intent
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
        var view2=findViewById<TextView>(R.id.view2)
        val num=Random.nextInt(1,1000)
        view2.setText("0/12")
        var count=1
        click.setOnClickListener{
            view.setText("")
            val guess1=guess.editText?.text?.toString()
            try {
                var guess2= if(guess1.isNullOrEmpty()) -1
                            else guess1.toInt()
                if(count<=12) {
                    if(guess2!=-1) {
                        if (guess2 == num) {
                            var message = "W " + num
                            val intent = Intent(this, GameWon::class.java).apply {
                                putExtra("MESSAGE", message)
                            }
                            startActivity(intent)
                            view.text = "You are right"
                        } else if (guess2 < num) {
                            view.text = "No :) the number is bigger"
                        } else
                            view.text = "No :) the number is smaller"
                        view2.setText("$count/12")
                        count++
                    }
                    else
                        view.setText("Please Enter a number")
                }
                else
                {
                    var message= "L "+num
                    val intent=Intent(this,GameWon::class.java).apply{
                      putExtra("MESSAGE",message)
                  }

                  startActivity(intent)
                }
            }
            catch (e:Exception){
               view.setText("Please Enter a number")
            }

        }
    }
}