package com.codekam.extensions

open class Shape
class Rectangel:Shape()

// we now going to define extension function on above
// classes

fun Shape.getName() = "Shape"

fun Rectangel.getName() = "Rectangle"

/* getName() is extension function .
Extension function don't modify class they extends or add any member method in that
class. It only makes these extension function which defined outside of class callable
with dot notation on variable of that type
* */


fun printClassName(s:Shape){
    println(s.getName())
}

fun main(args:Array<String>){
    val shapeObj = Shape()
    val rectangleObj = Rectangel()

    printClassName(shapeObj)

    printClassName(rectangleObj)


    val shapeOutput = shapeObj.getName()
    println("Result of Calling getName() on shape object > $shapeOutput")

    val rectangleOutput = rectangleObj.getName()
    println("Result of Calling getName() on rectangle object > $rectangleOutput")

    /*Extension function resolved statically i.e. at compile time and not at runtime
    * i.e. Extension function get called on type on which it is defined and not on
    * type of object on which it is get called*/

    //in following example we store child object in rectangleObj in parent type shape
    val shapeObj1:Shape = rectangleObj;
    // when we called extension function getName() on shapeObj1 object it
    // calls function defined in Class Shape and not in actual object rectangleObj
    // so extension function always called on Receiver type  i.e. declared type of object
    // as in above example 'Shape' and not on Rectangle
    println(shapeObj1.getName())

}