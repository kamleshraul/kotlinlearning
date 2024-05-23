package com.codekam.extensions

/*Behaviour of extension function in inheritance
and override
 */

open class Base

class Derived :Base()

open class BaseCaller{
    open fun Base.printFunctionInfo(){
        println("Base Extension Function in BaseCaller Class")
    }

    open fun Derived.printFunctionInfo(){
        println("Derived Extension Function in BaseCaller Class")
    }

    fun call(b:Base){
        b.printFunctionInfo()
    }
}

class DerivedCaller:BaseCaller(){
    override fun Base.printFunctionInfo(){
        println("Base Extension Function in DerivedCaller Class")
    }

    override fun Derived.printFunctionInfo(){
        println("Derived Extension Function in DerivedCaller Class")
    }
}

fun main(){
    val obj = BaseCaller()
    obj.call(Base())
    obj.call(Derived())

    /*when extension functions are override in child then
    * override function in child is considered when called with child object
    * i.e. Virtual - Dispatch Receiver Type is Child-Class in example it is DerivedCaller class
    * but Static - Extension Receiver Type  is Parent-Class in example it is BaseCaller class  */
    val objD:BaseCaller = DerivedCaller() // we made object type BaseCaller
    objD.call(Base()) // we passed Parent Class object so Base.printFunctionInfo() of DerivedCaller get called
    //even though objD Static Type is BaseCaller but compiler considered DerivedCaller which is actual object
    //assigned to it - so here Dispatcher Receiver Type is Virtual
    objD.call(Derived()) // we passed actual child class object but parent Base.printFunctionInfo() of derivedcaller
    //is called because compiler consider Base i.e parent class while invoking extension function

    /*So in case of override class, whenever extension function is called on object of child
    * extension functions overriden in child object are considered = Dispatch Receiver Type
    * but extension function get called according to Static Type Receiver Type i.e. Type of Object
    * being used i.e. in example call function considered type as Base so Base.printMethodInfo() get
    * executed*/
}