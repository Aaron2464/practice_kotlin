package com.aaron.assignment2

import com.aaron.assignment2.decor.Decoration

fun buildAquarium() {
//    val aquarium1 = Aquarium()
//    aquarium1.printSize()
//    val aquarium2 = Aquarium(width = 25)
//    aquarium2.printSize()
//    val aquarium3 = Aquarium(height = 35, length = 110)
//    aquarium3.printSize()
//    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
//    aquarium4.printSize()

//    val aquarium6 = Aquarium(numberOfFish = 29)
//    aquarium6.printSize()
//    aquarium6.volume = 70
//    aquarium6.printSize()
//    println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} l")

    val aquarium7 = Aquarium(length = 25, width = 25, height = 40)
    aquarium7.printSize()

    val myTowerTank = TowerTank(diameter = 25, height = 40)
    myTowerTank.printSize()
}

fun makeFish(){
    val shark = Shark()
    val plecostomus = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${plecostomus.color}")
    plecostomus.eat()
}
fun main() {
    buildAquarium()
    makeFish()
}