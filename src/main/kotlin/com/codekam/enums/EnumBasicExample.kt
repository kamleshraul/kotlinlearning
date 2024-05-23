package com.codekam.enums

import java.util.Calendar

// enum classes cannot be open hence cannot be subclassed
// enum declaration
enum class DayOfTheWeek(val isWeekend:Boolean=false) {
   /*Followings are called Cases of this enum class
   * Every case is an instance of this class
   * */
    Sunday(isWeekend = true),
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday(isWeekend = true);

    //following is instance level method of enum
    // i.e is can be called using cases of this enum
    // e.g. Tuesday.daysUntil(...)
    fun daysUntil(other:DayOfTheWeek):Int{
        if(this.ordinal<other.ordinal)
            return other.ordinal-this.ordinal
        else
            return other.ordinal-this.ordinal+DayOfTheWeek.values().count()
    }

    companion object{
        fun values2():Unit{
            println("Companion object method values2() ")
        }

        fun today():DayOfTheWeek{
            val calendarDayOfWeek=Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
            var adjustedDay=calendarDayOfWeek-1

            adjustedDay+= if(adjustedDay<0) DayOfTheWeek.values().count() else 0
            println("Calendar gives day of week " +
                    "as $calendarDayOfWeek and " +
                    "Our enum index $adjustedDay")

            return values().first { it.ordinal == adjustedDay }
        }
    }
}



fun getDayOfWeekByIndex(idx:Int):DayOfTheWeek{
    return DayOfTheWeek.values()[idx]
}

fun getDayOfWeekByString(str:String):DayOfTheWeek{
    return DayOfTheWeek.valueOf(str)
}

fun whenExpressionWithEnum(obj:DayOfTheWeek):Unit = when(obj){
    DayOfTheWeek.Sunday -> println("Ravivar")
    DayOfTheWeek.Monday -> println("Somvar")
    DayOfTheWeek.Tuesday -> println("Mangalvar")
    DayOfTheWeek.Wednesday -> println("Budhvar")
    DayOfTheWeek.Thursday -> println("Guruvar")
    DayOfTheWeek.Friday -> println("Shrukarvar")
    DayOfTheWeek.Saturday -> println("Shnivar")
    else-> println("Don't know the day")
}

fun main() {
    println("Days of week using Enum")

    // values() is a compiler generated Companion object function
    // for enum class
    DayOfTheWeek.values().forEach{
        print(" ${it.name}")
        print(" ${it.ordinal}")
        print(" ,is a Weekend: ${it.isWeekend}")
        print(" ${it.declaringClass} \n")
    }

    println("Getting day of week at index 4")
    val fourthIndexDay=getDayOfWeekByIndex(4)
    println(fourthIndexDay)

    println("Getting day of week by string Monday")
    val monday= getDayOfWeekByString("Monday")
    //val monday= getDayOfWeekByString("monday") //error exact match case sensitive
    //val monday= getDayOfWeekByString("monday  ") //error exact match no spaces allowed
    println(monday)

    //our own implementation of companion object method
    DayOfTheWeek.values2()

    println("Today ${DayOfTheWeek.today()}")

    println("Days remains between today and Tuesday")
    print(" : ${DayOfTheWeek.today().daysUntil(DayOfTheWeek.Tuesday)} \n")

    whenExpressionWithEnum(DayOfTheWeek.today())
}