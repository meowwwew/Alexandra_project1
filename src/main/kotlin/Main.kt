import java.lang.StringBuilder
import kotlin.math.*

fun main() {
    while (true) {
        println("0 выход")
        println("1 задача")
        println("2 задача")
        println("3 задача")
        println("4 задача")
        println("5 задача")
        println("6 задача")
        print("Выберите пункт меню: ")
        val menu = readln()
        when (menu) {
            "0" -> return
            "1" -> task1()
            "2" -> task2()
            "3" -> task3()
            "4" -> task4()
            "5" -> task5()
            "6" -> task6()
            else -> println("Неверный ввод")
        }
    }
}
fun task1() {
    println("Данная программа преобразовывет строку с буквами. Если 1 буква повторяется несколько раз, то программа выводит букву и её количество")
    println("Пожалуйста введите набор букв: ")

    var input = readln()
    if (!input.all { it.isLetter() }) {
        println("Вы можете вводить только буквы!")
        return
    }

    var result2 = ""
    var result = StringBuilder() //Хорошо для циклов, можно собирать, модифицировать и удалять данные, так же эффективнее по памяти
    var count = 1
    for (i in 1..input.length - 1) {
        if (input[i] == input[i - 1]) {
            count++
        } else {
            result.append(input[i - 1])
            result2 += input[i - 1]

            if (count > 1)
            {
                result.append(count)
                result2 += count
            }

            count = 1
        }
    }
    result.append(input.last())
    result2 += input.last()
    if (count > 1)
    {
        result.append(count)
        result2 += count
    }

    println(result.toString())
    println(result2)
}
fun task2() {
    println("Данная программа подсчитывает количество различных различных букв во введённой строке")
    println("Пожалуйста введите набор букв: ")

    val input = readLine() ?: "" //Если программа получит null, то переменная получит пустую строку
    if (!input.all { it.isLetter() }) {
        println("Вы можете вводить только буквы!")
        return
    }

    val letterList = input.groupingBy { it } //Специальная команда для группировки, it - текущий символ ('А' = [A, A, A]) и т.д.
        .eachCount() //Подсчёт элементов каждой группы А=3 и т.д.
        .toSortedMap() //Сортировка по алфавиту

    for ((char, count) in letterList) {
        println("$char - $count")
    }
}
fun task3() {
    println("Данная программа преобразует введённое десятичное число в двоичное")
    print("Введите натуральное число: ")
    val input = readLine()

    if (input != null && input.isNotEmpty()) {
        val number = input.toIntOrNull()

        if (number != null && number > 0) {
            val binary = number.toString(2) //Специальная команда для преобразования в двоичную систему
            println("Двоичная версия числа $number: $binary")
        } else {
            println("Ошибка: введите натуральное число больше 0.")
        }
    } else {
        println("Ошибка: введена пустая строка.")
    }
}
fun task4() {
    println("Данная программа запрашивает 2 числа через пробел и операцию между ними в конце, выводит результат рассчёта")
    println("Введите два числа и операцию через пробел (например: 5 3 +):")

    val input = readLine()

    if (input != null) {
        val parts = input.split(" ") //Метод split(" ") делит строку по пробелам в ней

        if (parts.size == 3) {
            val number1 = parts[0].toDoubleOrNull()
            val number2 = parts[1].toDoubleOrNull()
            val operation = parts[2]

            if (number1 != null && number2 != null) {
                val result = when (operation) {
                    "+" -> number1 + number2
                    "-" -> number1 - number2
                    "*" -> number1 * number2
                    "/" -> {
                        if (number2 != 0.0) number1 / number2
                        else {
                            println("Ошибка: деление на ноль!")
                            return
                        }
                    }
                    else -> {
                        println("Ошибка: неизвестная операция!")
                        return
                    }
                }
                if (result % 2 >= 0.0 && result % 2 <= 1.0) {
                    print("Результат: ")
                    println(result.toInt())
                } else {
                    print("Результат: ")
                println(String.format("%.2f", result)) //Вывод с двумя символами после точки
                }
            } else {
                println("Ошибка: введены не числа!")
            }
        } else {
            println("Ошибка: неверный формат ввода!")
        }
    } else {
        println("Ошибка: пустой ввод!")
    }
}
fun task5() {
    println("Данная программа запрашивает целое число n и основание степени x, узнает есть ли целочисленный показатель степени y для которого выполняется x^y = n")
    print("Введите целое число n: ")
    val n = readLine()?.toIntOrNull() ?: run {
        println("Некорректное число")
        return
    }

    print("Введите основание степени x: ")
    val x = readLine()?.toIntOrNull() ?: run {
        println("Некорректное основание")
        return
    }

    if (x == 0) {
        if (n == 0) {
            println("Любое целое y подходит") //Любая степень у числа 0 будет давать 0
        } else {
            println("Целочисленный показатель не существует")
        }
        return
    }

    if (x == 1) {
        if (n == 1) println("y может быть любое целое число") //Любая степень у числа 1 будет давать 1
        else println("Целочисленный показатель не существует")
        return
    }

    if (x == -1) {
        if (n == 1) println("y может быть любое чётное число") //Любая чётная степерь у числа -1 будет давать 1
        else if (n == -1) println("y может быть любое нечётное число") //Любая нечётная степерь у числа -1 будет давать -1
        else println("Целочисленный показатель не существует")
        return
    }

    var y = 0
    var power = 1L //1Long вместо инта (чтобы не было проблем с большыми числами)
    val absN = n.toLong()
    val absX = x.toLong()

    if ((x > 0 && n < 0) || (x < 0 && n > 0)) { //Степень положительного числа не может быть отрицательной, а степерь отрицательного не может дать положительного (кроме -1)
        println("Целочисленный показатель не существует")
        return
    }

    var current = 1L
    while (abs(current) <= absN) { //Цикл выполняется пока модуль текущей степени не превысил модуль n
        if (current == n.toLong()) {
            println("Целочисленный показатель y = $y")
            return
        }
        current *= x
        y++
    }

    println("Целочисленный показатель не существует")
}

fun task6() {
    println("Данная программа создаёт из 2 введённых цифр 2 числа, если какое то из чисел оказывается нечётным, то программа выводит его")

    fun readDigit(prompt: String): Int {
        while (true) {
            println(prompt)
            val input = readLine()
            if (input != null && input.length == 1 && input[0].isDigit()) {
                return input.toInt()
            } else {
                println("Ошибка: нужно ввести одну цифру от 0 до 9!")
            }
        }
    }
    val first = readDigit("Введите первую цифру:")
    val second = readDigit("Введите вторую цифру:")

    var result1: Int? = null
    var result2: Int? = null

    if (second % 2 == 1) {
        result1 = first * 10 + second
    }
    if (first % 2 == 1) {
        result2 = second * 10 + first
    }

    if (result1 == null && result2 == null) {
        println("Создать нечетное число невозможно")
    } else {
        println("Возможные нечетные числа:")
        if (result1 != null) println(result1)
        if (result2 != null) println(result2)
    }
}
