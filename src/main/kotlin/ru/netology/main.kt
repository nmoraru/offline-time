package ru.netology

private const val MINUTE = 60
private const val HOUR = MINUTE * 60
private const val DAY = HOUR * 24

fun main() {
    println(agoToText(0))
    println(agoToText(MINUTE / 2))
    println(agoToText(MINUTE))
    println(agoToText(MINUTE * 24))
    println(agoToText(MINUTE * 21))
    println(agoToText(MINUTE * 22))
    println(agoToText(MINUTE * 25))

    println(agoToText(MINUTE + 1))
    println(agoToText(HOUR / 2))
    println(agoToText(HOUR))

    println(agoToText(HOUR + 1))
    println(agoToText(DAY / 2))
    println(agoToText(DAY))

    println(agoToText(DAY + 1))
    println(agoToText(DAY * 2))

    println(agoToText(DAY * 2 + 1))
    println(agoToText(DAY * 3))

    println(agoToText(DAY * 3 + 1))

}

fun agoToText(offlineTime: Int): String {
    return when {
        offlineTime in 0..MINUTE -> "Был(а) в сети только что"
        offlineTime in MINUTE + 1..HOUR -> "Был(а) в сети ${offlineTime / MINUTE} ${getMinute(offlineTime)} назад"
        offlineTime in HOUR + 1..DAY -> "Был(а) в сети ${offlineTime / HOUR} ${getHour(offlineTime)} назад"
        offlineTime in DAY + 1..DAY * 2 -> "Был(а) в сети сегодня"
        offlineTime in DAY * 2 + 1..DAY * 3 -> "Был(а) в сети вчера"
        else -> "Был(а) в сети давно"
    }
}

fun getMinute(offlineTime: Int): String {
    return when {
        offlineTime === 1 || (offlineTime / MINUTE != 11 && offlineTime / MINUTE % 10 === 1) -> "минуту"
        offlineTime in 2 * MINUTE..4 * MINUTE || (offlineTime !in 12 * MINUTE..14 * MINUTE
                && offlineTime / MINUTE % 10 in 2..4) -> "минуты"
        else -> "минут"
    }
}

fun getHour(offlineTime: Int): String {
    return when {
        offlineTime === 1 || (offlineTime / HOUR != 11 && offlineTime / HOUR % 10 === 1) -> "час"
        offlineTime in 2 * HOUR..4 * HOUR || (offlineTime !in 12 * HOUR..14 * HOUR
                && offlineTime / HOUR % 10 in 2..4) -> "часа"
        else -> "часов"
    }
}
