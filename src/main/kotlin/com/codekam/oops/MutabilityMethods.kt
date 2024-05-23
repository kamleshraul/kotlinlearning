package com.codekam.oops

class Grade(val letter:String
        ,val points:Double
        ,val credits:Double)

class Student(
    val id: Int,
    val firstName:String,
    val lastName:String,
    val grades:MutableList<Grade> = mutableListOf(),
    var credits: Double =0.0){



    fun recordGrade(grade:Grade){
        grades.add(grade)
        credits+=grade.credits
    }

    override fun hashCode(): Int {
        val prime=31
        var result=1
        result=result*prime + firstName.hashCode()
        result=result*prime + id
        result= result* prime + lastName.hashCode()
        return result
    }
}