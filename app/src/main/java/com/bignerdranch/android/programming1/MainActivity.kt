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

    var myBBallModel: BBallModel? =  BBallModel()

    private lateinit var threeButton: Button
    private lateinit var twoButton: Button
    private lateinit var ftButton: Button

    private lateinit var threeButtonB: Button
    private lateinit var twoButtonB: Button
    private lateinit var ftButtonB: Button

    private lateinit var resetButton: Button
    private lateinit var scoreA : TextView
    private lateinit var scoreB : TextView

    private lateinit var infoButton : Button
    private  val KEY_SCORE_A = "bundle_score_a"
    private  val KEY_SCORE_B = "bundle_score_b"
    private var savePressed = false

    //Project 2 Variables - 9/14
    private lateinit var displayButton : Button
    private lateinit var saveButton : Button


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_SCORE_A, myBBallModel!!.scoreA )
        outState.putInt(KEY_SCORE_B, myBBallModel!!.scoreB)
        super.onSaveInstanceState(outState)

    }

    //testing adding a comment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)

        resetButton = findViewById(R.id.reset_button)
        scoreA = findViewById(R.id.scoreA)
        scoreB = findViewById(R.id.scoreB)

        threeButton =findViewById(R.id.three_pointsA)
        threeButtonB =findViewById(R.id.three_pointsB)

        twoButton = findViewById(R.id.two_pointsA)
        twoButtonB = findViewById(R.id.two_pointsB)

        ftButton = findViewById(R.id.free_throwA)
        ftButtonB = findViewById(R.id.free_throwB)
        infoButton = findViewById(R.id.info_button)

        //Programming 2 9/14
        displayButton = findViewById(R.id.info_button)
        saveButton = findViewById(R.id.info_button)
        savePressed = intent.getBooleanExtra(BUTTON_PRESSED, false)


        if(savedInstanceState != null){
            myBBallModel!!.setScore(true,savedInstanceState.getInt(KEY_SCORE_A, 0) )
            myBBallModel!!.setScore(false, savedInstanceState.getInt(KEY_SCORE_B, 0))

//            scoreA.setText(savedInstanceState.getInt(KEY_SCORE_A, 0))
//            scoreB.setText(savedInstanceState.getInt(KEY_SCORE_B, 0))
            updateScore(true, 0)
            updateScore(false, 0)
        }

        resetButton?.setOnClickListener {this
            myBBallModel!!.resetScore()
            updateScore(true, 0)
            updateScore(false, 0)
        }

        threeButton?.setOnClickListener {
            updateScore(true, 3)

        }
        threeButtonB?.setOnClickListener {
            updateScore(false, 3)
        }

        twoButton?.setOnClickListener {
            updateScore(true, 2)
        }

        twoButtonB?.setOnClickListener {
            updateScore(false, 2)
        }

        ftButton?.setOnClickListener {
            updateScore(true, 1)

        }
        ftButtonB?.setOnClickListener {
            updateScore(false, 1)
        }

        infoButton?.setOnClickListener{
            Toast.makeText(applicationContext,"If a shot is successfully scored from outside of the three-point line, three points are awarded.\n" +
                    "If a shot is successfully scored from inside of the three-point line, two points are awarded.\n" +
                    "If a team is awarded a technical foul then they will receive between one and three free shots. Each shot scored will be awarded with one point.",Toast.LENGTH_SHORT).show()

        }

        //Programming 2 9/14

        displayButton?.setOnClickListener{

        }
        saveButton?.setOnClickListener {
            val intent = SecondActivity.newIntent(this@MainActivity, savePressed)
            startActivityForResult(intent, REQUEST_CODE_SECOND)

            Toast.makeText(this, "Game Information Saved!", Toast.LENGTH_SHORT).show()
        }
    }

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

    fun updateScore(aBool : Boolean, value :Int ){

        myBBallModel!!.updateScore(aBool, value)
        if(aBool) {
            scoreA.setText(myBBallModel!!.getScore(aBool))

            }
        else{
            scoreB.setText(myBBallModel!!.getScore(aBool))
            }
    }

    //Programming 2
    override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent?){
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode != Activity.RESULT_OK){
            return
        }

        if(requestCode == REQUEST_CODE_SECOND){
            myBBallModel?.savePressed = data?.getBooleanExtra(SAVE_BUTTON_KEY, false) ?: false
        }
    }
}