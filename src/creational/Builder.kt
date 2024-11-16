package creational

/* Creational pattern Builder */
/* Creating an object in steps */
class Pizza {
    var size: String? = null
    var bread: String? = null
    var ingredients: List<String>? = null
    var price: Double? = null

    class Builder {
        val pizza = Pizza()

        fun size(size:String) = apply{pizza.size = size}
        fun bread(bread:String) = apply{pizza.bread = bread}
        fun ingredients(vararg ingredients: String) = apply{pizza.ingredients = ingredients.toList()}
        fun price(price: Double) = apply{pizza.price = price}
        fun build() = pizza
    }
}


/* Example of use */

/*
    val pizza = creational.Pizza.Builder()
    .size("Medium")
    .price(25.32)
    .bread("Integral")
    .ingredients("Broccoli","Cucumber","Pineapple")
    .build()

    println(pizza)
*/
