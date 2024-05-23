package com.codekam.extensions

/*Extension functions/properties can be defined on companion object of class also
* */

class MyClassCompanion{
    companion object{}
}

//defining extension function and property on class

fun MyClassCompanion.printMessage() =
    println("PrintMessage from MyClassCompanion Extension function")

val MyClassCompanion.message
    get() = "MyClassCompanion MSG"

// defining extension function & property on companion of class

fun MyClassCompanion.Companion.printMessage() =
    println("PrintMessage from Companion Object")

val MyClassCompanion.Companion.msg
    get() = "Companion MSG"


fun main(){
    println("Printing out extension function and property")
    val obj = MyClassCompanion()
    obj.printMessage()
    obj.message.also { println(it) }

    println("Printing out extension function and property")
    MyClassCompanion.printMessage()
    MyClassCompanion.msg.let { println(it) }
}