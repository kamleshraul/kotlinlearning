package com.codekam.interfaceexample

interface VehicleProperties{
    val weight:Int //abstract
    val name:String
        get() = "Vehicle"
}

class Car:VehicleProperties{
    override val weight: Int=1000
}

class Tank:VehicleProperties{
    override val weight: Int
        get() = 10000

    override val name:String
        get() = "Tank"
}

fun main() {
    val tank:VehicleProperties=Tank()
    println("${tank.name} has ${tank.weight} weight")
}