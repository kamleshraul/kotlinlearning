package com.codekam.extensions

/*One class's extension function can be declared in another class as member*/

class Host(val hostname:String){
    fun printHost() = print(hostname)

    /*If same named methods present in receiver object and dispatch receiver then
    * extension receiver take precedence in our case it will use Host.printPort()
    * always rather thane connection.printPort()*/
    //fun printPort() = print("Host will not declared Port")
}

class Connection(val host:Host,val port:Int){
    fun printPort() = print(port)

    /*Following extension function declared inside connection class
    * Inside this extension function there are multiple implicit receivers object
    * present
    * 1- One receiver object is class for which extension function is declared i.e Host
    *    which is called as 'extension receiver'
    * 2- And instance of a class in which extension function is actually defined i.e. connection
    *    which is called as 'dispatch receiver' */
    fun Host.printConnectionString(){
        printHost() // extension receiver i.e. Host.printHost()
        print(":")
        printPort() // dispatch receiver i.e Connection.printPort()
        //above dispatch receiver can be written as
        println(" \n >> Printing Port using dispatch receiver")
        this@Connection.printPort() // this@ special syntax is used in solve the
    // conflict between extension receiver and dispatch extension
    }

    fun connect(){
        host.printConnectionString()
    }
}

fun main(){
    Connection(Host("kot.in"),443).connect()
}