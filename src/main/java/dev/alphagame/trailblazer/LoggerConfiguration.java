// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer;

import dev.alphagame.trailblazer.formatters.AbstractFormatter;
import dev.alphagame.trailblazer.formatters.SimpleFormatter;

public class LoggerConfiguration {
    /**
     * The log level for the logger.
     */
    public LogLevel logLevel;

    /**
     * The formatter used to format log messages.
     */
    public AbstractFormatter formatter;
    
    /**
     * Creates a new LoggerConfiguration with default values.
     */
    public LoggerConfiguration() {
        this.logLevel = LogLevel.INFO;
        this.formatter = new SimpleFormatter();
    }
    
    /**
     * Creates a new LoggerConfiguration with the specified log level and formatter.
     * 
     * @param logLevel The log level for the logger.
     * @param formatter The formatter used to format log messages.
     */
    public LoggerConfiguration(LogLevel logLevel, AbstractFormatter formatter) {
        this.logLevel = logLevel;
        this.formatter = formatter;
    }
}