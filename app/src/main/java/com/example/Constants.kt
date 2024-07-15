package com.example

import com.ExerciseModel
import com.example.a7minutesworkout.R

object Constants {

    fun defaultExerciseList() : ArrayList<ExerciseModel>{

        var ExerciseList = ArrayList<ExerciseModel>()

        var jumpingJacks = ExerciseModel(
            1,"JackPack",
            R.drawable.ic_jumping_jacks,
            false,false
        )
        var abdominal = ExerciseModel(
            2,"abdominal",
            R.drawable.ic_abdominal_crunch,
            false,false
        )
        var highKnees = ExerciseModel(
            3,"highKnees",
            R.drawable.ic_high_knees_running_in_place,
            false,false
        )
        var lunge = ExerciseModel(
            4,"lunge",
            R.drawable.ic_lunge,
            false,false
        )
        var plank = ExerciseModel(
            5,"plank",
            R.drawable.ic_plank,
            false,false
        )


        ExerciseList.add(jumpingJacks)





        return ExerciseList
    }
}