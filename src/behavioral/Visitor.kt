package behavioral

interface Visitable {
    fun accept(visitor: Visitor)
}

interface Visitor {
    fun accept(circle:Circle)
    fun accept(square:Square)
}

class AreaVisitor : Visitor {

    override fun accept(circle:Circle){
        println("Area of Circle: ${Math.PI * circle.radius * circle.radius}")
    }

    override fun accept(square:Square){
        println("Area of Square: ${square.side * square.side}")
    }
}

class Circle(val radius: Double): Visitable {
    override fun accept(visitor: Visitor) {
        visitor.accept(this)
    }
}

class Square(val side: Double): Visitable {
    override fun accept(visitor: Visitor) {
        visitor.accept(this)
    }
}


/* Example of use

fun main() {
    val circle = Circle(11.5)
    val square = Square(5.1)
    val areaVisitor = AreaVisitor()

    circle.accept(areaVisitor)
    square.accept(areaVisitor)
}
 */


/* Example 2 */

// Interfaz que representa un elemento que acepta un visitante
interface Employee {
    fun accept(visitor: EmployeeVisitor)
}

// Clases concretas que implementan Employee
class Manager(val name: String, val teamSize: Int) : Employee {
    override fun accept(visitor: EmployeeVisitor) {
        visitor.visitManager(this)
    }
}

class Developer(val name: String, val programmingLanguage: String) : Employee {
    override fun accept(visitor: EmployeeVisitor) {
        visitor.visitDeveloper(this)
    }
}

// Interfaz del Visitor
interface EmployeeVisitor {
    fun visitManager(manager: Manager)
    fun visitDeveloper(developer: Developer)
}

// Implementación concreta del Visitor para generar un reporte de horas trabajadas
class WorkHoursReportVisitor : EmployeeVisitor {
    override fun visitManager(manager: Manager) {
        println("Manager ${manager.name} supervisa un equipo de ${manager.teamSize} personas.")
    }

    override fun visitDeveloper(developer: Developer) {
        println("Developer ${developer.name} trabaja en ${developer.programmingLanguage}.")
    }
}

// Implementación concreta del Visitor para calcular salarios
class SalaryReportVisitor : EmployeeVisitor {
    override fun visitManager(manager: Manager) {
        println("Manager ${manager.name} tiene un salario de \$${manager.teamSize * 1000}.")
    }

    override fun visitDeveloper(developer: Developer) {
        println("Developer ${developer.name} gana \$5000.")
    }
}

// Uso del patrón Visitor
/*
fun main() {
    // Lista de empleados
    val employees: List<Employee> = listOf(
        Manager("Alice", 5),
        Developer("Bob", "Kotlin"),
        Manager("Charlie", 10),
        Developer("Diana", "Java")
    )

    // Crear visitantes
    val workHoursReport = WorkHoursReportVisitor()
    val salaryReport = SalaryReportVisitor()

    // Aplicar visitantes a los empleados
    println("Reporte de horas trabajadas:")
    employees.forEach { it.accept(workHoursReport) }

    println("\nReporte de salarios:")
    employees.forEach { it.accept(salaryReport) }
}
*/