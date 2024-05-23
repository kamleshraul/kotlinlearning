package com.codekam.oops

class MyMath{
    companion object{

    }
}

class SomeOtherClass{
    fun MyMath.Companion.primFactor(value:Int):List<Int>{
        var remainingValue=value
        var testFactor=2
        val primes = mutableListOf<Int>()
        while(testFactor*testFactor <=remainingValue){
            if(remainingValue%testFactor ==0){
                primes.add(testFactor)
                remainingValue /=testFactor
            }else{
                testFactor+=1
            }
        }
        if(remainingValue>1)
            primes.add(remainingValue)

        return primes
    }

    fun calculatePrimeFactor(){
        val factors=MyMath.primFactor(81)
        println(factors)
    }
}

fun main() {
    val someClass=SomeOtherClass()
    someClass.calculatePrimeFactor()
}