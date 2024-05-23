package com.codekam.oops

import kotlin.properties.Delegates

class DelegatedLevel(val id:Int,var boss:String) {
    companion object{
        var highestLevel=1
    }

    var unlocked:Boolean by Delegates.observable(false){
        _,old,new -> if(old!=new){
            highestLevel= highestLevel+1
            println("Unlocked is updated from $old to $new")
            println("Updating highestLevel : $highestLevel")
        }

    }
}

fun main(){
    val delegatedLevel1=DelegatedLevel(id=10,boss="Chameleaon")
    val delegatedLevel2=DelegatedLevel(id=20,boss="Squid")

    println("Delegate Level " +
            "{id:${delegatedLevel1.id}" +
            ", boss:${delegatedLevel1.boss}" +
            ", unlocked:${delegatedLevel1.unlocked}" +
            ", highestLevel:${DelegatedLevel.highestLevel}}")

    println("Now updating unlocked to true")
    delegatedLevel1.unlocked=true
    println("Delegate Level " +
            "{id:${delegatedLevel1.id}" +
            ", boss:${delegatedLevel1.boss}" +
            ", unlocked:${delegatedLevel1.unlocked}" +
            ", highestLevel:${DelegatedLevel.highestLevel}}")

    println("Now updating unlocked to false")
    delegatedLevel1.unlocked=false
    println("Delegate Level " +
            "{id:${delegatedLevel1.id}" +
            ", boss:${delegatedLevel1.boss}" +
            ", unlocked:${delegatedLevel1.unlocked}" +
            ", highestLevel:${DelegatedLevel.highestLevel}}")


}