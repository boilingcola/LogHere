package com.cola.ezlog

/**
 * Created by jay.
 * Date: 2020/8/25
 * Time: 11:23
 * Description:
 */
enum class LogLevel(var level: Int, var description: String) {
    VERBOSE(5, ""),
    DEBUG(4, ""),
    INFO(3, ""),
    WARN(2, ""),
    ERROR(1, ""),
    DISABLED(0, "");

    companion object {
        fun getByLevel(level: Int): LogLevel {
            for (logLevel in values()) {
                if (logLevel.level == level) return logLevel
            }
            return DISABLED
        }
    }
}