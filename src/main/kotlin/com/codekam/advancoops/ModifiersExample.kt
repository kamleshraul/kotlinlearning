package com.codekam.advancoops

/*
* public    - visible everywhere
* private   - visible only within class or in same file for top level functions
* protected - visible within subclasses for class hierarchy
* internal - visible only within same module
* */

data class Privilege(val id:Int, val name:String)

open class User(val username:String
                , private val id:String
                , protected var age:Int)

class PrivilegeUser(username:String,id:String,age:Int):User(username,id,age){

    private val privileges= mutableListOf<Privilege>()

    fun addPrivilege(privilege:Privilege){
        privileges.add(privilege)
    }

    fun hasPrivilege(privilege: Privilege):Boolean{
        return privileges.contains(privilege)
    }

    fun about():String{
        // As id is private member of super class
        // it is not accessible in child class
        //return "$username $id $age" error
        return "$username $age"
    }
}

fun main(){
    val privilegeUser = PrivilegeUser(username = "Sashikana",id="12345",age=24)
    val privilege= Privilege(id=2,name="Invisibles")
    privilegeUser.addPrivilege(privilege)
    println(privilegeUser.about())
}