import behavioral.Message
import behavioral.UserObserver


fun main() {
    var cliente1 = UserObserver("Mariano")
    var cliente2 = UserObserver("Roberto")

    var message = Message("Hello World!")

    message.addObserver(cliente1)
    message.addObserver(cliente2)

    message.setContentOb("Este es el nuevo contenido llegando.")
}