// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer.formatters;

import java.io.PrintStream;

public class ColumnedFormatter extends AbstractFormatter {
    private String columnSeparator = "|";
    private int columnWidth = 20;

    public ColumnedFormatter() {
        super();
    }
    
    public ColumnedFormatter(PrintStream outputStream) {
        super(outputStream);
    }
    
    public ColumnedFormatter(String columnSeparator, int columnWidth) {
        super();
        this.columnSeparator = columnSeparator;
        this.columnWidth = columnWidth;
    }
    
    public ColumnedFormatter(String columnSeparator, int columnWidth, PrintStream outputStream) {
        super(outputStream);
        this.columnSeparator = columnSeparator;
        this.columnWidth = columnWidth;
    }

    /**
     * Formats a log message with the given level, logger name, message, and arguments into a columned format.
     *
     * @param level   The log level.
     * @param loggerName The name of the logger.
     * @param message The log message.
     * @param args    The arguments to format the message with.
     */
    @Override
    public void formatLogMessage(String level, String loggerName, String message, Object... args) {
        String formattedMessage = String.format(message, args);
        // Create a formatted string with columns
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-" + columnWidth + "s", level)).append(columnSeparator);
        sb.append(String.format("%-" + columnWidth + "s", loggerName)).append(columnSeparator);
        sb.append(String.format("%-" + columnWidth + "s", formattedMessage)).append(columnSeparator);
        for (Object arg : args) {
            sb.append(String.format("%-" + columnWidth + "s", arg.toString())).append(columnSeparator);
        }
        outputStream.println(sb.toString());
    }

    /**
     * Formats a log message with the given level, logger name, and message into a columned format.
     *
     * @param level   The log level.
     * @param loggerName The name of the logger.
     * @param message The log message.
     */
    @Override
    public void formatLogMessage(String level, String loggerName, String message) {
        // Create a formatted string with columns
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-" + columnWidth + "s", level)).append(columnSeparator);
        sb.append(String.format("%-" + columnWidth + "s", loggerName)).append(columnSeparator);
        sb.append(String.format("%-" + columnWidth + "s", message)).append(columnSeparator);
        outputStream.println(sb.toString());
    }
    
    /**
     * Sets the column separator.
     * 
     * @param separator The separator to use between columns.
     */
    public void setColumnSeparator(String separator) {
        this.columnSeparator = separator;
    }
    
    /**
     * Sets the column width.
     * 
     * @param width The width of each column.
     */
    public void setColumnWidth(int width) {
        this.columnWidth = width;
    }
    
    /**
     * Gets the column separator.
     * 
     * @return The column separator.
     */
    public String getColumnSeparator() {
        return columnSeparator;
    }
    
    /**
     * Gets the column width.
     * 
     * @return The column width.
     */
    public int getColumnWidth() {
        return columnWidth;
    }
}