package creational/* Creationl pattern FactoryAbsctract*/

/*
provides an interface for creating families of related or dependent o
bjects without knowing the concrete classes.
 */

interface Material {
    fun describe(): Unit
}

interface Chair: Material
interface Door: Material
interface Table: Material

interface FactoryAbstract{
    fun createChair(): Chair
    fun createDoor(): Door
    fun createTable(): Table
}

fun Material.printTypo() = println(this.javaClass.simpleName)

class MetalDoor: Door {
    override fun describe(): Unit = printTypo()
}

class WoodDoor: Door {
    override fun describe(): Unit = printTypo()
}

class ConcreteDoor: Door {
    override fun describe(): Unit = printTypo()
}

class MetalChair: Chair {
    override fun describe(): Unit = printTypo()
}

class WoodChair: Chair {
    override fun describe(): Unit = printTypo()
}

class ConcreteChair: Chair {
    override fun describe(): Unit = printTypo()
}

class MetalTable: Table {
    override fun describe(): Unit = printTypo()
}

class WoodTable: Table {
    override fun describe(): Unit = printTypo()
}

class ConcreteTable: Table {
    override fun describe(): Unit = printTypo()
}

class MetalFactory: FactoryAbstract {
    override fun createChair(): Chair = MetalChair()
    override fun createDoor(): Door = MetalDoor()
    override fun createTable(): Table = MetalTable()
}

class WoodFactory: FactoryAbstract {
    override fun createChair(): Chair = WoodChair()
    override fun createDoor(): Door = WoodDoor()
    override fun createTable(): Table = WoodTable()
}

class ConcreteFactory: FactoryAbstract {
    override fun createChair(): Chair = ConcreteChair()
    override fun createDoor(): Door = ConcreteDoor()
    override fun createTable(): Table = ConcreteTable()
}

/* Example of use */

/*
val woodFabric = creational.WoodFactory()

    val silla = woodFabric.createChair()
    val mesa = woodFabric.createTable()
    val puerta = woodFabric.createDoor()

    val metalFabric = creational.MetalFactory()

    val silla2 = metalFabric.createChair()
    val mesa2 = metalFabric.createTable()
    val puerta2 = metalFabric.createDoor()

    val concreteFabric = creational.ConcreteFactory()

    val silla3 = concreteFabric.createChair()
    val mesa3 = concreteFabric.createTable()
    val puerta3 = concreteFabric.createDoor()

    silla.describe()
    silla2.describe()
    silla3.describe()

 */