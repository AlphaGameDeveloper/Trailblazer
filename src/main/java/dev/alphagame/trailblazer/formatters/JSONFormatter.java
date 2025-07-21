// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer.formatters;

import org.json.JSONObject;
import java.io.PrintStream;

public class JSONFormatter extends AbstractFormatter {
    public JSONFormatter() {
        super();
    }
    
    public JSONFormatter(PrintStream outputStream) {
        super(outputStream);
    }

    /**
     * Formats a log message with the given level, logger name, message, and arguments into JSON format.
     *
     * @param level   The log level.
     * @param loggerName The name of the logger.
     * @param message The log message.
     * @param args    The arguments to format the message with.
     */
    @Override
    public void formatLogMessage(String level, String loggerName, String message, Object... args) {
        String formattedMessage = String.format(message, args);
        // Create a JSON object with the log details

        JSONObject json = new JSONObject();
        json.put("level", level);
        json.put("logger", loggerName);
        json.put("message", formattedMessage);
        json.put("timestamp", System.currentTimeMillis());
        if (args.length > 0) {
            json.put("args", args);
        }

        outputStream.println(json.toString());
    }

    /**
     * Formats a log message with the given level, logger name, and message into JSON format.
     *
     * @param level   The log level.
     * @param loggerName The name of the logger.
     * @param message The log message.
     */
    @Override
    public void formatLogMessage(String level, String loggerName, String message) {
        // Create a JSON object with the log details

        JSONObject json = new JSONObject();
        json.put("level", level);
        json.put("logger", loggerName);
        json.put("message", message);
        json.put("timestamp", System.currentTimeMillis());

        outputStream.println(json.toString());
    }
}