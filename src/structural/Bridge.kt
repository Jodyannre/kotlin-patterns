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
    val woodTable:Furniture = Table(Wood() )
    woodTable.build()
    val metalTable:Furniture = Table(Metal())
    metalTable.build()
    val plasticTable:Furniture = Table(Plastic())
    plasticTable.build()
 */



/* Other Example */

interface Device {
    fun turnOn()
    fun turnOff()
    fun setVolumen(volume: Int)
}

class Tv: Device {
    override fun turnOff() {
        println("Turning off")
    }
    override fun setVolumen(volume: Int) {
        println("Set volume $volume")
    }
    override fun turnOn() {
        println("Turning on")
    }
}

class Radio: Device{
    override fun turnOff() {
        println("Turning off")
    }
    override fun setVolumen(volume: Int) {
        println("Set volume $volume")
    }
    override fun turnOn() {
        println("Turning on")
    }
}

open class RemoteControl(protected var device: Device) {
    open fun turnOn() {
        println("Remote: Turning on the device.")
        device.turnOn()
    }

    open fun turnOff() {
        println("Remote: Turning off the device.")
        device.turnOff()
    }

    open fun setVolume(volume: Int) {
        println("Remote: Setting volume to $volume.")
        device.setVolumen(volume)
    }
}


class AdvancedRemoteControl(device: Device) : RemoteControl(device) {
    fun mute() {
        println("AdvancedRemote: Muting the device.")
        device.setVolumen(0)
    }
}


/* Example of use
fun main() {

    val radio = Radio()
    val tv = Tv()

    val tvControl = RemoteControl(tv)

    tvControl.turnOn()
    tvControl.turnOff()
    tvControl.setVolume(15)

    val advanceRadioControl = AdvancedRemoteControl(radio)
    advanceRadioControl.mute()
}
 */
