package behavioral

/* Behavioral state pattern

is a behavioral design pattern that lets an object alter its behavior when its internal
state changes. It appears as if the object changed its class.
 */

interface TrafficLightState {
    fun display()
    fun next(context: TrafficLightContext)
}

class GreenState: TrafficLightState {
    override fun display() {
        println("Green light...")
    }
    override fun next(context: TrafficLightContext) {
        println("Changing state from green to yellow.")
        context.setState(YellowState())
    }
}

class YellowState: TrafficLightState {
    override fun display() {
        println("Yellow light...")
    }
    override fun next(context: TrafficLightContext) {
        println("Changing state from yellow to red")
        context.setState(RedState())
    }
}

class RedState: TrafficLightState {
    override fun display() {
        println("Red light...")
    }

    override fun next(context: TrafficLightContext) {
        println("Changing state from red to green.")
        context.setState(GreenState())
    }
}


class TrafficLightContext {
    private var state: TrafficLightState = RedState()

    fun setState(state: TrafficLightState) {
        this.state = state
    }

    fun change() = state.next(this)
    fun showSignal() = state.display()
}


/* Example of use

fun main() {
    val trafficLight = TrafficLightContext()
    repeat(6){
        trafficLight.showSignal()
        trafficLight.change()
    }
}
 */