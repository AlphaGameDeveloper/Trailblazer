// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer.formatters;

public abstract class AbstractFormatter {
    protected String format;
    protected String dateFormat;

    public AbstractFormatter() {}

    /**
     * Formats a log message with the given level, message, and arguments.
     *
     * @param level   The log level.
     * @param message The log message.
     * @param args    The arguments to format the message with.
     */
    public abstract void formatLogMessage(String level, String message, Object... args);

    /**
     * Formats a log message with the given level and message.
     *
     * @param level   The log level.
     * @param message The log message.
     */
    public abstract void formatLogMessage(String level, String message);
}