package com.codekam.javaiterop

fun labelFor(user:User,type:AddressType):String{
    val address = user.addressOfType(type)
    if(address!=null){
        var label = "----------\n"
        label += "${user.fullName}\n${address.forPostalLabel()}"
        label += "\n-------------\n"
        return label
    }else{
        return "\n!! ${user.fullName} does not have a $type address setup"
    }
}

@JvmOverloads
fun printLabelFor(user:User,type:AddressType=AddressType.Shipping){
    println(labelFor(user,type))
}