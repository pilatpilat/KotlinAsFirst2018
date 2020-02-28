@file:Suppress("UNUSED_PARAMETER")
package My

import lesson4.task1.factorize

/*
* сложение двух чисел
 */
fun adder(a: Int, b: Int): Int = a + b


/*
* вычисление корня числа. возвращается список из + и -
 */
fun mySqrt(x: Double): List<Double>{
    if (x < 0.0) return listOf()
    if (x == 0.0) return listOf<Double>(0.0)
    return listOf<Double>(-kotlin.math.sqrt(x), kotlin.math.sqrt(x))
}
/*
* вычисление корней квадратного уравнения
* результат возвращается в виде сортированного списка
 */
fun quadEquation(a: Double, b: Double, c: Double): List<Double> {
    val discriminant: Double
    if(a == 0.0)
        return if(b == 0.0) listOf() else listOf(-c / b)
    discriminant = b * b - 4 * a * c
    if(discriminant < 0.0) return listOf()
    if(discriminant == 0.0) return listOf(-b / (2 * a))
    val x1 = (-b + kotlin.math.sqrt(discriminant)) / (2.0 * a)
    val x2 = (-b - kotlin.math.sqrt(discriminant)) / (2.0 * a)
    return listOf(x1, x2).sorted()
}

fun main(args: Array<String>) {
    fun odd(x: Int, isOdd: Boolean = true) : Boolean {
        if(x%2 == 0) return isOdd
        return !isOdd
    }
    fun mySum(prev : Int, next : Int) : Int {return prev + next}
    println("My main function")
    val myList: MutableList<Int>
    myList = mutableListOf(10)
    myList.add(13)
    myList.add(10)
    myList.add(33)
    myList.add(myList.size, 66)
    val myList2 = myList.map{it * it}
    println("Mutable list $myList")
    println("Mutable list $myList2")
    val sum = myList.fold(0) {acc, it->mySum(acc, it)}
    println("Sum $sum")

}

fun main_old(args: Array<String>) {
    for(i in 2..100)
        println("$i: ${factorize(i)}")
}