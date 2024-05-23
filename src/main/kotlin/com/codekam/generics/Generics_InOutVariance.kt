package com.codekam.generics

fun main() {
    var ints:List<Int> = listOf<Int>(10,20,40)
    var numbers:List<Number> = listOf<Number>(100,200,300)

    println("List Of Integers $ints")
    println("List Of Numbers $numbers")

    numbers=ints
    println("After updating numbers are $numbers")

    var anotherInts:List<Int> = listOf<Int>(11,22,33)
    var anotherNumbers:List<Number> = listOf<Number>(111,222,333,444)
    println("Trying to Assign Numbers To Int")
    //anotherInts=anotherNumbers error

    var mutableIntList:MutableList<Int> = mutableListOf<Int>(1,2,3)
    var mutableNumberList= mutableListOf<Number>(11,22,33)
    //mutableIntList=mutableNumberList
    //mutableNumberList=mutableIntList

}