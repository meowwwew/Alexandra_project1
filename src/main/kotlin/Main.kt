import java.lang.StringBuilder

fun main() {
    while (true) {
        println("0 выход")
        println("1 задача")
        println("2 задача")
        print("Выберите пункт меню: ")
        val menu = readln()
        when (menu) {
            "0" -> return
            "1" -> task1()
            else -> println("Неверный ввод")
        }
    }
}
fun task1() {
    println("Данная программа преобразовывет строку с буквами. Если 1 буква повторяется несколько раз, то программа вывлдит букву и её количество")
    println("Пожалуйста введите набор букв")

    var input = readln()
    if (!input.all { it.isLetter() }) {
        println("Вы можете вводить только буквы!")
        return
    }
    var result = StringBuilder()
    var count = 1
    for (i in 1..input.length - 1) {
        if (input[i] == input[i - 1]) {
            count++
        } else {
            result.append(input[i - 1])
            if (count > 1) result.append(count)
            count = 1
        }
    }
    result.append(input.last())
    if (count > 1) result.append(count)
    println(result.toString())
}
fun task2() {
    println("Данная программа подсчитывает количество различных различных символов во введённой строке")
    println("Пожалуйста введите набор букв")

    var input = readln()
    if (!input.all { it.isLetter() }) {
        println("Вы можете вводить только буквы!")
        return
    }
    var result: String = ""
    var count = input
        .groupingBy {  }
}

