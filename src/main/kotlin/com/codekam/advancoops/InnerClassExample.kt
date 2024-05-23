package com.codekam.advancoops

class Car(val carName:String){

    // inner keyword necessary to have inner class
    // access to properties of owner class
    inner class Engine(val engineName:String){
        override fun toString(): String {
            return "$engineName in $carName"
        }
    }
}

fun main(){
    // instance creation of inner class
    val mazda=Car("MAZDA")
    val engine=mazda.Engine("rotatary")
    println("${engine}")
}