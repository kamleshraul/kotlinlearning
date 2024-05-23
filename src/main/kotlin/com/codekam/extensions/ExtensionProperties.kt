package com.codekam.extensions

class SampleProperties(var para1:Int=10,
                       var para2:Int=20,
                       private val para3:Int = 100){

    val sumOfPara:Int
        get() = para1+para2+para3
}

// extension property on class
val SampleProperties.doubleTheSum:Int
    get() = sumOfPara * 2

// extension properties behave similar to extension function
// as extension properties are not actually inserted into class
// due to which there is no backing field for extension properties
// we need to define it's behavior through getters and setter only

var SampleProperties.updatePara1:Int
    set(value) { para1= value}
    get() = para1

var SampleProperties.updatePara3:Int
    get() {
        println("para3 is Private, extension properties " +
                "cannot read private and protected properties")
        return -1
    }
    set(value) {
        println("para3 is Private, extension properties " +
                "cannot read private and protected properties")
        println("Cannot set $value for para3")
    }


fun main(){
    val obj = SampleProperties()
    println(obj.sumOfPara)

    println("Calling Extension Properties")
    println(obj.doubleTheSum)

    println("Original Para1 = ${obj.updatePara1}")
    obj.updatePara1 = 200
    println("Updated Para1 = ${obj.updatePara1}")
    println(obj.sumOfPara)

    println("Property trying to update Private member which is not possible")
    obj.updatePara3 = 20
    println(obj.updatePara3)
}