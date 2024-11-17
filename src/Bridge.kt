/* Structural pattern - Bridge */
/* split a large class or a set of closely related classes into two separate
hierarchies—abstraction and implementation—which can be developed
independently of each other*/

interface Furniture{
    fun build()
}

class Chair(private val material:Material): Furniture{
    override fun build() = println("Building Chair of ${material.collect()}")
}

class Table(private val material:Material): Furniture{
    override fun build() = println("Building Table of ${material.collect()}")
}

interface Material{
    fun collect(): String
}

class Wood: Material{
    override fun collect() = "wood"
}

class Metal: Material{
    override fun collect() = "metal"
}

class Plastic: Material{
    override fun collect() = "plastic"
}


/* Example of use*/
/*
    val woodTable:Furniture = Table(Wood())
    woodTable.build()
    val metalTable:Furniture = Table(Metal())
    metalTable.build()
    val plasticTable:Furniture = Table(Plastic())
    plasticTable.build()
 */

