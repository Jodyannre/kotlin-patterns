import java.math.*

fun main () {
    val woodFabric = WoodFactory()

    val silla = woodFabric.createChair()
    val mesa = woodFabric.createTable()
    val puerta = woodFabric.createDoor()

    val metalFabric = MetalFactory()

    val silla2 = metalFabric.createChair()
    val mesa2 = metalFabric.createTable()
    val puerta2 = metalFabric.createDoor()

    val concreteFabric = ConcreteFactory()

    val silla3 = concreteFabric.createChair()
    val mesa3 = concreteFabric.createTable()
    val puerta3 = concreteFabric.createDoor()

    silla.describe()
    silla2.describe()
    silla3.describe()

    println(silla::class.simpleName)
}