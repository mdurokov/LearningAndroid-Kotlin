package com.orqa.fpv.kotlinbootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage1 : ImageView;
    lateinit var diceImage2 : ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val btnRoll : Button = findViewById(R.id.btn_roll);
        val btnClear : Button = findViewById(R.id.btn_clear);
        diceImage1 = findViewById(R.id.imageview_dice1);
        diceImage2 = findViewById(R.id.imageview_dice2);
        btnRoll.setOnClickListener{rollDice();}
        btnClear.setOnClickListener{clear();}
    }

    private fun clear() {
        imageview_dice1.setImageResource(R.drawable.empty_dice);
        imageview_dice2.setImageResource(R.drawable.empty_dice);

    }

    fun rollDice() {
        imageview_dice1.setImageResource(randNum());
        imageview_dice2.setImageResource(randNum());
    }

    private fun randNum(): Int{
        return when(Random.nextInt(6) + 1) {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
    }
}
