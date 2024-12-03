package behavioral

/* Behavioral template method pattern

is a behavioral design pattern that defines the skeleton of an algorithm in the superclass
but lets subclasses override specific steps of the algorithm without changing its structure.

 */

abstract class Pizza {

    //Template algorithms - Steps to make pizza
    fun make() {
        makeDough()
        addIngredients()
        applySauce()
        bake()
    }

    open fun bake() = println("Cooking pizza for 20 minutes")


    open fun addIngredients() = println("Adding ingredients")


    open fun applySauce() = println("Applying tomato sauce")


    open fun makeDough() = println("Making 30cm dough")

}


class Pepperoni: Pizza() {

    override fun addIngredients() {
        println("adding salami")
        println("adding onion")
        println("adding cheese")
    }
}


class BigPepperoni : Pizza() {

    override fun addIngredients() {
        println("adding salami")
        println("adding onion")
        println("adding cheese")
    }

    override fun makeDough() {
        println("making 50cm dough")
    }
}


/* Example of use

fun main() {
    val pizza = BigPepperoni()
    pizza.make()

    val pizza2 = Pepperoni()
    pizza2.make()
}
 */


interface hola {
    fun holas() {
        println("Hola mundo")
    }
}