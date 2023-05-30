import java.util.function.Function
import java.util.stream.Collectors

fun main(args: Array<String>) {

    val man1 = Man(name = "Ruslan", age = 32L)
    val man2 = Man(name = "Tarlan", age = 31L)
    val man3 = Man(name = "Dima", age = 31L)

    val listMan = listOf(man1, man2, man3)

    val map: Map<Man, Long> =
        listMan.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    val map2 = listMan.map { it to it.age }.toMap()


    val manFinish = map.entries.stream().min { x1, x2 -> x1.value.compareTo(x2.value) }.get().key
    println(manFinish)
}


class Man(
    var name: String,
    val age: Long? = null

) {
    override fun toString(): String {
        return "Man(name='$name', age=$age)"
    }
}