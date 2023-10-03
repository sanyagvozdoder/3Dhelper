package com.example.a3dhelper

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.isVisible
import com.example.a3dhelper.ui.theme._3DhelperTheme
import org.w3c.dom.Text


class MainActivity : ComponentActivity() {
    private lateinit var button_turn_over:Button
    private lateinit var link5:TextView
    private var number:Int = 1
    private lateinit var next_button:ImageButton
    private lateinit var previous_button:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dict: Map<Int, List<View?>> = mapOf(
            Pair(1, listOf(
                findViewById<View>(R.id.question1),
                findViewById<View>(R.id.answer1_text),
                findViewById<View>(R.id.answer1_image),
                null
            )),
            Pair(2, listOf(
                findViewById<View>(R.id.question2),
                findViewById<View>(R.id.answer21_image),
                findViewById<View>(R.id.answer22_image),
                findViewById<View>(R.id.answer23_image)
            )),
            Pair(3, listOf(
                findViewById<View>(R.id.question3),
                findViewById<View>(R.id.answer_image3),
                findViewById<View>(R.id.answer_text3),
                null
            )),

            Pair(4,listOf(
                findViewById<View>(R.id.question5),
                findViewById<View>(R.id.answer_link5),
                null,
                null
            ))
        )
        link5 = findViewById(R.id.answer_link5)
        link5.setMovementMethod(LinkMovementMethod.getInstance())
        button_turn_over = findViewById(R.id.turn_over_button)
        button_turn_over.setBackgroundColor(resources.getColor(android.R.color.transparent))
        button_turn_over.setOnClickListener{
            var question:View? = dict[number]?.get(0)
            var answer1:View? = dict[number]?.get(1)
            var answer2:View? = dict[number]?.get(2)
            var answer3:View? = dict[number]?.get(3)
            if (question!!.isVisible){
                question?.visibility = View.GONE
                answer1?.visibility = View.VISIBLE
                answer2?.visibility = View.VISIBLE
                answer3?.visibility = View.VISIBLE
            }
            else{
                question?.visibility = View.VISIBLE
                answer1?.visibility = View.GONE
                answer2?.visibility = View.GONE
                answer3?.visibility = View.GONE
            }
        }
        next_button = findViewById(R.id.button_next)
        next_button.setOnClickListener{
            number++
            if(number<=dict.size){
                var question_this:View? = dict[number]?.get(0)
                var question_prev:View? = dict[number-1]?.get(0)
                var answer1_prev:View? = dict[number-1]?.get(1)
                var answer2_prev:View? = dict[number-1]?.get(2)
                var answer3_prev:View? = dict[number-1]?.get(3)
                question_this?.visibility = View.VISIBLE
                question_prev?.visibility = View.GONE
                answer1_prev?.visibility = View.GONE
                answer2_prev?.visibility = View.GONE
                answer3_prev?.visibility = View.GONE
            }
            else{
                number = 1
                val prevnumber:Int = dict.size
                var question_this:View? = dict[number]?.get(0)
                var question_prev:View? = dict[prevnumber]?.get(0)
                var answer1_prev:View? = dict[prevnumber]?.get(1)
                var answer2_prev:View? = dict[prevnumber]?.get(2)
                var answer3_prev:View? = dict[prevnumber]?.get(3)
                question_this?.visibility = View.VISIBLE
                question_prev?.visibility = View.GONE
                answer1_prev?.visibility = View.GONE
                answer2_prev?.visibility = View.GONE
                answer3_prev?.visibility = View.GONE
            }
        }
        previous_button = findViewById(R.id.button_previous)
        previous_button.setOnClickListener{
            number--
            if(number!=0){
                var question_this:View? = dict[number]?.get(0)
                var question_prev:View? = dict[number+1]?.get(0)
                var answer1_prev:View? = dict[number+1]?.get(1)
                var answer2_prev:View? = dict[number+1]?.get(2)
                var answer3_prev:View? = dict[number+1]?.get(3)
                question_this?.visibility = View.VISIBLE
                question_prev?.visibility = View.GONE
                answer1_prev?.visibility = View.GONE
                answer2_prev?.visibility = View.GONE
                answer3_prev?.visibility = View.GONE
            }
            else{
                number = dict.size
                val prevnumber:Int = 1
                var question_this:View? = dict[number]?.get(0)
                var question_prev:View? = dict[prevnumber]?.get(0)
                var answer1_prev:View? = dict[prevnumber]?.get(1)
                var answer2_prev:View? = dict[prevnumber]?.get(2)
                var answer3_prev:View? = dict[prevnumber]?.get(3)
                question_this?.visibility = View.VISIBLE
                question_prev?.visibility = View.GONE
                answer1_prev?.visibility = View.GONE
                answer2_prev?.visibility = View.GONE
                answer3_prev?.visibility = View.GONE
            }
        }
    }
}

