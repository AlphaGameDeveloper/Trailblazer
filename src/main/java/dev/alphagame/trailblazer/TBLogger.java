// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer;

public class TBLogger {
    private final String loggerName;
    private volatile LogLevel logLevel;
    private volatile LoggerConfiguration configuration;

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
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("INFO", loggerName, message, args);
            }
        }
    }

    /**
     * Logs a message with the INFO level.
     *
     * @param message The message to log.
     */
    public void info(String message) {
        if (this.logLevel.getLevel() <= LogLevel.INFO.getLevel()) {
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("INFO", loggerName, message);
            }
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
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("DEBUG", loggerName, message, args);
            }
        }
    }

    /**
     * Logs a message with the DEBUG level.
     *
     * @param message The message to log.
     */
    public void debug(String message) {
        if (this.logLevel.getLevel() <= LogLevel.DEBUG.getLevel()) {
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("DEBUG", loggerName, message);
            }
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
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("WARN", loggerName, message, args);
            }
        }
    }

    /**
     * Logs a message with the WARN level.
     *
     * @param message The message to log.
     */
    public void warn(String message) {
        if (this.logLevel.getLevel() <= LogLevel.WARN.getLevel()) {
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("WARN", loggerName, message);
            }
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
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("ERROR", loggerName, message, args);
            }
        }
    }

    /**
     * Logs a message with the ERROR level.
     *
     * @param message The message to log.
     */
    public void error(String message) {
        if (this.logLevel.getLevel() <= LogLevel.ERROR.getLevel()) {
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("ERROR", loggerName, message);
            }
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
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("FATAL", loggerName, message, args);
            }
        }
    }

    /**
     * Logs a message with the FATAL level.
     *
     * @param message The message to log.
     */
    public void fatal(String message) {
        if (this.logLevel.getLevel() <= LogLevel.FATAL.getLevel()) {
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("FATAL", loggerName, message);
            }
        }
    }
    
    /**
     * Logs an exception with the ERROR level.
     *
     * @param message The message to log.
     * @param throwable The exception to log.
     */
    public void error(String message, Throwable throwable) {
        if (this.logLevel.getLevel() <= LogLevel.ERROR.getLevel()) {
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("ERROR", loggerName, message + " - " + throwable.toString());
            }
        }
    }
    
    /**
     * Logs an exception with the WARN level.
     *
     * @param message The message to log.
     * @param throwable The exception to log.
     */
    public void warn(String message, Throwable throwable) {
        if (this.logLevel.getLevel() <= LogLevel.WARN.getLevel()) {
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("WARN", loggerName, message + " - " + throwable.toString());
            }
        }
    }
    
    /**
     * Logs an exception with the INFO level.
     *
     * @param message The message to log.
     * @param throwable The exception to log.
     */
    public void info(String message, Throwable throwable) {
        if (this.logLevel.getLevel() <= LogLevel.INFO.getLevel()) {
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("INFO", loggerName, message + " - " + throwable.toString());
            }
        }
    }
    
    /**
     * Logs an exception with the DEBUG level.
     *
     * @param message The message to log.
     * @param throwable The exception to log.
     */
    public void debug(String message, Throwable throwable) {
        if (this.logLevel.getLevel() <= LogLevel.DEBUG.getLevel()) {
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("DEBUG", loggerName, message + " - " + throwable.toString());
            }
        }
    }
    
    /**
     * Logs an exception with the FATAL level.
     *
     * @param message The message to log.
     * @param throwable The exception to log.
     */
    public void fatal(String message, Throwable throwable) {
        if (this.logLevel.getLevel() <= LogLevel.FATAL.getLevel()) {
            synchronized (configuration.formatter) {
                configuration.formatter.formatLogMessage("FATAL", loggerName, message + " - " + throwable.toString());
            }
        }
    }

    /**
     * Checks if DEBUG level is enabled for this logger.
     *
     * @return true if DEBUG level is enabled.
     */
    public boolean isDebugEnabled() {
        return this.logLevel.getLevel() <= LogLevel.DEBUG.getLevel();
    }

    /**
     * Checks if INFO level is enabled for this logger.
     *
     * @return true if INFO level is enabled.
     */
    public boolean isInfoEnabled() {
        return this.logLevel.getLevel() <= LogLevel.INFO.getLevel();
    }

    /**
     * Checks if WARN level is enabled for this logger.
     *
     * @return true if WARN level is enabled.
     */
    public boolean isWarnEnabled() {
        return this.logLevel.getLevel() <= LogLevel.WARN.getLevel();
    }

    /**
     * Checks if ERROR level is enabled for this logger.
     *
     * @return true if ERROR level is enabled.
     */
    public boolean isErrorEnabled() {
        return this.logLevel.getLevel() <= LogLevel.ERROR.getLevel();
    }

    /**
     * Checks if FATAL level is enabled for this logger.
     *
     * @return true if FATAL level is enabled.
     */
    public boolean isFatalEnabled() {
        return this.logLevel.getLevel() <= LogLevel.FATAL.getLevel();
    }

    /**
     * Sets the log level for this logger.
     *
     * @param logLevel The new log level.
     */
    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
        this.configuration.logLevel = logLevel;
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

    /**
     * Sets the configuration for this logger.
     *
     * @param configuration The new configuration.
     */
    public void setConfiguration(LoggerConfiguration configuration) {
        this.configuration = configuration;
        this.logLevel = configuration.logLevel;
    }
}