package kotlin_mm

    fun main(args: Array<String>) {

        val a1 = null
        val a2 = 1

        require(a1 != null || a2 != null) {
            "ERROR!!"
        }

    }
