package com.prs.swagger.util

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.write

class IdGgenerator {

    companion object {

        private val formatThreadLocal = object : ThreadLocal<SimpleDateFormat>() {
            override fun initialValue(): SimpleDateFormat = SimpleDateFormat("yyMMddHHmmss")
        }

        fun generateId(node: String = "10"): String  {
            return buildString {
                append(node)
                append(IdCounter.next())
                append((formatThreadLocal.get().format(Date())))
            }
        }
    }
}


class IdCounter {

    companion object {
        private const val MAX_COUNTER: Short = 10000
        private const val DECIMAL_FORMAT = "0000"

        private val FORMAT_THREAD_LOCAL = object : ThreadLocal<DecimalFormat>() {
            override fun initialValue(): DecimalFormat = DecimalFormat(DECIMAL_FORMAT)
        }

        private var counter : Short = 0
        private val lock = ReentrantReadWriteLock()

        fun next(): String {
            lock.write {
                counter++

                if (counter >= MAX_COUNTER) {
                    counter = 0
                }
                return FORMAT_THREAD_LOCAL.get().format(counter)
            }
        }
    }

}