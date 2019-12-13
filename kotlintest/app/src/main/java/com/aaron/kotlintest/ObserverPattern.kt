package com.aaron.kotlintest

interface Subject {
    fun attach(ob: Observer)

    fun detech(ob: Observer)

    fun notifyObservers()
}

interface Observer {
    fun update()
}

class ClockTimer() : Subject {
    private val oberrver: MutableList<Observer> = mutableListOf()
    var second: Int = 0
        private set

    override fun attach(ob: Observer) {
        oberrver.add(ob)
    }

    override fun detech(ob: Observer) {
        oberrver.remove(ob)
    }

    override fun notifyObservers() {
        oberrver.forEach {
            it.update()
        }
    }

    fun tick() {
        second += 1
        notifyObservers()
    }
}

class AnalogClock(private val subject: ClockTimer) : Observer {
    override fun update() {
        println("${subject.second}")
    }
}

class DigitalClock(private val subject: ClockTimer) : Observer {
    override fun update() {
        println("${subject.second}")
    }
}

fun main(args: Array<String>) {
    val timer = ClockTimer()
    timer.attach(AnalogClock(timer))
    timer.attach(DigitalClock(timer))

    timer.tick()
}