package com.codekam.interfaceexample

interface Vehicle{
   var something:String
    fun accelerate()
    fun stop()
}

//interface can inherit other interface
interface WheelVehicle:Vehicle{
    val numberOfWheels:Int
    val wheelSize:Double
}

class Unicycle:Vehicle {

    var peddling=false
    override var something: String=""

    override fun accelerate() {
        peddling=true
        println("Unicycle accelerated")
    }

    override fun stop() {
        peddling=false
        println("Unicycle stopped")
    }
}

class Bike:WheelVehicle{
    override val numberOfWheels: Int
        get() = 2
    override val wheelSize: Double
        get() = 45.25
    override var something: String=""
        get()= field
        set(value) {
            field=value
        }

    override fun accelerate() {
        println("Bike Accelerated")
    }

    override fun stop() {
        println("Bike stopped")
    }

}

fun main() {
    //val vehicle=Vehicle() cannot instantiate vehicle
    val vehicle=Unicycle()
    vehicle.accelerate()
    vehicle.stop()

    val bike:WheelVehicle=Bike()
    bike.accelerate()
    bike.stop()
}