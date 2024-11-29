package behavioral
/* Behavioral memento pattern

is a behavioral design pattern that lets you save and restore the previous state of an
object without revealing the details of its implementation.

 */


data class CalculatorMemento(val value: Int)

//Originador
class Calculator() {
    private var currentValue: Int = 0

    fun add(value: Int) {
        currentValue += value
    }

    fun subtract(value: Int) {
        currentValue -= value
    }

    fun multiply(value: Int) {
        currentValue *= value
    }

    fun divide(value: Int) {
        if (value == 0) throw IllegalArgumentException("No se puede dividir entre cero")
        currentValue /= value
    }


    fun getCurrentValue(): Int {
        return currentValue
    }


    fun saveState(): CalculatorMemento {
        return CalculatorMemento(currentValue)
    }


    fun restoreState(memento: CalculatorMemento) {
        currentValue = memento.value
    }

}


//Caretaker
class CalculatorHistory {
    private val history = mutableListOf<CalculatorMemento>()

    fun saveState(memento: CalculatorMemento) {
        history.add(memento)
    }

    fun getPreviousState(): CalculatorMemento? {
        return if (history.isNotEmpty()) history.removeLast() else null
    }
}



/* Example of use

fun main() {
    val calculator = Calculator()
    val history = CalculatorHistory()

    //Save initial state
    history.saveState(calculator.saveState())
    println("Initial value: ${calculator.getCurrentValue()}")

    calculator.add(10)
    history.saveState(calculator.saveState())
    println("After sum 10: ${calculator.getCurrentValue()}")

    calculator.multiply(2)
    history.saveState(calculator.saveState())
    println("After times by 2: ${calculator.getCurrentValue()}")

    // Undo one
    println("\nUndoing the last operation...")
    val previousState = history.getPreviousState()
    if (previousState != null) calculator.restoreState(previousState)
    println("Actual value: ${calculator.getCurrentValue()}")

    // Undo two
    println("\nUndoing another operation...")
    val secondPreviousState = history.getPreviousState()
    if (secondPreviousState != null) calculator.restoreState(secondPreviousState)
    println("Actual value: ${calculator.getCurrentValue()}")
}
 */