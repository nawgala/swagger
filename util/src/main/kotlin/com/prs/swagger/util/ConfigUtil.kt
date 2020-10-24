package com.prs.swagger.util

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory




class ConfigUtil {
    companion object {
        var CONFIG : Config = ConfigFactory.load("application.conf")

        @JvmStatic
        val SERVER_CONFIG = CONFIG.getConfig("xcap.server")

        @JvmStatic
        val SIGTRAN_CONFIG = CONFIG.getConfig("sigtran.connector")

        inline fun getString(property: String, config: Config) : String = config.getString(property)

        inline fun getServerProperty(property: String) : String = SERVER_CONFIG.getString(property)

        inline fun getServerPropertyInt(property: String): Int = SERVER_CONFIG.getInt(property)

        inline fun getServerPropertyList(property: String): List<String> = SERVER_CONFIG.getStringList(property)

        inline fun getSigtranProperty(property: String) : String = SIGTRAN_CONFIG.getString(property)

        inline fun getSigtranPropertyInt(property: String) : Int = SIGTRAN_CONFIG.getInt(property)

        inline fun getSigtranPropertyConfig(property: String): Config = SIGTRAN_CONFIG.getConfig(property)

        inline fun getSigtranPropertyBoolean(property: String) : Boolean = SIGTRAN_CONFIG.getBoolean(property)

        inline fun getSigtranPropertyLong(property: String) : Long = SIGTRAN_CONFIG.getLong(property)

    }
}