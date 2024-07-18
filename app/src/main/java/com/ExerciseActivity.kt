package com

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.Constants
import com.example.a7minutesworkout.databinding.ActivityExerciseBinding
import java.util.ArrayList

class ExerciseActivity : AppCompatActivity() {

    private var binding : ActivityExerciseBinding?  = null

    private var restTimer : CountDownTimer? = null
    var restProgress =0

    private var ExerciseTimer : CountDownTimer? = null
    var ExerciseProgress =0

    var ExerciseList :  ArrayList<ExerciseModel>? = null
    var currentExercisePosition = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExerciseBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarExercise)

        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        ExerciseList = Constants.defaultExerciseList()

        binding?.toolbarExercise?.setNavigationOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

     setRestview()
    }
    private fun setRestview(){

        binding?.flRestView?.visibility = View.VISIBLE
        binding?.tvTitle?.visibility = View.VISIBLE
        binding?.tvExerciseName?.visibility = View.INVISIBLE
        binding?.ivImage?.visibility = View.INVISIBLE
        binding?.flExerciseView?.visibility = View.INVISIBLE

        binding?.tvUpcomingLabel?.visibility = View.VISIBLE
        binding?.tvUpcomingExerciseName?.visibility = View.VISIBLE

        if(restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }
        binding?.tvUpcomingExerciseName?.text = ExerciseList!![currentExercisePosition+1].getName()

        setRestProgressbar()

    }

    fun setUpExerciseView(){
        binding?.flRestView?.visibility = View.INVISIBLE
        binding?.tvTitle?.visibility = View.INVISIBLE
        binding?.tvUpcomingLabel?.visibility = View.INVISIBLE
        binding?.tvUpcomingExerciseName?.visibility = View.VISIBLE

        binding?.tvExerciseName?.visibility = View.VISIBLE
        binding?.ivImage?.visibility = View.VISIBLE
        binding?.flExerciseView?.visibility = View.VISIBLE

        if (ExerciseTimer != null){
            ExerciseTimer?.cancel()
            ExerciseProgress = 0
        }

        binding?.ivImage?.setImageResource(ExerciseList!![currentExercisePosition].getImage())
        binding?.tvExerciseName?.text = ExerciseList!![currentExercisePosition].getName()


        setExerciseProgressbar()

    }

    private fun setRestProgressbar(){
        binding?.progressBar?.progress = restProgress
        restTimer = object : CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                restProgress++
                binding?.progressBar?.progress = 10-restProgress
                binding?.tvTimer?.text = (10-restProgress).toString()
            }
            override fun onFinish() {
                currentExercisePosition++
             //   Toast.makeText(this@ExerciseActivity,"Exercise will be start",Toast.LENGTH_SHORT).show()
            setUpExerciseView()
            }
        }.start()
    }

    private fun setExerciseProgressbar(){
        binding?.progressBarExercise?.progress = ExerciseProgress
        ExerciseTimer = object : CountDownTimer(30000,1000){
            override fun onTick(p0: Long) {
                ExerciseProgress++
                binding?.progressBarExercise?.progress = 30-ExerciseProgress
                binding?.tvTimerExercise?.text = (30-ExerciseProgress).toString()
            }
            override fun onFinish() {
                if (currentExercisePosition<ExerciseList!!.size-1){
                    setRestview()
                }else{
                    Toast.makeText(this@ExerciseActivity,"Congratulations you have completed the 7 minutes workout",Toast.LENGTH_SHORT).show()
                }
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTimer !=null){
            restTimer?.cancel()
            restProgress = 0
        }

        if (ExerciseTimer != null){

            ExerciseTimer?.cancel()
            ExerciseProgress = 0
        }
        binding = null
    }
}