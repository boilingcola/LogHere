package com.cola.ezlog

import android.util.Log
import com.cola.ezlog.LogLevel.Companion.getByLevel

/**
 * Date-Time : 2019/8/1 - 15:58
 * WeekDay : 星期四
 *
 * @author jay
 * PackageName : com.potevio.tms.tools
 * Description:
 */
object EzLog {
    private val TAG = EzLog::class.java.simpleName
    private var currentTLevel = LogLevel.DISABLED.level

    /**
     * 是否开启日志
     */
    private var isOpenLog = true
    fun v(tag: String, msg: String) {
        if (isOpenLog && currentTLevel >= LogLevel.VERBOSE.level) {
            val stackTraceElement = Thread.currentThread()
                .stackTrace[3]
            logAndWrite(tag, LogLevel.VERBOSE.level, msg + getAdditionalInfo(stackTraceElement))
        }
    }

    fun v(tag: String, msg: String, tr: Throwable) {
        if (isOpenLog && currentTLevel >= LogLevel.VERBOSE.level) {
            val stackTraceElement = Thread.currentThread()
                .stackTrace[3]
            logAndWrite(tag, LogLevel.VERBOSE.level, msg + getAdditionalInfo(stackTraceElement), tr)
        }
    }

    fun d(tag: String, msg: String) {
        if (isOpenLog && currentTLevel >= LogLevel.DEBUG.level) {
            val stackTraceElement = Thread.currentThread()
                .stackTrace[3]
            logAndWrite(tag, LogLevel.DEBUG.level, msg + getAdditionalInfo(stackTraceElement))
        }
    }

    fun d(tag: String, msg: String, tr: Throwable) {
        if (isOpenLog && currentTLevel >= LogLevel.DEBUG.level) {
            val stackTraceElement = Thread.currentThread()
                .stackTrace[3]
            logAndWrite(tag, LogLevel.DEBUG.level, msg + getAdditionalInfo(stackTraceElement), tr)
        }
    }

    fun i(tag: String, msg: String) {
        if (isOpenLog && currentTLevel >= LogLevel.INFO.level) {
            val stackTraceElement = Thread.currentThread()
                .stackTrace[3]
            logAndWrite(tag, LogLevel.INFO.level, msg + getAdditionalInfo(stackTraceElement))
        }
    }

    fun i(tag: String, msg: String, tr: Throwable) {
        if (isOpenLog && currentTLevel >= LogLevel.INFO.level) {
            val stackTraceElement = Thread.currentThread()
                .stackTrace[3]
            logAndWrite(tag, LogLevel.INFO.level, msg + getAdditionalInfo(stackTraceElement), tr)
        }
    }

    fun w(tag: String, msg: String) {
        if (isOpenLog && currentTLevel >= LogLevel.WARN.level) {
            val stackTraceElement = Thread.currentThread()
                .stackTrace[3]
            logAndWrite(tag, LogLevel.WARN.level, msg + getAdditionalInfo(stackTraceElement))
        }
    }

    fun w(tag: String, msg: String, tr: Throwable) {
        if (isOpenLog && currentTLevel >= LogLevel.WARN.level) {
            val stackTraceElement = Thread.currentThread()
                .stackTrace[3]
            logAndWrite(tag, LogLevel.WARN.level, msg + getAdditionalInfo(stackTraceElement), tr)
        }
    }

    fun e(tag: String, msg: String) {
        if (isOpenLog && currentTLevel >= LogLevel.ERROR.level) {
            val stackTraceElement = Thread.currentThread()
                .stackTrace[3]
            logAndWrite(tag, LogLevel.ERROR.level, msg + getAdditionalInfo(stackTraceElement))
        }
    }

    fun e(tag: String, msg: String, tr: Throwable) {
        if (isOpenLog && currentTLevel >= LogLevel.ERROR.level) {
            val stackTraceElement = Thread.currentThread()
                .stackTrace[3]
            logAndWrite(tag, LogLevel.ERROR.level, msg + getAdditionalInfo(stackTraceElement), tr)
        }
    }

    private fun logAndWrite(tag: String, logLevel: Int, msg: String) {
        when (getByLevel(logLevel)) {
            LogLevel.ERROR -> Log.e(tag, msg)
            LogLevel.WARN -> Log.w(tag, msg)
            LogLevel.INFO -> Log.i(tag, msg)
            LogLevel.DEBUG -> Log.d(tag, msg)
            LogLevel.VERBOSE -> Log.v(tag, msg)
            else -> {
            }
        }
    }

    private fun logAndWrite(tag: String, logLevel: Int, msg: String, tr: Throwable) {
        when (getByLevel(logLevel)) {
            LogLevel.ERROR -> Log.e(tag, msg, tr)
            LogLevel.WARN -> Log.w(tag, msg, tr)
            LogLevel.INFO -> Log.i(tag, msg, tr)
            LogLevel.DEBUG -> Log.d(tag, msg, tr)
            LogLevel.VERBOSE -> Log.v(tag, msg, tr)
            else -> {
            }
        }
    }

    private fun getAdditionalInfo(stackTraceElement: StackTraceElement): String {
        val stringBuilder = StringBuilder()
        /* 获取线程名 */
        val threadName = Thread.currentThread().name
        /* 获取类名 */
        val className = stackTraceElement.className
        /* 获取方法名 */
        val methodName = stackTraceElement.methodName
        /* 获取打印Log的行数 */
        val lineNumber = stackTraceElement.lineNumber
        return "" //                stringBuilder.append("\n -------- threadname: ").append(threadName)
        //                .append(";  class : ").append(className).append("; linenumber : ").append(lineNumber)
        //                .toString()
    }

    fun setlogOpen(isOpen: Boolean) {
        isOpenLog = isOpen
    }

    var logLevel: Int
        get() = currentTLevel
        set(level) {
            Log.i(TAG, "currentLevel is :$currentTLevel to set : $level")
            if (currentTLevel != level) {
                currentTLevel = level
            } else {
                Log.w(TAG, "log level is not change , no need to reset.")
            }
        }
}