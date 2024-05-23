package com.codekam.advancoops

open class Mathematics constructor(val operation:String){

    constructor():this("operation"){
        println("secondary constructor with No arg")
    }

    constructor(someNumber:Int,operation:String):this(operation){
        println("secondary constructor with 2 Argument")
    }
}

class Algebra2(operation: String) : Mathematics(operation){
    constructor():this(""){
        println("Algebra2 secondary constructor")
    }

    constructor(num:Int,str:String):this(str){

    }
}

open class Shape1{
    constructor(size:Int)
    constructor(size:Int,color:String):this(size)
}

class Circle1: Shape1 {
    constructor(radius:Int):super(radius)
    constructor(radius: Int,color:String):super(radius,color)
}

fun main() {
    val mathematics=Mathematics()
    println(mathematics.operation)
    val mathematicsAdd=Mathematics("Addition")
    println(mathematicsAdd.operation)
    val mathematicsMinus=Mathematics(10,"Subtractions")
    println(mathematicsMinus.operation)

}

