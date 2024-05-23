package com.codekam.oops

/*property which don't have any value when
* the class object is created , then mark
* that property with lateint*/

class Lamp{
    lateinit var bulb:LightBulb
}

fun main(){
    val lamp=Lamp()
    println("Lamp object created ")
    // following will gave error as bulb not initialized
    //println("Value of bulb ${lamp.bulb}")
    lamp.bulb= LightBulb()

    println("Value of bulb ${lamp.bulb}")
}