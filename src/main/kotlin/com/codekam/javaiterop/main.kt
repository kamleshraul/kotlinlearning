package com.codekam.javaiterop
import com.codekam.javaiterop.User
import com.codekam.oops.Address

enum class AddressType{
    Billing,
    Shipping,
    Gift
}
//@JvmOverloads = create overloaded constructor
// that substitute default values
data class Address @JvmOverloads constructor (
    @JvmField val streetline1:String,
    val streetline2:String,
    val city:String,
    val state:String,
    val postalCode:String,
    val addressType:AddressType,
    val country:String = "United States"
){
    fun forPostalLabel():String{
        var postalAddress = streetline1
        postalAddress += " $streetline2 \n $city \n $state \n $postalCode"
        postalAddress += " \n ${country.uppercase()}"
        return postalAddress
    }

    override fun toString(): String {
        return forPostalLabel()
    }

    object JSONKeys{
        const val streetline1 ="street_1"
        val streetline2 ="street_2"
        val city="city"
        val stateOrProvince="state"
        val postalCode = "zip"
        val addressType="type"
        val country="country"
    }

    companion object {
        const val sampleFirstLine = "123 Fake Street"
    }

}




fun main(){

    val user:User = User()
    user.firstName = "Boub"
    user.lastName = "Builder"
    user.age = 20
    //user.city = "Los angeles"
    //user.country = "America"
    val billingAddress= Address("123 streets"
    ,"4th Floor","Los Angeles","CA","9021",AddressType.Billing)
    println("User Info : \n $user")
    println("Billing Address: $billingAddress")

    user.addOrUpdateAddress(billingAddress)
    val shippingAddress=Address("987 shiping address",""
        ,"Burbank","CA","91234",AddressType.Shipping)
    user.addOrUpdateAddress(shippingAddress )

    println("User address after updating address $user")

    println("Shipping Lable")
    printLabelFor(user,AddressType.Shipping)
    val anotherUser = User()
    anotherUser.addresses = null
    println("Another User has ${anotherUser.addresses?.count()} addresses")
    println("Another User firstname ${anotherUser.firstName ?: "(Not Set)"}")

    //printing companion objects property
    println("Companion Object of Address Class has property named sampleFirstLine")
    println(com.codekam.javaiterop.Address.sampleFirstLine)
}