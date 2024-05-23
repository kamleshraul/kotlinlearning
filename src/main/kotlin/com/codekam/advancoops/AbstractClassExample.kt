package com.codekam.advancoops

//abstract class is by default open
abstract class Mammal(val birthDate:String){
    abstract fun consumeFood()
}

class Human(birthDate: String):Mammal(birthDate){
    override fun consumeFood() {
        println("Human consume food")
    }

    fun createBirthCertificate(){
        println("Birth Certificate for date "+birthDate)
    }
}

fun main() {
    // error as abstract class cannot be initiated
    //val mammal=Mammal(birthDate = "1/1/2020")
    val human=Human(birthDate = "2/2/2022")
    human.consumeFood()
    human.createBirthCertificate()
}