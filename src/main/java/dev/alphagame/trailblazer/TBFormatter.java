// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TBFormatter {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public static String formatLogMessage(String level, String message, Object... args) {
        // Get timestamp
        String timestamp = LocalDateTime.now().format(formatter);

        // Get caller information
        StackTraceElement caller = Thread.currentThread().getStackTrace()[3];
        String callerInfo = caller.getFileName() + ":" + caller.getLineNumber();

        // Format the message with arguments
        String formattedMessage = String.format(message, args);

        // Format with fixed-width columns for better alignment
        return String.format("%-23s | %-7s | %-30s | %s",
                             timestamp,
                             level,
                             callerInfo,
                             formattedMessage);
    }


}