package com.example

import com.ExerciseModel
import com.example.a7minutesworkout.R

object Constants {

    fun defaultExerciseList() : ArrayList<ExerciseModel>{

        var ExerciseList = ArrayList<ExerciseModel>()

        var jumpingJacks = ExerciseModel(
            1,"Jack Pack",
            R.drawable.ic_jumping_jacks,
            false,false
        )
        ExerciseList.add(jumpingJacks)

        var abdominalCrunch = ExerciseModel(
            2,"abdominal crunch",
            R.drawable.ic_abdominal_crunch,
            false,false
        )

        ExerciseList.add(abdominalCrunch)

        var highKneesRunningInPlace = ExerciseModel(
            3,"high Knees running in place",
            R.drawable.ic_high_knees_running_in_place,
            false,false
        )
        ExerciseList.add(highKneesRunningInPlace)

        var lunge = ExerciseModel(
            4,"lunge",
            R.drawable.ic_lunge,
            false,false
        )
        ExerciseList.add(lunge)

        var plank = ExerciseModel(
            5,"plank",
            R.drawable.ic_plank,
            false,false
        )
        ExerciseList.add(plank)

        var pushUp = ExerciseModel(
            6,"push up",
            R.drawable.ic_push_up,
            false,false
        )
        ExerciseList.add(pushUp)

        var pushUpAndRotation = ExerciseModel(
            7,"push up and rotation",
            R.drawable.ic_push_up_and_rotation,
            false,false
        )
        ExerciseList.add(pushUpAndRotation)

        var sidePlank = ExerciseModel(
            8,"side plank",
            R.drawable.ic_side_plank,
            false,false
        )
        ExerciseList.add(sidePlank)

        var squat = ExerciseModel(
            9,"squat",
            R.drawable.ic_squat,
            false,false
        )
        ExerciseList.add(squat)

        var stepUpOntoChair = ExerciseModel(
            10,"step up onto chair",
            R.drawable.ic_step_up_onto_chair,
            false,false
        )
        ExerciseList.add(stepUpOntoChair)

        var tricepsDipOnChair = ExerciseModel(
            11,"triceps dip on chair",
            R.drawable.ic_triceps_dip_on_chair,
            false,false
        )
        ExerciseList.add(tricepsDipOnChair)

        var wallSit = ExerciseModel(
            12,"wall sit",
            R.drawable.ic_wall_sit,
            false,false
        )
        ExerciseList.add(wallSit)







        return ExerciseList
    }
}