package others

@DslMarker
annotation class PersonDsl

data class Person(
    val name: String? = null,
    val age: Int? = null,
    val address: List<Address>
)

data class Address(
    val street: String? = null,
    val number: Int? = null,
    val city: String? = null
)

fun person(block: PersonBuilder.() -> Unit): Person {
    val p = PersonBuilder()
    p.block()
    return p.build()
}

@PersonDsl
class AddressBuilder {
    fun build(): Address {
        return Address(street, number, city)
    }

    var street = ""
    var number = -1
    var city = ""
}

@PersonDsl
class PersonBuilder {
    var name = ""
    var age = -1
    val addresses: MutableList<Address> = mutableListOf()


    fun addresses(block: AddressBuilder.() -> Unit) {
        val address = AddressBuilder().apply(block).build()
        addresses.add(address)
    }

    fun build(): Person = Person(name, age, addresses)
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
        addresses {
            street = "Main Street"
            number = 42
            city = "London"
//            this@person.name="poplo" // not accessible after the dsl marker
        }
    }

    println(person)
}
