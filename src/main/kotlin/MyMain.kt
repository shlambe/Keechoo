private lateinit var user1: Mates
private lateinit var user2: Mates
private lateinit var user3: Mates
private lateinit var user4: Mates

enum class Expense {
    EQUAL,
    EXACT,
    PERCENT
}

data class Mates(val name: String, var oweMap: HashMap<String, Int>)

fun main(args: Array<String>) {
    user1 = Mates("u1", hashMapOf())
    user2 = Mates("u2", hashMapOf())
    user3 = Mates("u3", hashMapOf())
    user4 = Mates("u4", hashMapOf())
//    val input = readLine()
//    println(input)
    show()
    show(user1)
//    EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL
    splitWise(user1, 1000, 4, listOf(user1, user2, user3, user4), Expense.EQUAL)
//    show(user4)
//    show(user1)

//    EXPENSE u1 1250 2 u2 u3 EXACT 370 880
    splitWise(user1, 1250, 2, listOf(user2, user3), Expense.EXACT, listOf(370, 880))
//    show()
//    EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
    splitWise(user4, 1200, 4, listOf(user1,user2, user3,user4), Expense.PERCENT, listOf(40,20,20,20))


}

fun splitWise(
    payer: Mates,
    amount: Int,
    peepCount: Int,
    payeeList: List<Mates>,
    expenseType: Expense,
    exactSumList: List<Int> = listOf()
) {
    when (expenseType) {
        Expense.EQUAL -> {
            val splitAmount = amount / peepCount
            for (payee in payeeList) {
//                user.oweMap[payer.name] = splitAmount
                payee.oweMap.put(payer.name,splitAmount)
                if (payee.name != payer.name) {
                    println("${payee.name} owes ${payer.name} :  ${payee.oweMap[payer.name]}\n")
                }
            }
        }
        Expense.EXACT -> {
            payeeList.forEachIndexed { index, payee ->
//                mates.oweMap[payer.name] = mates.oweMap[payer.name]?.plus(exactSumList[index]) as Int
                if(payee.oweMap.contains(payer.name))
                {
                    payee.oweMap[payer.name] = payee.oweMap[payer.name]?.plus(exactSumList[index]) as Int
                }else{
                    payee.oweMap[payer.name] = exactSumList[index]
                }
//                calculateSum(mates.oweMap.values)
                println("${payee.name} owes ${payer.name} : ${calculateSum(payee.oweMap.values)}\n")
            }

        }
        //    EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20

        Expense.PERCENT -> {
            payeeList.forEachIndexed { index, mates ->
//                println(amount/100 * exactSumList[index])

                /*    a -> b10
                      b -> a5

                *
                * */
                if(mates.oweMap.contains(payer.name))
                {
                    mates.oweMap[payer.name] = mates.oweMap[payer.name]?.plus(amount/100 * exactSumList[index]) as Int
                }
                else{
                    mates.oweMap.put(payer.name,amount/100 * exactSumList[index] as Int)
                }

//                ${calculateSum(mates.oweMap.values)}
                println("${mates.name} owes ${payer.name} :${calculateSum(mates.oweMap.values)}\n")
            }
        }
    }

}

fun calculateSum(values: MutableCollection<Int>):Int {
    var result = 0
    for (i in values){
        result += i
    }
    return result
}

fun show(mate: Mates) {
    if (mate.oweMap.isNotEmpty())
        mate.oweMap.forEach { item ->
            println("${mate.name} owes ${item.key} :  ${item.value} ")
        }
    else
        println("No Balances")
}

fun show() {
    if (user1.oweMap.isEmpty() && user2.oweMap.isEmpty() && user3.oweMap.isEmpty() && user4.oweMap.isEmpty()) {
        println("No Balances")
    } else {
        user1.oweMap.forEach { item ->
            println("${user1.name} owes ${item.key} :  ${item.value} ")
        }
        user2.oweMap.forEach { item ->
            println("${user2.name} owes ${item.key} :  ${item.value} ")
        }
        user3.oweMap.forEach { item ->
            println("${user3.name} owes ${item.key} :  ${item.value} ")
        }
        user4.oweMap.forEach { item ->
            println("${user4.name} owes ${item.key} :  ${item.value} ")
        }
    }

}


//fun main(args: Array<String>) {
//    Input: u1 1000 4 u1 u2 u3 u4 EQUAL

//    User2 owes User1: 250 (0+250)
//    User3 owes User1: 250 (0+250)
//    User4 owes User1: 250 (0+250)
//    splitWisely(1000)


//        printHello("poiuy")
//    val result = MyTest().square(9)
//      val result = MyTest() square 9
//    println(result)
//}

fun splitWisely(amount: Long) {
    val flatMates = 4
    val splitAmount = amount / flatMates
    for (i in 2..flatMates) {
        println("User$i owes User1: $splitAmount (0+$splitAmount)")
    }

}

//class MyTest{
//
//    infix fun square(n : Int): Int{
//        val num = n * n
//        return num
//    }
//}

//fun printHello(_name :String = "qwerty") {
//    arrayOf(1,2,3)[1]= 9
//    listOf(1,2,3)
//    if((1>2) and (2<3)){
//
//    }
//***************************************
//    var name: String by Delegates.observable(_name) { prop, old, new ->
//        println("Name changed from $old to $new")
////        _name = new
//    }
//    println("""sj
//
//    """.trimMargin())
//    val a = arrayOf<String>(3)
// println(n)

//    for (y in 1..100) y+=2
//    sequence<> {  }

//class MyMain
