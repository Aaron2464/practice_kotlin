package com.aaron.assignment2.decor

import com.aaron.assignment2.TowerTank

data class Decoration(val rocks: String)
data class Decoration2(val rocks: String, val wood: String, val diver: String)
enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF)
}

enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when (seal) {
        is Walrus -> "Walrus"
        is SeaLion -> "sea lion"
    }
}

fun makeDecorations() {

    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

    println(decoration1.equals(decoration2))
    println(decoration3.equals(decoration2))

    val decoration5 = Decoration2("crystal", "wood", "diver")
    println(decoration5)

//    val (rock, wood, diver) = decoration5
    val (rock, _, diver) = decoration5
    println(rock)
//    println(wood)
    println(diver)
}

fun main() {
    makeDecorations()
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)
}