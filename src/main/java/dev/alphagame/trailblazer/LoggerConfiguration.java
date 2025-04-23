// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer;

import dev.alphagame.trailblazer.formatters.AbstractFormatter;

public class LoggerConfiguration {
    /**
     * The log level for the logger.
     */
    public LogLevel logLevel;

    /**
     * The formatter used to format log messages.
     */
    public AbstractFormatter formatter;
}