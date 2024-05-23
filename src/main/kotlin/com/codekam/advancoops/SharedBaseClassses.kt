package com.codekam.advancoops

/*
* Use Subclasses : when we want to define what objects are
* Use Interfaces : when we want to share behavior i.e what objects can do
* */

open class Button{
    fun press() = println("Parent Button Class: press()")
}

class Image
// two different classes extends same parent class
class ImageButton(var image:String):Button()
class TextButton(var text:String):Button()

fun main(){
    val b1:Button=ImageButton(image="Image Path")
    val b2:Button=TextButton(text="TEXT BTN")

    b1.press()
    b2.press()
}