package com.aaron.kotlintest

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}

fun isValidIdentifier(s: String): Boolean {
    fun isValidChar(ch:Char) = ch == '_' || ch.isLetterOrDigit()

    if (s.isEmpty() || s[0].isDigit()) return false

    for (ch in s){
        if(!isValidChar(ch))return false
    }
    return true
}




