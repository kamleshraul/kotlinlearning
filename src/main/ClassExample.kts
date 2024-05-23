
class Person(var firstName:String,var lastName:String){
    val fullName
        get()="$firstName $lastName"
}

val kamlesh=Person("Kamlesh","Raul")
println(kamlesh.fullName)