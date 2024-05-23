package com.codekam.oops

import kotlin.math.roundToInt

class Car(val make:String, val color:String)

// properties of class can also be set up with
// custom accessors => getters and setters
// properties supplied in class primary constructor
// use default implementation of accessors to store
// data in backing field

class Contact(var fullName:String, var emailAddress:String)
// default values
class Contact3(var fullName:String, var emailAddress:String,var type:String="Friend")

//Property Initializer
class Person(val firstName:String,val lastName:String){
    /*Property Initialized at property declaration only inside
    * class body*/
    var fullName:String="${firstName} ${lastName}"
}

class Address{
    var address1:String
    var address2:String?=null
    var city:String=""
    var state:String

    // properties values can also be set in init block
    init{
        address1=""
        state=""
    }
}

//custom getter and setters
class TV(var height:Double,var width:Double){
    val diagonal:Int
        get(){
            var result= Math.sqrt(height*height + width*width)
            return result.roundToInt()
        }
    /*If Property has custom setter then it must be
    * defined with var */
    var tvType:String=""
        get(){
            return field
        }
        set(value) {
            field=value
        }

    /*Setters generally don't have place to store values
    * the setter usually set one or more other related
    * properties of a class*/
    var isTvSquare:Boolean
        get(){
            return height==width
        }
        set(value){
            if(value)
                height=width
        }
}

fun main(){
    val contact=Contact(fullName = "Grace Murray", emailAddress = "grace@navi.mil")
    val name=contact.fullName
    val email=contact.emailAddress

    val contact3=Contact3(fullName="Grace Hoper",emailAddress="hoper@liv.uk")
    println("${contact3.fullName} , ${contact3.emailAddress},${contact3.type}")

    val address= Address()
    println("Following values initialize in side init block")
    println("${address.address1} ${address.address2} ${address.city} ${address.state}")

    //accessing custom getters
    val tv=TV(height = 53.93, width = 95.87).apply { tvType="Plasma" }
    println("Diagonal of TV : ${tv.diagonal} ${tv.tvType}")
}