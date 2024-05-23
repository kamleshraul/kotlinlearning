package com.codekam.interfaceexample

enum class Direction{
    LEFT,RIGHT
}

interface DirectionalVehicle{
    fun accelerate()
    fun stop()
    fun turn(direction:Direction)
    fun description():String
}

interface OptionalDirectionalVehicle{
    fun turn(direction:Direction=Direction.LEFT)
}

class OptionalDirection:OptionalDirectionalVehicle{
    override fun turn(direction: Direction) {
        println("Direction You Passed $direction")
    }
}

interface SpaceVehicle{
    fun accelerate()
    //default method implementation
    fun stop(){
        println("Whoa, slow down!!")
    }
}

class LightFreight:SpaceVehicle{
    override fun accelerate() {
        println("LightFreight accelerate()")
    }
}

class StarShip:SpaceVehicle{
    override fun accelerate() {
        println("Starship Accelerated()")
    }

    // default method of interface
    // can be override
    override fun stop(){
        println("=== Starship Stop ====")
        super.stop() // interface default method call
        println("Starship override stop()")
    }
}

fun main() {
    val optionalDirection=OptionalDirection()
    /*Even though turn method required parameter in class
    * but interface defined default parameter value for
    * that , which is used in this case
    * */
    optionalDirection.turn()

    //default method implementation
    val lightFrieht=LightFreight()
    lightFrieht.stop()

    val starShip=StarShip()
    starShip.stop()
}