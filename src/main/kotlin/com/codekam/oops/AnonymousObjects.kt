package com.codekam.oops

interface Counts{
    fun studentCount():Int
    fun scientistCount():Int
}

// creating anonymous objects

val counter=object:Counts{
    override fun studentCount():Int = 10
    override fun scientistCount():Int=100
}

fun main(){
    println("StudentCount : ${counter.studentCount()}")
    println("StudentCount : ${counter.scientistCount()}")
}
