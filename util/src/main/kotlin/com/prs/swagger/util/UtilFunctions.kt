package com.prs.swagger.util

fun extractStringValue(str: String, field: String): String {
    val filedWithEq: String = "$field="
    val index = str.indexOf(filedWithEq)
    return if (index > -1) {
        val from = str.indexOf("\"", index) + 1
        val to = str.indexOf("\"", from)
        str.substring(from, to)
    } else {
        ""
    }
}

fun extractNumberValue(str: String, field: String): String {
    val filedWithEq: String = "$field="
    val index = str.indexOf(filedWithEq)
    return if (index > -1) {
        val from = index + filedWithEq.length
        var to = str.indexOf(",", from)
        if(to < 0){
            to = str.length //This is the last item in the list
        }
        str.substring(from, to)
    } else {
        ""
    }
}

fun getRequestNumber(userName : String, cNonce : String): Int {
    return try {
        if (userName.isNotEmpty()) {
            userName.substring(0, userName.indexOf("@")).toInt()
        } else {
            -1
        }
    } catch (e: Exception) {
        return 4
    }
}

fun extractAlgo(str: String): String {
    val index = str.indexOf("algorithm=")
    return if (index > -1) {
        val from = str.indexOf("=", index) + 1
        val lastSpace = str.indexOf(" ", index)

        val to = if (lastSpace > 0) lastSpace else str.length
        str.substring(from, to)
    } else {
        ""
    }
}