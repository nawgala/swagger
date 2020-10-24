package com.prs.swagger.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory


class Constant {
    companion object {

        fun getLogger(clazz: Class<*>) : Logger = LoggerFactory.getLogger(clazz)

        @JvmStatic
        val APP_CONF_FILE = "application.conf"

        @JvmStatic
        val SERVER_CONFIG : String = "xcap.server"

        @JvmStatic
        val SIGTRAN_CONFIG = "sigtran.connector"
    }
}

