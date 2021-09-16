package com.bignerdranch.android.programming1
import BBallModel
import android.app.Activity
import android.content.Intent
import android.graphics.ColorSpace
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/*

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    trueButton = findViewById(R.id.true_button)
    falseButton = findViewById(R.id.false_button)
    trueButton.setOnClickListener { view: View ->
        // Do something in response to the click here
    }
}
 */

//Project 2 vars 9/15
private const val REQUEST_CODE_SECOND = 0
private const val BUTTON_PRESSED = "com.bignerdranch.android.programming1.button_pressed"


class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment == null) {
            val fragment = MainFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }

//        //Programming 2 9/14
//        displayButton = findViewById(R.id.display_button)
//        saveButton = findViewById(R.id.save_button)
//        savePressed = intent.getBooleanExtra(BUTTON_PRESSED, false)
//
//
////        if(savedInstanceState != null){
////            myBBallModel!!.setScore(true,savedInstanceState.getInt(KEY_SCORE_A, 0) )
////            myBBallModel!!.setScore(false, savedInstanceState.getInt(KEY_SCORE_B, 0))
////            updateScore(true, 0)
////            updateScore(false, 0)
////        }
//
////        resetButton?.setOnClickListener {this
////            myBBallModel!!.resetScore()
////            updateScore(true, 0)
////            updateScore(false, 0)
////        }
////
////        threeButton?.setOnClickListener {
////            updateScore(true, 3)
////
////        }
////        threeButtonB?.setOnClickListener {
////            updateScore(false, 3)
////        }
////
////        twoButton?.setOnClickListener {
////            updateScore(true, 2)
////        }
////
////        twoButtonB?.setOnClickListener {
////            updateScore(false, 2)
////        }
////
////        ftButton?.setOnClickListener {
////            updateScore(true, 1)
////
////        }
////        ftButtonB?.setOnClickListener {
////            updateScore(false, 1)
////        }
////
////        infoButton?.setOnClickListener{
////            Toast.makeText(applicationContext,"If a shot is successfully scored from outside of the three-point line, three points are awarded.\n" +
////                    "If a shot is successfully scored from inside of the three-point line, two points are awarded.\n" +
////                    "If a team is awarded a technical foul then they will receive between one and three free shots. Each shot scored will be awarded with one point.",Toast.LENGTH_SHORT).show()
////
////        }
//
//        //Programming 2 9/14
//
//        displayButton?.setOnClickListener{
//
//        }
//        saveButton?.setOnClickListener {
//            val intent = SecondActivity.newIntent(this@MainActivity, savePressed)
//            startActivityForResult(intent, REQUEST_CODE_SECOND)
//
//            Toast.makeText(this, "Game Information Saved!", Toast.LENGTH_SHORT).show()
//        }
//    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }



}