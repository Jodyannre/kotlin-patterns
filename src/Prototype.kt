/* Creational pattern prototype */
/* Copy objects that implement the same interface */

interface Shape {
    fun clone(): Shape
}

data class Circle(private val radius: Double): Shape {
    override fun clone():Circle = copy()
    fun getRadius(): Double = radius
}

data class Square(private val side: Double): Shape {
    override fun clone(): Square = copy()
    fun getSide(): Double = side
}


/* Example of use */
/*
    val circulo = Circle(15.2)
    println(circulo.getRadius())

    val circulo2 = circulo.clone()
    println(circulo2.getRadius())
 */

