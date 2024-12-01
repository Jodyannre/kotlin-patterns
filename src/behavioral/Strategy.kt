package behavioral

/* Behavioral strategy pattern

is a behavioral design pattern that lets you define a family of algorithms,
put each of them into a separate class, and make their objects interchangeable.

 */

interface DiscountStrategy {
    fun calculate(amount: Double): Double
}

class RegularCustomerStrategy : DiscountStrategy {
    override fun calculate(amount: Double): Double {
        return amount * 0.05 // 5%
    }
}

class VipCustomerStrategy : DiscountStrategy {
    override fun calculate(amount: Double): Double {
        return amount * 0.10 // 10%
    }
}

class BusinessCustomerStrategy: DiscountStrategy {
    override fun calculate(amount: Double): Double {
        return amount * 0.15 // 15%
    }
}

enum class CustomerType {
    REGULAR,
    VIP,
    BUSINESS
}

//Context
class DiscountCalculator() {
    private lateinit var strategy: DiscountStrategy

    fun setStrategy(strategy: DiscountStrategy) {
        this.strategy = strategy
    }

    fun calculate(amount: Double): Double {
        return strategy.calculate(amount)
    }
}


/* Example of use

import behavioral.*

fun main() {

    //Create context
    val calculatorContext = DiscountCalculator()

    //Strategies

    val regularStrategy = RegularCustomerStrategy()
    val vipStrategy = VipCustomerStrategy()
    val businessStrategy = BusinessCustomerStrategy()

    //Using strategies to calcule discount

    calculatorContext.setStrategy(regularStrategy)

    println(calculatorContext.calculate(10.0))

    calculatorContext.setStrategy(vipStrategy)

    println(calculatorContext.calculate(10.0))

    calculatorContext.setStrategy(businessStrategy)

    println(calculatorContext.calculate(10.0))

}
 */