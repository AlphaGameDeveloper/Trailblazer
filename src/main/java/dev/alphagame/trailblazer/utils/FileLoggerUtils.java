// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer.utils;

import dev.alphagame.trailblazer.LogLevel;
import dev.alphagame.trailblazer.LoggerConfiguration;
import dev.alphagame.trailblazer.TBLogger;
import dev.alphagame.trailblazer.formatters.SimpleFormatter;
import dev.alphagame.trailblazer.formatters.JSONFormatter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Utility class for creating file-based loggers.
 */
public class FileLoggerUtils {
    
    /**
     * Creates a logger that writes to a file using the SimpleFormatter.
     * 
     * @param name The name of the logger.
     * @param filePath The path to the log file.
     * @param logLevel The log level.
     * @return A TBLogger that writes to the specified file.
     * @throws FileNotFoundException If the file cannot be created or written to.
     */
    public static TBLogger createFileLogger(String name, String filePath, LogLevel logLevel) 
            throws FileNotFoundException {
        File logFile = new File(filePath);
        File parentDir = logFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }
        
        PrintStream fileStream = new PrintStream(new FileOutputStream(logFile, true));
        SimpleFormatter formatter = new SimpleFormatter(fileStream);
        LoggerConfiguration config = new LoggerConfiguration(logLevel, formatter);
        
        return new TBLogger(name, config);
    }
    
    /**
     * Creates a logger that writes to a file using the SimpleFormatter with INFO level.
     * 
     * @param name The name of the logger.
     * @param filePath The path to the log file.
     * @return A TBLogger that writes to the specified file.
     * @throws FileNotFoundException If the file cannot be created or written to.
     */
    public static TBLogger createFileLogger(String name, String filePath) 
            throws FileNotFoundException {
        return createFileLogger(name, filePath, LogLevel.INFO);
    }
    
    /**
     * Creates a JSON logger that writes to a file.
     * 
     * @param name The name of the logger.
     * @param filePath The path to the log file.
     * @param logLevel The log level.
     * @return A TBLogger that writes JSON to the specified file.
     * @throws FileNotFoundException If the file cannot be created or written to.
     */
    public static TBLogger createJSONFileLogger(String name, String filePath, LogLevel logLevel) 
            throws FileNotFoundException {
        File logFile = new File(filePath);
        File parentDir = logFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }
        
        PrintStream fileStream = new PrintStream(new FileOutputStream(logFile, true));
        JSONFormatter formatter = new JSONFormatter(fileStream);
        LoggerConfiguration config = new LoggerConfiguration(logLevel, formatter);
        
        return new TBLogger(name, config);
    }
    
    /**
     * Creates a JSON logger that writes to a file with INFO level.
     * 
     * @param name The name of the logger.
     * @param filePath The path to the log file.
     * @return A TBLogger that writes JSON to the specified file.
     * @throws FileNotFoundException If the file cannot be created or written to.
     */
    public static TBLogger createJSONFileLogger(String name, String filePath) 
            throws FileNotFoundException {
        return createJSONFileLogger(name, filePath, LogLevel.INFO);
    }
    
    /**
     * Creates a rotating file logger (simple implementation).
     * When the file exceeds maxSizeBytes, it will be renamed with .old extension
     * and a new file will be created.
     * 
     * @param name The name of the logger.
     * @param filePath The path to the log file.
     * @param logLevel The log level.
     * @param maxSizeBytes Maximum file size before rotation.
     * @return A TBLogger that writes to a rotating file.
     * @throws FileNotFoundException If the file cannot be created or written to.
     */
    public static TBLogger createRotatingFileLogger(String name, String filePath, 
            LogLevel logLevel, long maxSizeBytes) throws FileNotFoundException {
        
        File logFile = new File(filePath);
        
        // Simple rotation logic
        if (logFile.exists() && logFile.length() > maxSizeBytes) {
            File oldFile = new File(filePath + ".old");
            if (oldFile.exists()) {
                oldFile.delete();
            }
            logFile.renameTo(oldFile);
        }
        
        return createFileLogger(name, filePath, logLevel);
    }
}
