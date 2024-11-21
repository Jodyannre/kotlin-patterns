/* Structural pattern Flyweight
is a structural design pattern that lets you fit more objects into the available amount
of RAM by sharing common parts of state between multiple objects instead of keeping all of
the data in each object.
 */

import java.awt.*
import javax.swing.JFrame

class TreeType(private val name:String, private val color: Color) {
    fun draw(g: Graphics, x: Int, y: Int) {
        g.color = Color.BLACK;
        g.fillRect(x-1, y, 3, 5)
        g.color = color
        g.fillOval(x-5, y-10, 10, 10)
    }
}


class Tree(private val x: Int,
           private val y: Int,
           private val type: TreeType) {

    fun draw(g: Graphics) {
        type.draw(g, x, y)
    }
}


class TreeTypeFactory {
    companion object {
        private val treeTypes: HashMap<String, TreeType> = hashMapOf()

        fun getTreeType(name: String, color: Color): TreeType {
            return treeTypes.getOrPut(name) { TreeType(name, color) }
        }
    }
}

class Forest(): JFrame() {

    private val trees: MutableList<Tree> = mutableListOf()

    fun plantTree(x: Int, y: Int, name: String, color: Color) {
        val treeType = TreeTypeFactory.getTreeType(name, color)
        trees.add(Tree(x, y, treeType))
    }

    override fun paint(g: Graphics) {
        for (tree in trees) {
            tree.draw(g);
        }
    }
}


/* Example of use

import java.awt.Color

fun random(min: Int, max: Int): Int {
        return (min + Math.random()*(max-min)+1).toInt()
}

fun main() {
        val canvasSize = 1000
        val numTreesToDraw = 1000
        val numTreeTypes = 4

        val forest = Forest();
        for (i in 0..numTreesToDraw/numTreeTypes) {
                forest.plantTree(random(0, canvasSize), random(0, canvasSize), "Summer Oak", Color.GREEN)
                forest.plantTree(random(0, canvasSize), random(0, canvasSize), "Autumn Oak", Color.ORANGE)
                forest.plantTree(random(0, canvasSize), random(0, canvasSize), "Spring Oak", Color.YELLOW)
                forest.plantTree(random(0, canvasSize), random(0, canvasSize), "Winter Oak", Color.BLUE)
        }
        forest.setSize(canvasSize, canvasSize);
        forest.isVisible = true;
}
 */