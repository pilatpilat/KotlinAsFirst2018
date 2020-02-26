@file:Suppress("UNUSED_PARAMETER")
package lesson2.task2

import kotlin.math.pow
import lesson1.task1.sqr

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/*
* Функция powInt
*  возводит целое в степень целого.
 */
fun powInt(number: Int, exponent : Int): Int {
    var ret = number
    if (exponent == 0) return 1
    for (i in 1..(exponent - 1))
        ret = ret * number
    return ret
}
/*
* функция getDigit
* возвращает значение десятичной цифры числа number в позиции pos
 */

fun getDigit(number : Int, pos : Int) : Int {
    if (pos <= 0) return 0
    return (number % powInt(10, pos) ) / powInt(10, pos - 1)
}
/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    if (getDigit(number, 1) + getDigit(number, 2) == getDigit(number, 3) + getDigit(number, 4))
        return true else return false
}
/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    if(x1 == x2 || y1 == y2) return true
    if(x1 - y1 == x2 - y2 ) return true
    if(x1 + y1 == x2 + y2) return true
    return false
}

/*
*
* Проверка, является ли год високосным
 */

fun isYearLeap(year: Int): Boolean {
    if(year % 4 != 0) return false
    if(year % 100 != 0) return true
    if(year % 400 == 0) return true
    return false
}

/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    if (month == 2)
        if(isYearLeap(year)) return 29 else return 28
    when(month) {
        1, 3, 5, 7, 8, 10, 12 -> return 31
        else -> return 30
    }
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean {
    /*
    *  окружность лежит целиком в другой окрежности если r2 >= расстояние (C1, C2) + r1
    *  расстояние равно sqrt((x2 - x1)^2 + (y2 - y1)^2)
     */
    val M: Double
    M = kotlin.math.sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))
    return r2 >= M + r1
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    val arr = arrayOf(a, b, c)
    arr.sort()
    if(arr[0] <= kotlin.math.min(r, s) && arr[1] <= kotlin.math.max(r,s)) return true else return false
}
