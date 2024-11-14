fun main () {
    val circulo = Circle(15.2)
    println(circulo.getRadius())

    val circulo2 = circulo.clone()
    println(circulo2.getRadius())
}