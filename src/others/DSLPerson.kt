package others


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

class AddressBuilder {
    fun build(): Address {
        return Address(street, number, city)
    }

    var street = ""
    var number = -1
    var city = ""
}

class PersonBuilder {
    var name = ""
    var age = -1
    val addresses: MutableList<Address> = mutableListOf()


    fun address(block: AddressBuilder.() -> Unit) {
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
        address {
            street = "Main Street"
            number = 42
            city = "London"
        }
        address {
            street = "some random street"
            number = 41
            city = "London"
        }
    }

    println(person)
}
