// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer;

/**
 * Enumeration of log levels.
 */
public enum LogLevel {
    DEBUG(0),
    INFO(1),
    WARN(2),
    ERROR(3),
    FATAL(4);

    private final int level;

    LogLevel(int level) {
        this.level = level;
    }

    /**
     * Gets the integer level associated with this log level.
     *
     * @return The integer level.
     */
    public int getLevel() {
        return level;
    }
}
