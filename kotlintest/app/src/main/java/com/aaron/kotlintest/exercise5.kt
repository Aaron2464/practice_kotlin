package com.aaron.kotlintest

import kotlin.random.Random

fun main(args: Array<String>) {
//    println(rick)
    val r = getRandomInt()
    println(r)

    "Vancouver".run {
        println("Hello")
        println("Hello, $this")
    }

    val ages = mutableListOf<Int>()
    ages.also {
        println("I will sort the age list")
    }.apply {
        add(28)
        add(29)
    }.sort()

    val num = mutableListOf<String>("one", "two", "three")
    val count = num.run {
        add("four")
        add("five")
        add("six")

        count { it.endsWith("e") }
    }

    println(count)

    val nums = mutableListOf<String>("one", "two", "three")
    with(nums) {
        println("First: ${first()}, Last: ${last()}")
    }

    // 'let' is often used for executing a nullable code block
    val str: String? = "Vancouver"
    str.apply {
        this?.length
    }
    val length = str?.let {
        println("let() is called on $it")
        it.length
    }

    println(length)
}

fun getRandomInt(): Int {
    return Random.nextInt(100).also {
        println("Random num is $it")
    }
}

