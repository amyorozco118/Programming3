package com.bignerdranch.android.programming1

import BBallModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.util.Log

private const val REQUEST_CODE_SECOND = 0
private const val BUTTON_PRESSED = "com.bignerdranch.android.programming1.button_pressed"
class MainFragment: Fragment() {

    private  val TAG = "MainFragment"
    var myBBallModel: BBallModel? =  BBallModel()

    private lateinit var main : MainActivity
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Fragment Started")

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        resetButton = view.findViewById(R.id.reset_button)
        scoreA = view.findViewById(R.id.scoreA)
        scoreB = view.findViewById(R.id.scoreB)

        threeButton = view.findViewById(R.id.three_pointsA)
        threeButtonB =view.findViewById(R.id.three_pointsB)

        twoButton = view.findViewById(R.id.two_pointsA)
        twoButtonB = view.findViewById(R.id.two_pointsB)

        ftButton = view.findViewById(R.id.free_throwA)
        ftButtonB = view.findViewById(R.id.free_throwB)
        infoButton = view.findViewById(R.id.info_button)

        //Programming 2 9/14
        displayButton = view.findViewById(R.id.display_button)
        saveButton = view.findViewById(R.id.save_button)


        if(savedInstanceState != null){
            myBBallModel!!.setScore(true,savedInstanceState.getInt(KEY_SCORE_A, 0) )
            myBBallModel!!.setScore(false, savedInstanceState.getInt(KEY_SCORE_B, 0))
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
//            Toast.makeText(applicationContext,"If a shot is successfully scored from outside of the three-point line, three points are awarded.\n" +
//                    "If a shot is successfully scored from inside of the three-point line, two points are awarded.\n" +
//                    "If a team is awarded a technical foul then they will receive between one and three free shots. Each shot scored will be awarded with one point.",
//                Toast.LENGTH_SHORT).show()

        }

        displayButton?.setOnClickListener{

        }
        saveButton?.setOnClickListener {
            val intent = SecondActivity.newIntent(this@MainFragment, savePressed)
            startActivityForResult(intent, REQUEST_CODE_SECOND)

            Toast.makeText(applicationContext, "Game Information Saved!", Toast.LENGTH_SHORT).show()
        }



        return view }

    fun updateScore(aBool : Boolean, value :Int ){

        myBBallModel!!.updateScore(aBool, value)
        if(aBool) {
            scoreA.setText(myBBallModel!!.getScore(aBool))

        }
        else{
            scoreB.setText(myBBallModel!!.getScore(aBool))
        }
    }





}