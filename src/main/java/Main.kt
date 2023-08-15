import java.util.TreeSet

fun main(args: Array<String>) {
    val debtsAre = listOf(Debt(1, 200), Debt(2, 300))
    val debtComes = listOf(Debt(1, 100), Debt(3, 300))

    //{Debt(1, 200), Debt(2, 300)} - table billInDebt -> ::removeIf -> {Debt(2, 300)} -> to upset 0 - на обнуление

    //{Debt(1, 100), Debt(3, 300), Debt(1, 200)} - debt-info-s ->  -> to upset save/update



    val comparator: Comparator<Debt> = Comparator.comparing(Debt::id).thenComparing(Comparator.comparing(Debt::debt))
    val debtSet = TreeSet(comparator)

//    debtSet.addAll(debtComes)

    debtSet.add(Debt(1, 200))
    debtSet.add(Debt(1, 200))

    println("TreeSet is - $debtSet")




}



class Man(
    var name: String,
    val age: Long? = null

) {
    override fun toString(): String {
        return "Man(name='$name', age=$age)"
    }
}

class Debt(
    val id: Long,
    val debt: Long
) {
    override fun toString(): String {
        return "Debt(id=$id, debt=$debt)"
    }
}