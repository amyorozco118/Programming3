import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.programming1.R

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

private const val TAG = "BBallViewModel"

open class BBallModel : ViewModel() {
    var scoreA = 0
    var scoreB = 0
    var savePressed = false
    init{


    }

     fun updateScore(Abool : Boolean, value: Int){
        if(Abool){
            scoreA +=value
        }
         else{
             scoreB+=value
        }

    }



    fun resetScore(){
        scoreA = 0
        scoreB = 0
    }

    fun getScore(aBool : Boolean): String{
        if(aBool){
            return scoreA.toString()
        }
        else{
            return scoreB.toString()
        }


    }

    fun setScore(aBool : Boolean, value : Int){
        if(aBool){
            scoreA = value
        }
        else{
            scoreB = value
        }

    }

    init {
        Log.d(TAG, "ViewModel instance created")
    }



}