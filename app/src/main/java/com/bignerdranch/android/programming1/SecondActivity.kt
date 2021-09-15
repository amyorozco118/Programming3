package com.bignerdranch.android.programming1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

const val SAVE_BUTTON_KEY = "com.bignerdranch.android.programming1.save_key"
class SecondActivity : AppCompatActivity() {
    //cuteButton = findViewById(R.id.cute_button)

    /*
    cuteButton?.setOnClickListener {this
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
     */

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //scoreAVal = intent.getIntExtra()
       // scoreBVal = intent.getIntExtra()
    }

    companion object{
        fun newIntent(packageContext: Context, saveIsPressed:Boolean): Intent {
            return Intent(packageContext, SecondActivity::class.java)
                .apply{
                    putExtra(SAVE_BUTTON_KEY, saveIsPressed)
                }
        }
    }

    private fun setResultOfSave(savePressed:Boolean){
        val data = Intent().apply{
            putExtra(SAVE_BUTTON_KEY, savePressed)
        }
        setResult(Activity.RESULT_OK, data)
    }


}