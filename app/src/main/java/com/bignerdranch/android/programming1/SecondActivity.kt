package com.bignerdranch.android.programming1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

const val SAVE_BUTTON_KEY = "com.bignerdranch.android.programming1.save_key"
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
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