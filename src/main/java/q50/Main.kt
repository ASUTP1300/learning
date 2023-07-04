package q50


    fun main(args: Array<String>) {
        print("HW")

        val list = listOf<Int>(12, 13, 14, 15)
        val map = list.groupBy{x -> x > 13}

        print(map)

    }


