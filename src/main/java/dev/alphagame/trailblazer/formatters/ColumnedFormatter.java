// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer.formatters;

public class ColumnedFormatter extends AbstractFormatter {
    private String columnSeparator = "|";
    private String rowSeparator = "-";
    private int columnWidth = 20;

    public ColumnedFormatter() {
        super();
    }

    /**
     * Formats a log message with the given level, message, and arguments into a columned format.
     *
     * @param level   The log level.
     * @param message The log message.
     * @param args    The arguments to format the message with.
     */
    public void formatLogMessage(String level, String message, Object... args) {
        String formattedMessage = String.format(message, args);
        // Create a formatted string with columns
        StringBuilder sb = new StringBuilder();
        sb.append(level).append(columnSeparator);
        sb.append(formattedMessage).append(columnSeparator);
        for (Object arg : args) {
            sb.append(arg.toString()).append(columnSeparator);
        }
        System.out.println(sb.toString());
    }

    /**
     * Formats a log message with the given level and message into a columned format.
     *
     * @param level   The log level.
     * @param message The log message.
     */
    public void formatLogMessage(String level, String message) {
        // Create a formatted string with columns
        StringBuilder sb = new StringBuilder();
        sb.append(level).append(columnSeparator);
        sb.append(message).append(columnSeparator);
        System.out.println(sb.toString());
    }
}