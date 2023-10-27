
class Main {

    fun main(args: Array<String>) {
        println(concat("def", "fef"))
        val num = 12L
        val square  = {number: Long -> number * number}

        lFun("HW"){ s -> 12L}


    }


    private fun lFun(string: String, oaf: OAF): Long {
        return 12L
    }

    private fun lFun2() = Debt(12, 12)

    private fun concat(vararg str: String): String {
        val list = arrayListOf<String>()
        list.addAll(str)
        return list.joinToString(".")
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


}

fun interface OAF {
    fun justDo(str: String): Long
}