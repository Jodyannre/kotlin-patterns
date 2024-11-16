package creational
/* Creational pattern factory */
/* Centralize creation of objects that implement the same interface */

class FactoryVehicle {
    fun create(type: String, brand: String, model: String): Vehicle {
        return when (type) {
            "carro" -> Car(model, brand)
            "barco" -> Ship(model, brand)
            "avion" -> Plane(model, brand)
            else -> throw IllegalArgumentException("Tipo de vehículo desconocido")
        }
    }
}

interface Vehicle {
    val model: String
    val brand: String
    fun move(): Unit
}

class Car (override val model:String, override val brand:String): Vehicle {
    override
    fun move(): Unit { println("Movimiento terrestre")}
}

class Ship (override val model:String, override val brand:String): Vehicle {
    override
    fun move(): Unit { println("Movimiento actuático")}
}

class Plane (override val model:String, override val brand:String): Vehicle {
    override
    fun move(): Unit { println("Movimiento aéreo")}
}


// Example of use

/*
    val vehicleFactory = creational.FactoryVehicle()
    val carro = vehicleFactory.create(type="carro",brand="Toyota",model="Corolla")
    val avion= creational.FactoryVehicle().create(type="avion",brand="Toyota",model="Corolla")
 */

