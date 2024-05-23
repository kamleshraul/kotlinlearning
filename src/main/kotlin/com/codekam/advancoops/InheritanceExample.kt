package com.codekam.advancoops

data class Grade(val letter:Char,val points:Double,val credits:Double)

open class Person(var firstName:String,var lastName:String){
    fun fullName()="${firstName} $lastName"
}

open class Student(var fName: String
              ,var lName: String
              ,var grades:MutableList<Grade> = mutableListOf<Grade>()
            ):Person(fName,lName){
    open fun recordGrade(grade:Grade){
        grades.add(grade)
    }
}

class StudentAthlete(firstName: String,lastName: String):Student(firstName,lastName){
    val failedClasses = mutableListOf<Grade>()

    override fun recordGrade(grade:Grade){
        super.recordGrade(grade)
        if(grade.letter=='F'){
            failedClasses.add(grade)
        }
    }

    val isEligible
        get()=failedClasses.size<3
}

open class BandMember(fname:String,lname:String):Student(fname,lname){
    open val minimumPracticeTime:Int
        get()=2
}

class OboePlayer(fname:String,lname:String):BandMember(fname,lname){
    override val minimumPracticeTime=super.minimumPracticeTime *2
}

fun phoneBookName(person:Person) = "${person.firstName} ${person.lastName}"

fun main() {
    val person = Person("Venkat","Subramanyam")
    val student = Student("Adam","Bien")
    println(person.firstName)
    println(person.lastName)

    val history =Grade(letter='B', points = 9.0, credits = 3.0)
    student.recordGrade(history)
    println(student.grades)

    println(phoneBookName(person))
    println(phoneBookName(student))

    var obeyPlayer=OboePlayer(fname = "Viral", lname = "rowntok")
    var hallMonitor=Student(fName = "Gosh", lName = "Joslin")
    //child can assign to parent
    hallMonitor=obeyPlayer

    println("Is HallMonitor is ObeyPlayer ${hallMonitor is OboePlayer}")
    println("Is HallMonitor is Not ObeyPlayer ${hallMonitor !is OboePlayer}")
    println("Is HallMonitor is Person ${hallMonitor is Person}")

    //as is unsafe cast
    println("Band Member practice Time ${(obeyPlayer as BandMember).minimumPracticeTime}")
    //as? is safe cast
    println("Band Member practice Time ${(obeyPlayer as? BandMember)?.minimumPracticeTime}")

    val math=Grade(letter='B',points=9.0, credits = 3.0)
    val science=Grade(letter='F',points=9.0, credits = 3.0)
    val physics=Grade(letter='F',points=9.0, credits = 3.0)
    val chemistry=Grade(letter='F',points=9.0, credits = 3.0)
    val dom = StudentAthlete(firstName = "Dom", lastName = "Grady")
    dom.recordGrade(math)
    dom.recordGrade(science)
    dom.recordGrade(physics)
    dom.recordGrade(chemistry)
    println("Student Athlete isEligible ${dom.isEligible}")
}