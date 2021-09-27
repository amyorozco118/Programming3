package com.bignerdranch.android.programming1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

const val SAVE_BUTTON_KEY = "com.bignerdranch.android.programming1.save_key"
class SecondActivity : AppCompatActivity() {

    private lateinit var cuteButton : Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        cuteButton = findViewById(R.id.cute)

        cuteButton.setOnClickListener{
            cuteButton.isEnabled = false

            Toast.makeText(this@SecondActivity, "Cute Dog!", Toast.LENGTH_SHORT).show()
        }

    }

    companion object{
        fun newIntent(packageContext: MainActivity, saveIsPressed:Boolean): Intent {
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