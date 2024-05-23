package com.codekam.functionalprograms.ch1

/*High order function that take another function as input
* or returns another function as output*/

// extension function times on Int
fun Int.times(fn:()->Unit){
    /*for(i in 1..this)
        fn()
     */
    //above code can be written like below

    (1..this).forEach{fn()}
}

fun main(){
    3.times{
        println("Hello")
    }
}