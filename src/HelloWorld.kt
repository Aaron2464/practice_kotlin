fun main(args: Array<String>) {
    println("${args.getOrNull(0)}")
    val name = "kotlin"
    var greeting = "hello"
    println("$greeting")
    println(listOf('a','b','c').joinToString(separator = "",prefix= "(", postfix = ")"))
    HelloWorld().pront()
}

class HelloWorld {
    fun pront(){
        print("132")
    }
}