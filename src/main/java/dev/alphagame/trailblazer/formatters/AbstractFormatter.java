// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer.formatters;

import java.io.PrintStream;

public abstract class AbstractFormatter {
    protected String format;
    protected String dateFormat;
    protected PrintStream outputStream;

    public AbstractFormatter() {
        this.outputStream = System.out;
    }
    
    public AbstractFormatter(PrintStream outputStream) {
        this.outputStream = outputStream != null ? outputStream : System.out;
    }

    /**
     * Sets the output stream for this formatter.
     * 
     * @param outputStream The output stream to write to.
     */
    public void setOutputStream(PrintStream outputStream) {
        this.outputStream = outputStream != null ? outputStream : System.out;
    }

    /**
     * Gets the current output stream.
     * 
     * @return The current output stream.
     */
    public PrintStream getOutputStream() {
        return outputStream;
    }

    /**
     * Formats a log message with the given level, logger name, message, and arguments.
     *
     * @param level   The log level.
     * @param loggerName The name of the logger.
     * @param message The log message.
     * @param args    The arguments to format the message with.
     */
    public abstract void formatLogMessage(String level, String loggerName, String message, Object... args);

    /**
     * Formats a log message with the given level, logger name, and message.
     *
     * @param level   The log level.
     * @param loggerName The name of the logger.
     * @param message The log message.
     */
    public abstract void formatLogMessage(String level, String loggerName, String message);
    
    /**
     * Formats a log message with the given level, message, and arguments (legacy method).
     *
     * @param level   The log level.
     * @param message The log message.
     * @param args    The arguments to format the message with.
     */
    public void formatLogMessage(String level, String message, Object... args) {
        formatLogMessage(level, "Unknown", message, args);
    }

    /**
     * Formats a log message with the given level and message (legacy method).
     *
     * @param level   The log level.
     * @param message The log message.
     */
    public void formatLogMessage(String level, String message) {
        formatLogMessage(level, "Unknown", message);
    }
}