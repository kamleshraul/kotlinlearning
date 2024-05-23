package com.codekam.sealedclasses
/*
* 1. Sealed classes are by default Abstrac
* 2. Sealed classes can have abstract and non-abstract members
* 3. Sealed classes subclasses can have any number of instances
* 4. Subclasses of Sealed Class can defined in same file
* 5. Any number of subclasses can be derived from subclasses of
*    sealed classes outside of file
* */
sealed class AcceptedCurrency{

    abstract val valueInDollar:Float
    var amount:Float = 0.0f

    fun totalValueInDollor():Float = amount * valueInDollar

    class Dollar:AcceptedCurrency() {
        override val valueInDollar: Float
            get() = 1.0f
    }

    class Euros:AcceptedCurrency() {
        override val valueInDollar: Float
            get() = 1.25f
    }

    class Crypto:AcceptedCurrency() {
        override val valueInDollar: Float
            get() = 234.45f
    }

    val name:String
        get() = when(this){
            is Euros -> "Euro"
            is Dollar -> "Dollar"
            is Crypto -> "Crypto"
        }
}

fun main() {
    val currency=AcceptedCurrency.Crypto()
    println("You have some ${currency.name}")
    currency.amount=.245f
    println("${currency.amount} of ${currency.name} " +
            "it's value in dollor ${currency.totalValueInDollor()}" )
}