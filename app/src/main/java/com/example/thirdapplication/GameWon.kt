package com.example.thirdapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView

class GameWon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_won)
        var message2=intent.getStringExtra("MESSAGE")?:null
        val text=findViewById<TextView>(R.id.message)
        val number=findViewById<TextView>(R.id.number)
        text.setText("$message2")
        if(message2!=null){
            var delimitor=" "
            var message=message2.split(delimitor)
            if(message[0]=="W"){
                text.setText("You Won the number is")
                number.setTextColor(Color.parseColor("#00FF00"))
                number.setText("${message[1]}")
            }
            else{
                text.setText("You Lost after 12 attempts\n the number is")
                number.setTextColor(Color.parseColor("#FF0000"))
                number.setText("${message[1]}")
            }

        }


    }
}