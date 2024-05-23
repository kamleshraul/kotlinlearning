package com.codekam.advancoops

// Sealed class limit which classes can inherit this class
// Sealed classes are abstract by default and cannot be initiated

sealed class Shape{
    class Circle(val radius:Int):Shape()
    class Square(val sideLength:Int):Shape()

    fun size(shape:Shape):Int{
        return when(shape){
            is Shape.Circle -> shape.radius
            is Shape.Square -> shape.sideLength
            else -> 0
        }
    }
}



fun main(){
    // sealed classes cannot create object
    //val shape=Shape()

//    val square:Shape=Square(10)
//    val square2:Shape=Square(10)
//    println("sqaure ${square} ${square2}")

    val circle1=Shape.Circle(4)
    val circle2=Shape.Circle(10)
}