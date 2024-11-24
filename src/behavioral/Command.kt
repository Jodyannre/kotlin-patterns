package behavioral

interface Command {
    fun execute()
}
/* Commands */
class TurnOnLightCommand(private val light:Light): Command {
    override fun execute() = light.turnOn()
}

class TurnOffLightCommand(private val light:Light): Command {
    override fun execute() = light.turnOff()
}

/* Receiver */
class Light {
    fun turnOn() = println("Light on")
    fun turnOff() = println("Light off")
}

/* Invokers */
class ImmediateInvoker {
    fun exec(command: Command) {
        command.execute()
    }
}

class ScheduledInvoker {
    val commands = mutableListOf<Command>()

    fun scheduleCommand(command: Command) {
        commands.add(command)
    }
    fun executeScheduledCommands() {
        for (command in commands) {
            command.execute()
        }
        commands.clear()
    }
}



/* Otro ejemplo con clipboard */

data class Clipboard(var content: String = "")

/* Commands */
interface Cmd {
    fun execute()
    fun undo()
}

class CutCmd(private val receiver: TextEditor, private val clipboard: Clipboard): Cmd {
    override fun execute() {
        clipboard.content = receiver.cut()
    }
    override fun undo() {
        receiver.write(clipboard.content)
        clipboard.content = ""
    }
}

class CopyCmd(private val receiver: TextEditor, private val clipboard: Clipboard): Cmd {
    override fun execute() {
        clipboard.content = receiver.copy()
    }
    override fun undo() {
        clipboard.content = ""
    }
}

class PasteCmd(private val receiver: TextEditor, private val clipboard: Clipboard): Cmd {
    override fun execute() {
        receiver.write(clipboard.content)
    }
    override fun undo() {
        receiver.delete(clipboard.content)
    }
}

/* Receiver  */
class TextEditor(initialContent: String) {
    private var content: String = initialContent

    fun cut(): String {
        val cutContent = content.takeLast(1)
        content = content.dropLast(1)
        return cutContent
    }

    fun copy(): String {
        return content
    }

    fun write(text: String) {
        content += text
    }

    fun delete(text: String) {
        content = content.removeSuffix(text)
    }

    fun print() {
        println(content)
    }
}

/* Invoker */

class TextEditorInvoker {
    private val commands = mutableListOf<Cmd>()

    fun executeCommand(command: Cmd) {
        commands.add(command)
        command.execute()
    }

    fun undo() {
        if (commands.isNotEmpty()) {
            commands.removeLast().undo()
        }
    }
}


/* Examples of use

lights

val light = Light()
    val light2 = Light()
    val light3 = Light()

    val inmediateInvoker = ImmediateInvoker()
    val scheduledInvoker = ScheduledInvoker()

    inmediateInvoker.exec(TurnOnLightCommand(light))
    inmediateInvoker.exec(TurnOffLightCommand(light))

    scheduledInvoker.scheduleCommand(TurnOnLightCommand(light))
    scheduledInvoker.scheduleCommand(TurnOffLightCommand(light))
    scheduledInvoker.executeScheduledCommands()


   ------------------------------------------------------------------
    Text editor example

    val invoker = TextEditorInvoker()
    var clipboard: Clipboard = Clipboard()
    var receiver: TextEditor = TextEditor("Hola mundo")

    val copy = CopyCmd(receiver,clipboard)
    val paste = PasteCmd(receiver,clipboard)
    val cut = CutCmd(receiver,clipboard)
    invoker.executeCommand(copy)
    invoker.executeCommand(paste)
    invoker.executeCommand(cut)
    invoker.undo()
    receiver.print()
    println(clipboard.content)

 */