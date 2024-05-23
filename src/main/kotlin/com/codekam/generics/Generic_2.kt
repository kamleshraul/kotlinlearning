package com.codekam.generics

import javax.swing.text.AbstractDocument.BranchElement

// Generic on classes

class CheapThing(val name:String):Checkable{
    override fun checkIsOk(): Boolean = true
    override fun toString(): String = name
}

class BreakableThings(val name:String, var isBroken:Boolean=false):Checkable{
    fun smash(){
        this.isBroken=true
    }
    override fun checkIsOk(): Boolean = ! this.isBroken
    override fun toString()= name
}

interface Checkable{
    fun checkIsOk():Boolean
}

interface Container<T>{
    fun canAddAnotherItem():Boolean
    fun addItem(item:T)
    fun canRemoveAnotherItem():Boolean
    fun removeItem():T
    fun getAnother():Container<T>
    fun contents():List<T>
}

class CardBoardBox:Container<BreakableThings>{
    private  var items = mutableListOf<BreakableThings>()

    override fun canAddAnotherItem(): Boolean = items.count() < 2

    override fun canRemoveAnotherItem(): Boolean = items.count() > 0

    override fun removeItem(): BreakableThings {
        val lastItem = items.last()
        items.remove(lastItem)
        return lastItem
    }

    override fun getAnother(): Container<BreakableThings> = CardBoardBox()

    override fun contents(): List<BreakableThings> = items.toList()

    override fun addItem(item: BreakableThings) { items.add(item) }


}

class Mover<T:Checkable>(thingsToMove:List<T>,
    val truckHeightInInches:Int = (12*12)){

    private val thingsLeftOldPlace = mutableListOf<T>()
    private val thingsInTruck = mutableListOf<Any>()
    private val thingsInNewPlace = mutableListOf<T>()
    private val thingsFailedToCheck= mutableListOf<T>()

    init{
        thingsLeftOldPlace.addAll(thingsToMove)
    }

    fun moveEveryThingToTruck(startingContainer:Container<T>?){
        var currentContainer=startingContainer

        while(thingsLeftOldPlace.size>0) {
            val item = thingsLeftOldPlace.removeAt(0)
            if(item.checkIsOk()) {
                if(currentContainer!=null){
                    if(!currentContainer.canAddAnotherItem()) {
                        moveContainerToTruck(currentContainer)
                        currentContainer = currentContainer.getAnother()
                    }
                    currentContainer.addItem(item)
                    println("Packed Item $item in container")
                }else{
                    thingsInTruck.add(item)
                    println("Moved $item to truck")
                }
            }else{
                thingsFailedToCheck.add(item)
            }
        }
        currentContainer?.let{moveContainerToTruck(currentContainer)}
    }

    fun moveContainerToTruck(container:Container<T>){
        thingsInTruck.add(container)
        println("Moved a container with your" +
                " ${container.contents().toBulletList()} to truck")
    }

    private fun tryToMoveItemIntoNewPlace(item:T){
        if(item.checkIsOk()){
            thingsInNewPlace.add(item)
            println("Moved your $item in new place")
        }else{
            thingsFailedToCheck.add(item)
            println("Could not move your $item into your place")
        }
    }

    fun moveEveryThingToNewPlace(){
        //val breakableThings = thingsInTruck.filterIsInstance<BreakableThings>()
        val containers = thingsInTruck.filterIsInstance<Container<T>>()
        containers.forEach { container ->
            run {
                thingsInTruck.remove(container)
                while (container.canRemoveAnotherItem()) {
                    val removeItemFromContainer = container.removeItem()
                    println("Unpack your item from container $removeItemFromContainer")
                    tryToMoveItemIntoNewPlace(removeItemFromContainer)
                }
            }
        }

        while(thingsInTruck.size>0){
            val item = thingsInTruck.removeAt(0) as? T
            if(item!=null){
                tryToMoveItemIntoNewPlace(item)
            }else{
                println("Item is not yours")
            }
        }
    }

    fun finishMove(){
        if(thingsInTruck.size == 0
            && thingsLeftOldPlace.size == 0
            && thingsInNewPlace.size>0){
            println("finished movings")
            println(thingsInNewPlace.toBulletList())
        }

        if(thingsFailedToCheck.size>0){
            println("Things broken during transport")
            println(thingsFailedToCheck.toBulletList())
        }
    }
}

fun main() {
    val listOfCheapThings= mutableListOf<CheapThing>(
        CheapThing("Old Couch"),
        CheapThing("Wall Mount Furniture"),
        CheapThing("Book Shelf"),
        CheapThing("Cupboard")
    )

    val cheapMover = Mover(listOfCheapThings)
    cheapMover.moveEveryThingToTruck(null)
    cheapMover.moveEveryThingToNewPlace()
    cheapMover.finishMove()

    val telivision = BreakableThings("TV")
    val listOfBreakableThings= listOf(
        telivision,
        BreakableThings("Guitar"),
        BreakableThings("Mirror")
    )

    println("Transport Expensive things \n")
    val expensiveMover=Mover(listOfBreakableThings)
    expensiveMover.moveEveryThingToTruck(CardBoardBox())
    telivision.smash()
    expensiveMover.moveEveryThingToNewPlace()
    expensiveMover.finishMove()
}