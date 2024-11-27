package behavioral

/* Behavioral pattern mediator

 is a behavioral design pattern that lets you reduce chaotic dependencies between objects.
 The pattern restricts direct communications between the objects and forces them to collaborate
 only via a mediator object.
 */

interface ChatMediator {
    fun sendMessage(message: String, user:User)
    fun addUser(user: User)
}

abstract class User(protected val mediator: ChatMediator, val name: String) {
    abstract fun send(message: String)
    abstract fun receive(message: String)
}


// Mediador concreto
class ChatRoom : ChatMediator {
    private val users = mutableListOf<User>()

    override fun addUser(user: User) {
        users.add(user)
    }

    override fun sendMessage(message: String, user: User) {
        for (u in users) {
            if (u != user) {
                u.receive(message)
            }
        }
    }
}


class ChatUser(mediator: ChatMediator, name: String) : User(mediator, name) {
    override fun send(message: String) {
        println("$name envía: $message")
        mediator.sendMessage(message, this)
    }

    override fun receive(message: String) {
        println("$name recibe: $message")
    }
}


/* Example of use

fun main() {
    val chatRoom = ChatRoom()

    val user1 = ChatUser(chatRoom, "Alice")
    val user2 = ChatUser(chatRoom, "Bob")
    val user3 = ChatUser(chatRoom, "Charlie")

    chatRoom.addUser(user1)
    chatRoom.addUser(user2)
    chatRoom.addUser(user3)

    user1.send("Hola a todos")
    user2.send("Hola Alice")
    user3.send("¿Cómo están?")
}
 */



/* Aircrafts example */

interface AirTrafficController {
    fun registerAirplane(airplane: Airplane)
    fun deregisterAirplane(airplane: Airplane)
    fun requestTakeOff(airplane: Airplane)
    fun requestLanding(airplane: Airplane)
}
class Airplane(private val registrationNumber: String, private val controller: AirTrafficController) {
    fun takeOff() {
        println("$registrationNumber is requesting takeoff.")
        controller.requestTakeOff(this)
    }
    fun land() {
        println("$registrationNumber is requesting landing.")
        controller.requestLanding(this)
    }
    fun notifyTakeOff() {
        println("$registrationNumber has taken off.")
        controller.deregisterAirplane(this)
    }
    fun notifyLanding() {
        println("$registrationNumber has landed.")
        controller.registerAirplane(this)
    }
}

class AirTrafficControlTower : AirTrafficController {
    private val registeredAirplanes: MutableSet<Airplane> = mutableSetOf()
    override fun registerAirplane(airplane: Airplane) {
        registeredAirplanes.add(airplane)
    }
    override fun deregisterAirplane(airplane: Airplane) {
        registeredAirplanes.remove(airplane)
    }
    override fun requestTakeOff(airplane: Airplane) {
        if (registeredAirplanes.contains(airplane)) {
            airplane.notifyTakeOff()
        }
    }
    override fun requestLanding(airplane: Airplane) {
        if (!registeredAirplanes.contains(airplane)) {
            airplane.notifyLanding()
        }
    }
}


/* Example of use

fun main() {
    val airport = AirTrafficControlTower()

    val plane1 = Airplane("25264", airport)
    val plane2 = Airplane("25454", airport)
    val plane3 = Airplane("25468", airport)

    airport.registerAirplane(plane1)
    airport.registerAirplane(plane2)
    airport.registerAirplane(plane3)

    plane1.notifyTakeOff()
    plane2.notifyTakeOff()
    plane3.notifyLanding()
}
 */