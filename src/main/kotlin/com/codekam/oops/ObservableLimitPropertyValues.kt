package com.codekam.oops

import kotlin.math.max
import kotlin.properties.Delegates

class LightBulb{
    companion object{
        const val maxCurrent=40
    }

    // delegated properties can't have getters and setters
    var current by Delegates.vetoable(0){
        _,_,new-> if(new> maxCurrent){
            println("Current it too high ")
            false
        }else {
            true
        }
    }
}

fun main(){
    val bulb=LightBulb()
    bulb.current=20
    println("Bulb Voltage : ${bulb.current}")

    bulb.current=41
    println("Bulb Voltage : ${bulb.current}")
}