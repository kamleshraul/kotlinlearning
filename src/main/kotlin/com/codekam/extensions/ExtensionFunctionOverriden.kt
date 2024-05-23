package com.codekam.extensions

class Example{
    fun printFunctionType() {
        println("Example Class Method")
    }
}

fun Example.printFunctionType() = println("Extension Function Defined on Example class")

fun Example.printFunctionType(arg:String)= println("Extension Function Defined on Example class with arg $arg")

/* If extension function defined on a class with same signature as class
then class member method always wins, extension function in this case
ignored

If extension function has same name but different signature than class member function
then extension function is considered
* */

fun main(){

    val exampleOBJ = Example()
    // extension function defined on class Example is ignored in following example
    exampleOBJ.printFunctionType()

    // extension function defined on class with one argument is considered
    // as it's signature is different than class member function
    exampleOBJ.printFunctionType("SomeArgument")
}
