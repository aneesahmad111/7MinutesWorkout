package com

class ExerciseModel(
    var id : Int,
    var name : String,
    var image : Int,
    var isCompleted : Boolean,
    var isSelected : Boolean
){
    fun getId():Int{
        return id
    }
    fun setId( id : Int){
        this.id = id
    }
    fun getName(): String{
        return name
    }
    fun setName(name : String){
        this.name = name
    }
    fun getImage() : Int{
        return  image
    }
    fun setImage(image : Int){
        this.image = image
    }
    fun setIsCompleted(IsCompleted : Boolean){
        this.isCompleted = IsCompleted
    }
    fun getIsCompleted(): Boolean{
        return isCompleted
    }
    fun setIsSelected(IsSelected : Boolean){
        this.isSelected = IsSelected
    }
    fun getIsSelected(): Boolean{
        return isSelected
    }


}