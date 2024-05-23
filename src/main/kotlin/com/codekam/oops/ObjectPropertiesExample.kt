package com.codekam.oops

class Level(val id:Int,var boss:String,var unlocked:Boolean){
    companion object{
        //companion object property is like static fields but not exactly
        var highestLevel=1
        // to behave property as static field use @jvmstatic
        @JvmStatic
        var randomLevel=23
    }
}

fun main(){
    val level1=Level(id=1,boss="Chameleon", unlocked = false)
    val level2=Level(id=2,boss="Squid", unlocked = true)
    val level3=Level(id=3,boss="Chupacabra", unlocked = true)

    //accessing companion objects value
    //cannot access through object i.e instance variable
    //println(level2.highestLevel)
    println("Highest Level ${Level.highestLevel}")
    println("Random Level ${Level.randomLevel}")
}