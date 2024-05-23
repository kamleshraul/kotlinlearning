package com.codekam.generics

fun main(){
    generics_with_list();
    generics_with_map();
}

// Generic type T
fun <T> List<T>.toBulletList():String {
    val separator = "\n -"
    return this.map { "$it" }
        .joinToString (separator=separator,prefix=separator,postfix="\n" )
}

fun generics_with_map() {
    println("\n Generics with Map")

    val map = mapOf(
        Pair("One",1),
        Pair("Two","II"),
        Pair("Three",3.0)
    )

    val one= map.get("One")
    //map.get(1) error
    //map[1] error as key is of type string
    println("Key:'One' values in map is $one")

    val valContainsE = map.keys
        .filter { it.contains("e") }
        .map { "Values for $it in map is ${map[it]}" }
    println("Value in map that contains e : ${valContainsE}")
}

fun generics_with_list() {
    println("Generics with list")
    val names:List<String> = listOf("Alice","Bob","Lolo","Jade","Ana")
    println("Names: $names")
    println("First Name: ${names.first()}")

    val things= mutableListOf<Any>(1,2)
    things.add("Steve")
    println("Things $things")

    println("Calling toBulletList")
    println(names.toBulletList())
}
