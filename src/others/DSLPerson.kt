package others


data class Person(
    val name: String? = null,
    val age: Int? = null,
    val address: Address? = null
)

data class Address(
    var street: String? = null,
    var number: Int? = null,
    var city: String? = null
)

fun person(block: PersonBuilder.() -> Unit): Person {
    val p = PersonBuilder()
    p.block()
    return p.build()
}

class PersonBuilder {
    var name = ""
    var age = 2
    var address: Address? = null


    fun address(block: Address.() -> Unit) {
        address = Address().apply(block)
    }

    fun build(): Person = Person(name, age, address)

}


fun main() {
//    person {
//        it.name = "John"
//        it.age = 25
//        address {
//            street = "Main Street"
//            number = 42
//            city = "London"
//        }
//    }

    // person is creating a person and passing it onto the lambda
    val person = person {
        name = "John"
        age = 32
        address {
            street = "Main Street"
            number = 42
            city = "London"
        }
    }

    println(person)
}
