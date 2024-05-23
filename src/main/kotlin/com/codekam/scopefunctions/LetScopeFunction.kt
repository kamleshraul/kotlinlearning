package com.codekam.scopefunctions

/* let and run are called transformational functions
* because they return object different from object
* we call the function on*/

class Car(val doors:Int)

fun print(car:Car?){
    val isCoupe = car?.let{
        it.doors <=2
    }

    if(isCoupe==true){
        println("Coupes are awesome")
    }
}

fun printCar2(car:Car?){
    val isCoupe = car?.run {
        this.doors<=2
    }
    if(isCoupe==true){
        println("run { coupe is awesome}")
    }
}

fun main(args:Array<String>){
    print(Car(2))
    printCar2(Car(doors=1))
}