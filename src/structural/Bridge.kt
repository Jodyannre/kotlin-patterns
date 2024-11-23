package structural/* Structural pattern - Bridge */
/* split a large class or a set of closely related classes into two separate
hierarchies—abstraction and implementation—which can be developed
independently of each other*/

interface Furniture{
    fun build()
}

class Chair(private val material:Material): Furniture{
    override fun build() = println("Building structural.Chair of ${material.collect()}")
}

class Table(private val material:Material): Furniture{
    override fun build() = println("Building structural.Table of ${material.collect()}")
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
    val woodTable:structural.Furniture = structural.Table(structural.Wood())
    woodTable.build()
    val metalTable:structural.Furniture = structural.Table(structural.Metal())
    metalTable.build()
    val plasticTable:structural.Furniture = structural.Table(structural.Plastic())
    plasticTable.build()
 */

