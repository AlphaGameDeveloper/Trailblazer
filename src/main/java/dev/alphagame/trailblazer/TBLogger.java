// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT
package dev.alphagame.trailblazer;

public class TBLogger {
    private final String loggerName;
    private LogLevel logLevel;
    private LoggerConfiguration configuration;

    public TBLogger(String name, LoggerConfiguration configuration) {
        this.loggerName = name;
        this.configuration = configuration;
        this.logLevel = configuration.logLevel;
    }

    public TBLogger(String name, LogLevel logLevel) {
        this.loggerName = name;
        this.configuration = new LoggerConfiguration();
        this.configuration.logLevel = logLevel;
        this.logLevel = logLevel;
    }

    /**
     * Logs a message with the INFO level.
     *
     * @param message The message to log.
     * @param args    The arguments to format the message with.
     */
    public void info(String message, Object... args) {
        if (this.logLevel.getLevel() <= LogLevel.INFO.getLevel()) {
            configuration.formatter.formatLogMessage("INFO", message, args);
        }
    }

    /**
     * Logs a message with the INFO level.
     *
     * @param message The message to log.
     */
    public void info(String message) {
        if (this.logLevel.getLevel() <= LogLevel.INFO.getLevel()) {
            configuration.formatter.formatLogMessage("INFO", message);
        }
    }

    /**
     * Logs a message with the DEBUG level.
     *
     * @param message The message to log.
     * @param args    The arguments to format the message with.
     */
    public void debug(String message, Object... args) {
        if (this.logLevel.getLevel() <= LogLevel.DEBUG.getLevel()) {
            configuration.formatter.formatLogMessage("DEBUG", message, args);
        }
    }

    /**
     * Logs a message with the DEBUG level.
     *
     * @param message The message to log.
     */
    public void debug(String message) {
        if (this.logLevel.getLevel() <= LogLevel.DEBUG.getLevel()) {
            configuration.formatter.formatLogMessage("DEBUG", message);
        }
    }

    /**
     * Logs a message with the WARN level.
     *
     * @param message The message to log.
     * @param args    The arguments to format the message with.
     */
    public void warn(String message, Object... args) {
        if (this.logLevel.getLevel() <= LogLevel.WARN.getLevel()) {
            configuration.formatter.formatLogMessage("WARN", message, args);
        }
    }

    /**
     * Logs a message with the WARN level.
     *
     * @param message The message to log.
     */
    public void warn(String message) {
        if (this.logLevel.getLevel() <= LogLevel.WARN.getLevel()) {
            configuration.formatter.formatLogMessage("WARN", message);
        }
    }

    /**
     * Logs a message with the ERROR level.
     *
     * @param message The message to log.
     * @param args    The arguments to format the message with.
     */
    public void error(String message, Object... args) {
        if (this.logLevel.getLevel() <= LogLevel.ERROR.getLevel()) {
            configuration.formatter.formatLogMessage("ERROR", message, args);
        }
    }

    /**
     * Logs a message with the ERROR level.
     *
     * @param message The message to log.
     */
    public void error(String message) {
        if (this.logLevel.getLevel() <= LogLevel.ERROR.getLevel()) {
            configuration.formatter.formatLogMessage("ERROR", message);
        }
    }

    /**
     * Logs a message with the FATAL level.
     *
     * @param message The message to log.
     * @param args    The arguments to format the message with.
     */
    public void fatal(String message, Object... args) {
        if (this.logLevel.getLevel() <= LogLevel.FATAL.getLevel()) {
            configuration.formatter.formatLogMessage("FATAL", message, args);
        }
    }

    /**
     * Logs a message with the FATAL level.
     *
     * @param message The message to log.
     */
    public void fatal(String message) {
        if (this.logLevel.getLevel() <= LogLevel.FATAL.getLevel()) {
            configuration.formatter.formatLogMessage("FATAL", message);
        }
    }

    /**
     * Sets the log level for this logger.
     *
     * @param logLevel The new log level.
     */
    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * Gets the current log level of this logger.
     *
     * @return The current log level.
     */
    public LogLevel getLogLevel() {
        return logLevel;
    }

    /**
     * Gets the name of this logger.
     *
     * @return The logger name.
     */
    public String getLoggerName() {
        return loggerName;
    }

    /**
     * Gets the configuration of this logger.
     *
     * @return The logger configuration.
     */
    public LoggerConfiguration getConfiguration() {
        return configuration;
    }
}