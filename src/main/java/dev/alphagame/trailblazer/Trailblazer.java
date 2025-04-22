// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer;

/*
 * Trailblazer.java
 * 
 * This class provides a simple logging utility for people too lazy to use Log4J.
 * It formats log messages with a timestamp, log level, and caller information.
 */
public class Trailblazer {
    private static final boolean DEBUG_ENABLED = true;

    /**
     * Logs a debug message.
     * 
     * @param message The message to log
     */
    public static void debug(String message) {
        if (!DEBUG_ENABLED) return; // Skip debug messages if not enabled
        System.out.println(TBFormatter.formatLogMessage("DEBUG", message));
    }

    /**
     * Logs a debug message with arguments.
     * 
     * @param message The message to log with format specifiers
     * @param args The arguments to replace format specifiers
     */
    public static void debug(String message, Object... args) {
        if (!DEBUG_ENABLED) return; // Skip debug messages if not enabled
        System.out.println(TBFormatter.formatLogMessage("DEBUG", message, args));
    }
    
    /**
     * Logs an informational message.
     * 
     * @param message The message to log
     */
    public static void info(String message) {
        System.out.println(TBFormatter.formatLogMessage("INFO", message));
    }

    /**
     * Logs an informational message with arguments.
     * 
     * @param message The message to log with format specifiers
     * @param args The arguments to replace format specifiers
     */
    public static void info(String message, Object... args) {
        System.out.println(TBFormatter.formatLogMessage("INFO", message, args));
    }
    
    /**
     * Logs a warning message.
     * 
     * @param message The message to log
     */
    public static void warning(String message) {
        System.out.println(TBFormatter.formatLogMessage("WARN", message));
    }

    /**
     * Logs a warning message with arguments.
     * 
     * @param message The message to log with format specifiers
     * @param args The arguments to replace format specifiers
     */
    public static void warning(String message, Object... args) {
        System.out.println(TBFormatter.formatLogMessage("WARN", message, args));
    }
    
    /**
     * Logs an error message.
     * 
     * @param message The message to log
     */
    public static void error(String message) {
        System.err.println(TBFormatter.formatLogMessage("ERROR", message));
    }

    /**
     * Logs an error message with arguments.
     * 
     * @param message The message to log with format specifiers
     * @param args The arguments to replace format specifiers
     */
    public static void error(String message, Object... args) {
        System.err.println(TBFormatter.formatLogMessage("ERROR", message, args));
    }
    
    /**
     * Logs a fatal error message.String
     * 
     * @param message The message to log
     */
    public static void fatal(String message) {
        System.err.println(TBFormatter.formatLogMessage("FATAL", message));
    }

    /**
     * Logs a fatal error message with arguments.
     * 
     * @param message The message to log with format specifiers
     * @param args The arguments to replace format specifiers
     */
    public static void fatal(String message, Object... args) {
        System.err.println(TBFormatter.formatLogMessage("FATAL", message, args));
    }
}