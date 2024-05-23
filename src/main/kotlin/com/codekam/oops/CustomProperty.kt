package com.codekam.oops

import com.codekam.oops.ExtenstionProperty.Companion.diameter
import com.codekam.oops.ExtenstionProperty.Companion.displayDiameter

class ExtenstionProperty{

    companion object{
        /*Extension property is property which defined outside of
        * class with class name as we may not able to modify
        * definition of class*/
        val Circle.diameter:Double
            get()=radius*2

        // extension function
        fun Circle.displayDiameter():Unit {
            println("Diameter of cicle is ${diameter}")
        }
    }

}
fun main(){

   val circle= Circle(15.toDouble())
   println("Circle with radius:${circle.radius} and diameter ${circle.diameter}")
    println("Calling extension function")
    circle.displayDiameter()
}