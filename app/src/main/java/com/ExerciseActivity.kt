package com

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a7minutesworkout.R
import com.example.a7minutesworkout.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {

    private var binding : ActivityExerciseBinding?  = null

    private var restTimer : CountDownTimer? = null
    var restProgress =0

    private var ExerciseTimer : CountDownTimer? = null
    var ExerciseProgress =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExerciseBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarExercise)

        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarExercise?.setNavigationOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
     setRestview()
    }
    fun setRestview(){
        if(restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }
        setRestProgressbar()

    }

    fun setExerciseView(){

        binding?.flProgressBar?.visibility = View.GONE
        binding?.tvTitle?.text = "Exercise Name"
        binding?.flExerciseView?.visibility = View.VISIBLE

        if (ExerciseTimer != null){

            ExerciseTimer?.cancel()
            ExerciseProgress = 0
        }
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
             //   Toast.makeText(this@ExerciseActivity,"Exercise will be start",Toast.LENGTH_SHORT).show()
            setExerciseView()
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
                Toast.makeText(this@ExerciseActivity,"Here now we will start the exercise",Toast.LENGTH_SHORT).show()
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