package behavioral
/* Behavioral Observer pattern

is a behavioral design pattern that lets you define a subscription mechanism to
notify multiple objects about any events that happen to the object they’re observing

 */


interface Observable<T> {
    fun addObserver(observer: Observer<T>)
    fun removeObserver(observer: Observer<T>)
    fun notifyObservers()
}

interface Observer<T> {
    fun update(data: T)
}


class Message(var content: String) : Observable<Message> {
    private val observers = mutableListOf<Observer<Message>>()

    fun setContentOb(content: String) {
        this.content = content
        notifyObservers()
    }

    override fun addObserver(observer: Observer<Message>) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer<Message>) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach { it.update(this) }
    }
}

class UserObserver(var name: String) : Observer<Message> {
    override fun update(data: Message) {
        println("Nuevo mensaje para $name: ${data.content}")
    }
}


/* Example of use

fun main() {
    var cliente1 = UserObserver("Mariano")
    var cliente2 = UserObserver("Roberto")

    var message = Message("Hello World!")

    message.addObserver(cliente1)
    message.addObserver(cliente2)

    message.setContentOb("Este es el nuevo contenido llegando.")
}
 */