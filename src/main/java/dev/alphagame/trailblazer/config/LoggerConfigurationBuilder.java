// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer.config;

import dev.alphagame.trailblazer.LogLevel;
import dev.alphagame.trailblazer.LoggerConfiguration;
import dev.alphagame.trailblazer.formatters.AbstractFormatter;
import dev.alphagame.trailblazer.formatters.SimpleFormatter;
import dev.alphagame.trailblazer.formatters.JSONFormatter;
import dev.alphagame.trailblazer.formatters.ColumnedFormatter;

import java.io.PrintStream;

/**
 * Builder pattern for creating logger configurations.
 */
public class LoggerConfigurationBuilder {
    private LogLevel logLevel = LogLevel.INFO;
    private AbstractFormatter formatter = new SimpleFormatter();
    
    /**
     * Creates a new builder instance.
     * 
     * @return A new LoggerConfigurationBuilder.
     */
    public static LoggerConfigurationBuilder create() {
        return new LoggerConfigurationBuilder();
    }
    
    /**
     * Sets the log level.
     * 
     * @param level The log level to set.
     * @return This builder instance.
     */
    public LoggerConfigurationBuilder withLogLevel(LogLevel level) {
        this.logLevel = level;
        return this;
    }
    
    /**
     * Sets a custom formatter.
     * 
     * @param formatter The formatter to use.
     * @return This builder instance.
     */
    public LoggerConfigurationBuilder withFormatter(AbstractFormatter formatter) {
        this.formatter = formatter;
        return this;
    }
    
    /**
     * Uses the SimpleFormatter.
     * 
     * @return This builder instance.
     */
    public LoggerConfigurationBuilder withSimpleFormatter() {
        this.formatter = new SimpleFormatter();
        return this;
    }
    
    /**
     * Uses the SimpleFormatter with custom date format.
     * 
     * @param dateFormat The date format pattern.
     * @return This builder instance.
     */
    public LoggerConfigurationBuilder withSimpleFormatter(String dateFormat) {
        this.formatter = new SimpleFormatter(dateFormat);
        return this;
    }
    
    /**
     * Uses the SimpleFormatter with custom output stream.
     * 
     * @param outputStream The output stream to write to.
     * @return This builder instance.
     */
    public LoggerConfigurationBuilder withSimpleFormatter(PrintStream outputStream) {
        this.formatter = new SimpleFormatter(outputStream);
        return this;
    }
    
    /**
     * Uses the SimpleFormatter with custom date format and output stream.
     * 
     * @param dateFormat The date format pattern.
     * @param outputStream The output stream to write to.
     * @return This builder instance.
     */
    public LoggerConfigurationBuilder withSimpleFormatter(String dateFormat, PrintStream outputStream) {
        this.formatter = new SimpleFormatter(dateFormat, outputStream);
        return this;
    }
    
    /**
     * Uses the JSONFormatter.
     * 
     * @return This builder instance.
     */
    public LoggerConfigurationBuilder withJSONFormatter() {
        this.formatter = new JSONFormatter();
        return this;
    }
    
    /**
     * Uses the JSONFormatter with custom output stream.
     * 
     * @param outputStream The output stream to write to.
     * @return This builder instance.
     */
    public LoggerConfigurationBuilder withJSONFormatter(PrintStream outputStream) {
        this.formatter = new JSONFormatter(outputStream);
        return this;
    }
    
    /**
     * Uses the ColumnedFormatter.
     * 
     * @return This builder instance.
     */
    public LoggerConfigurationBuilder withColumnedFormatter() {
        this.formatter = new ColumnedFormatter();
        return this;
    }
    
    /**
     * Uses the ColumnedFormatter with custom settings.
     * 
     * @param columnSeparator The separator between columns.
     * @param columnWidth The width of each column.
     * @return This builder instance.
     */
    public LoggerConfigurationBuilder withColumnedFormatter(String columnSeparator, int columnWidth) {
        this.formatter = new ColumnedFormatter(columnSeparator, columnWidth);
        return this;
    }
    
    /**
     * Uses the ColumnedFormatter with custom settings and output stream.
     * 
     * @param columnSeparator The separator between columns.
     * @param columnWidth The width of each column.
     * @param outputStream The output stream to write to.
     * @return This builder instance.
     */
    public LoggerConfigurationBuilder withColumnedFormatter(String columnSeparator, int columnWidth, PrintStream outputStream) {
        this.formatter = new ColumnedFormatter(columnSeparator, columnWidth, outputStream);
        return this;
    }
    
    /**
     * Sets the output stream for the current formatter.
     * 
     * @param outputStream The output stream to write to.
     * @return This builder instance.
     */
    public LoggerConfigurationBuilder withOutputStream(PrintStream outputStream) {
        this.formatter.setOutputStream(outputStream);
        return this;
    }
    
    /**
     * Builds the configuration.
     * 
     * @return A new LoggerConfiguration with the specified settings.
     */
    public LoggerConfiguration build() {
        return new LoggerConfiguration(logLevel, formatter);
    }
}
