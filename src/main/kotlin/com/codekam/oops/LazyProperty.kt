package com.codekam.oops

class Circle(var radius:Double=0.0){

    // this calculation is postponed till first access
    // only calculated once
    // cannot be var
    val pi:Double by lazy {
        ((4.0 * Math.atan(1.0/5.0)) - Math.atan(1.0/239.0))* 4.0
    }

    //every time calculated whenever accessed
    val circumference:Double
        get() = pi *Math.pow(radius,2.toDouble())
}

fun main(){
    val circle=Circle(10.toDouble())
    println("Circle circumference ${circle.circumference}")
}