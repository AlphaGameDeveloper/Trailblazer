// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer.formatters;

import org.json.JSONObject;

public class JSONFormatter extends AbstractFormatter {
    public JSONFormatter() {
        super();
    };

    /**
     * Formats a log message with the given level, message, and arguments into JSON format.
     *
     * @param level   The log level.
     * @param message The log message.
     * @param args    The arguments to format the message with.
     */
    public void formatLogMessage(String level, String message, Object... args) {
        String formattedMessage = String.format(message, args);
        // Create a JSON object with the log details
        // make a json object with the following fields:
        // - "level": the log level
        // - "message": the formatted message
        // - "timestamp": the current timestamp

        JSONObject json = new JSONObject();
        json.put("level", level);
        json.put("message", formattedMessage);
        json.put("timestamp", System.currentTimeMillis());
        json.put("varargs", args);

        System.out.println(json.toString());
    }

    /**
     * Formats a log message with the given level and message into JSON format.
     *
     * @param level   The log level.
     * @param message The log message.
     */
    public void formatLogMessage(String level, String message) {
        // Create a JSON object with the log details
        // make a json object with the following fields:
        // - "level": the log level
        // - "message": the formatted message
        // - "timestamp": the current timestamp

        JSONObject json = new JSONObject();
        json.put("level", level);
        json.put("message", message);
        json.put("timestamp", System.currentTimeMillis());

        System.out.println(json.toString());
    }
}