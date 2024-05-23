package com.codekam.extensions


/* Extension function can be defined on nullable type also*/

fun Any?.toString():String {
    println("Common extension Function called")
    // null need to be defined as receiver object can be null
    // due to which error can be thrown to prevent that null check is important
    if(this == null) return "null"

    return toString()
}

class MyOwnClass

fun main(){

    var nullableVaraible:String? = null
    println("${nullableVaraible.toString()}")

    // if declared type to nullable type as in following case
    // then only our declared extension function defined on
    // nullable type is called
    val myownOBJ:MyOwnClass?  = MyOwnClass()
    println("${myownOBJ.toString()}")

    // as we haven't defined object type, our declared nullable extension
    //function not get called
    val myownOBJ2 = null
    println("${myownOBJ2.toString()}")
}