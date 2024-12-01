package structural/* Structural pattern Decorator */
/*
Is a structural design pattern that lets you attach new behaviors to objects
by placing these objects inside special wrapper objects that contain the behaviors
 */

interface Enemy {
    fun attack(): String
    fun defense(): Int
}

class BasicEnemy: Enemy {
    override fun attack() = "Basic attack"
    override fun defense() = 10
}


abstract class EnemyDecorator(private val enemy: Enemy): Enemy {
    override fun attack() = enemy.attack()
    override fun defense() = enemy.defense()
}

class LightArmor(enemy:Enemy): EnemyDecorator(enemy) {
    override fun defense() = super.defense() + 10
    override fun attack() = "${super.attack()} (Protected by Light Armor)"

}

class HeavyArmor(enemy:Enemy): EnemyDecorator(enemy) {
    override fun defense() = super.defense() + 20
    override fun attack() = "${super.attack()} (Protected by Heavy Armor)"
}

class Sword(enemy:Enemy): EnemyDecorator(enemy) {
    override fun attack() = "${super.attack()} (It has a structural.Sword)"
}

class Bow(enemy:Enemy): EnemyDecorator(enemy) {
    override fun attack() = "${super.attack()} (It has a structural.Bow)"
}


/* Example of use
    var enemy: Enemy = BasicEnemy()
    enemy = LightArmor(enemy)
    enemy = Sword(enemy)
    enemy = Bow(enemy)

    println(enemy.attack())
    println(enemy.defense())

    var heavyEnemy = Sword(HeavyArmor(BasicEnemy()))
    var lightEnemy = Bow(LightArmor(BasicEnemy()))
    println("---------------------------------------------------------")
    println("Heavy enemy")
    println(heavyEnemy.attack())
    println(heavyEnemy.defense())
    println("---------------------------------------------------------")
    println("Light enemy")
    println(lightEnemy.attack())
    println(lightEnemy.defense())
    println("---------------------------------------------------------")
 */