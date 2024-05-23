package com.codekam.advancoops

data class Sport(val name:String)

open class Student2(firstName:String, lastName:String):Person(firstName,lastName){
    val grades=mutableListOf<Grade>()
}

//single responsibility as StudentAthlete class will hold student
//information who play sports
class StudentAthlete2(firstName: String,lastName: String,val isEligble:Boolean=true):Student2(firstName,lastName){
    private val sports=mutableListOf<Sport>()
}

//strong typing
class Team{
    private var players=mutableListOf<StudentAthlete2>()

    // if any student in team is not eligible for sports
    // then Team also not eligible
    val isEligible:Boolean
        get(){
            return players
                        .filter { it.isEligble }
                        .size == players.size
        }

    fun addAthelete(studentAthlete2: StudentAthlete2) {
        players.add(studentAthlete2)
    }

}

fun main() {
    val student1=StudentAthlete2(firstName = "David", lastName = "warner", isEligble = true)
    val student2=StudentAthlete2(firstName = "Mahnas", lastName = "Lebusen", isEligble = true)
    val student3=StudentAthlete2(firstName = "Michel", lastName = "smith", isEligble = false)
    val student4=StudentAthlete2(firstName = "Nathan", lastName = "Lion", isEligble = true)

    val team=Team()
    team.addAthelete(student1)
    team.addAthelete(student2)
    team.addAthelete(student3)
    team.addAthelete(student4)

    println("Is Team Eligible ${team.isEligible}")
}