import java.lang.StringBuilder

fun main() {

    var testD = "AAADSSSRRTTHAAAA"
    var result = StringBuilder()
    var count = 1
    println("Данная программа преобразовывет строку с буквами. Если 1 буква повторяется несколько раз, то программа вывлдит букву и её количество")
    for (i in 1..testD.length-1) {
        if (testD[i] == testD[i - 1]) {
            count++
        } else {
            result.append(testD[i - 1])
            if (count > 1) result.append(count)
            count = 1
        }
    }
    result.append(testD.last())
    if (count > 1) result.append(count)
    println(result.toString())
}