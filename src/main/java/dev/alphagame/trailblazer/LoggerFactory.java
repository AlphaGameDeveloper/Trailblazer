// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer;

import dev.alphagame.trailblazer.formatters.SimpleFormatter;
import dev.alphagame.trailblazer.formatters.JSONFormatter;
import dev.alphagame.trailblazer.formatters.ColumnedFormatter;

import java.io.PrintStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Factory for creating TBLogger instances.
 * Provides convenient methods for creating loggers with different configurations.
 */
public class LoggerFactory {
    private static final ConcurrentMap<String, TBLogger> loggerCache = new ConcurrentHashMap<>();
    private static LoggerConfiguration defaultConfiguration = new LoggerConfiguration();
    
    /**
     * Gets a logger with the specified name using the default configuration.
     * 
     * @param name The name of the logger.
     * @return A TBLogger instance.
     */
    public static TBLogger getLogger(String name) {
        return loggerCache.computeIfAbsent(name, n -> new TBLogger(n, defaultConfiguration));
    }
    
    /**
     * Gets a logger with the specified name and log level.
     * 
     * @param name The name of the logger.
     * @param logLevel The log level.
     * @return A TBLogger instance.
     */
    public static TBLogger getLogger(String name, LogLevel logLevel) {
        return loggerCache.computeIfAbsent(name + "_" + logLevel.name(), 
                n -> new TBLogger(name, logLevel));
    }
    
    /**
     * Gets a logger with the specified name and configuration.
     * 
     * @param name The name of the logger.
     * @param configuration The logger configuration.
     * @return A TBLogger instance.
     */
    public static TBLogger getLogger(String name, LoggerConfiguration configuration) {
        return loggerCache.computeIfAbsent(name + "_" + configuration.hashCode(), 
                n -> new TBLogger(name, configuration));
    }
    
    /**
     * Gets a logger for the specified class using the default configuration.
     * 
     * @param clazz The class to create a logger for.
     * @return A TBLogger instance.
     */
    public static TBLogger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }
    
    /**
     * Gets a logger for the specified class with the specified log level.
     * 
     * @param clazz The class to create a logger for.
     * @param logLevel The log level.
     * @return A TBLogger instance.
     */
    public static TBLogger getLogger(Class<?> clazz, LogLevel logLevel) {
        return getLogger(clazz.getName(), logLevel);
    }
    
    /**
     * Creates a simple logger with the default SimpleFormatter.
     * 
     * @param name The name of the logger.
     * @return A TBLogger instance with SimpleFormatter.
     */
    public static TBLogger createSimpleLogger(String name) {
        LoggerConfiguration config = new LoggerConfiguration(LogLevel.INFO, new SimpleFormatter());
        return new TBLogger(name, config);
    }
    
    /**
     * Creates a simple logger with the specified log level.
     * 
     * @param name The name of the logger.
     * @param logLevel The log level.
     * @return A TBLogger instance with SimpleFormatter.
     */
    public static TBLogger createSimpleLogger(String name, LogLevel logLevel) {
        LoggerConfiguration config = new LoggerConfiguration(logLevel, new SimpleFormatter());
        return new TBLogger(name, config);
    }
    
    /**
     * Creates a JSON logger that outputs logs in JSON format.
     * 
     * @param name The name of the logger.
     * @return A TBLogger instance with JSONFormatter.
     */
    public static TBLogger createJSONLogger(String name) {
        LoggerConfiguration config = new LoggerConfiguration(LogLevel.INFO, new JSONFormatter());
        return new TBLogger(name, config);
    }
    
    /**
     * Creates a JSON logger with the specified log level.
     * 
     * @param name The name of the logger.
     * @param logLevel The log level.
     * @return A TBLogger instance with JSONFormatter.
     */
    public static TBLogger createJSONLogger(String name, LogLevel logLevel) {
        LoggerConfiguration config = new LoggerConfiguration(logLevel, new JSONFormatter());
        return new TBLogger(name, config);
    }
    
    /**
     * Creates a columned logger that outputs logs in columned format.
     * 
     * @param name The name of the logger.
     * @return A TBLogger instance with ColumnedFormatter.
     */
    public static TBLogger createColumnedLogger(String name) {
        LoggerConfiguration config = new LoggerConfiguration(LogLevel.INFO, new ColumnedFormatter());
        return new TBLogger(name, config);
    }
    
    /**
     * Creates a columned logger with the specified log level.
     * 
     * @param name The name of the logger.
     * @param logLevel The log level.
     * @return A TBLogger instance with ColumnedFormatter.
     */
    public static TBLogger createColumnedLogger(String name, LogLevel logLevel) {
        LoggerConfiguration config = new LoggerConfiguration(logLevel, new ColumnedFormatter());
        return new TBLogger(name, config);
    }
    
    /**
     * Creates a logger that writes to the specified PrintStream.
     * 
     * @param name The name of the logger.
     * @param outputStream The output stream to write to.
     * @return A TBLogger instance.
     */
    public static TBLogger createLoggerWithStream(String name, PrintStream outputStream) {
        SimpleFormatter formatter = new SimpleFormatter(outputStream);
        LoggerConfiguration config = new LoggerConfiguration(LogLevel.INFO, formatter);
        return new TBLogger(name, config);
    }
    
    /**
     * Sets the default configuration for new loggers created by getLogger methods.
     * 
     * @param configuration The default configuration.
     */
    public static void setDefaultConfiguration(LoggerConfiguration configuration) {
        defaultConfiguration = configuration;
    }
    
    /**
     * Gets the default configuration.
     * 
     * @return The default configuration.
     */
    public static LoggerConfiguration getDefaultConfiguration() {
        return defaultConfiguration;
    }
    
    /**
     * Clears the logger cache.
     */
    public static void clearCache() {
        loggerCache.clear();
    }
}
