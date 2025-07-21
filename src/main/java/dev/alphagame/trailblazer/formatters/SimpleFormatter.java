// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer.formatters;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple formatter that outputs log messages in a standard format:
 * [TIMESTAMP] [LEVEL] MESSAGE
 */
public class SimpleFormatter extends AbstractFormatter {
    private final SimpleDateFormat dateFormatter;
    
    public SimpleFormatter() {
        super();
        this.dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }
    
    public SimpleFormatter(String dateFormat) {
        super();
        this.dateFormatter = new SimpleDateFormat(dateFormat);
    }
    
    public SimpleFormatter(PrintStream outputStream) {
        super(outputStream);
        this.dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }
    
    public SimpleFormatter(String dateFormat, PrintStream outputStream) {
        super(outputStream);
        this.dateFormatter = new SimpleDateFormat(dateFormat);
    }

    /**
     * Formats a log message with the given level, logger name, message, and arguments.
     *
     * @param level   The log level.
     * @param loggerName The name of the logger.
     * @param message The log message.
     * @param args    The arguments to format the message with.
     */
    @Override
    public void formatLogMessage(String level, String loggerName, String message, Object... args) {
        String formattedMessage = String.format(message, args);
        String timestamp = dateFormatter.format(new Date());
        String logLine = String.format("[%s] [%s] [%s] %s", timestamp, level, loggerName, formattedMessage);
        outputStream.println(logLine);
    }

    /**
     * Formats a log message with the given level, logger name, and message.
     *
     * @param level   The log level.
     * @param loggerName The name of the logger.
     * @param message The log message.
     */
    @Override
    public void formatLogMessage(String level, String loggerName, String message) {
        String timestamp = dateFormatter.format(new Date());
        String logLine = String.format("[%s] [%s] [%s] %s", timestamp, level, loggerName, message);
        outputStream.println(logLine);
    }
}
