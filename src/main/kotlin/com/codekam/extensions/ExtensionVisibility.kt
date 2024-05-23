package com.codekam.extensions

/* visibility like private, protected etc. behave
similarly for extension function as with any other methods
 */

class SampleVisibility

class VisiblityExtensions(val par1:Int=10,
                          private val par2:Int=100,
                          protected val par3:Int=1000){

    fun SampleVisibility.fun1(){
        /*Extension function defined inside of a class can access
        * all members of class regardless of whether they are private or protected*/
        println("fun1 extension defined inside of class can access")
        println("Public Variable par1: $par1")
        println("Private Variable par2: $par2")
        println("Protected Variable par3: $par3")
    }

    fun call(sample:SampleVisibility){
        sample.fun1()
    }

}

fun VisiblityExtensions.fun2() {
    /*Extension function defined outside of a class can not access
    * all members of class only public is allowed*/
    println("fun2 extension defined outside of class can access")
    println("Public Variable par1: $par1")
    println("Cannot access Private Variable par2")
    println("Cannot access Protected Variable par3")
}

fun main(){
    val obj = VisiblityExtensions()
    obj.call(SampleVisibility())
    // fun2 is extension function of VisibilityExtension class
    // defined outside of class
    obj.fun2()
}