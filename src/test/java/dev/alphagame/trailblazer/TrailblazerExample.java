// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Basic tests and examples for the Trailblazer logging library.
 */
public class TrailblazerExample {
    
    public static void main(String[] args) {
        System.out.println("=== Trailblazer Logging Library Examples ===\n");
        
        // Example 1: Basic usage with factory
        System.out.println("1. Basic Factory Usage:");
        TBLogger logger = LoggerFactory.getLogger("ExampleLogger");
        logger.info("This is an info message");
        logger.debug("This debug message won't show (INFO level)");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
        System.out.println();
        
        // Example 2: Different log levels
        System.out.println("2. Different Log Levels:");
        TBLogger debugLogger = LoggerFactory.getLogger("DebugLogger", LogLevel.DEBUG);
        debugLogger.debug("Now debug messages will show!");
        debugLogger.info("Info message with arguments: %s = %d", "count", 42);
        System.out.println();
        
        // Example 3: Different formatters
        System.out.println("3. JSON Formatter:");
        TBLogger jsonLogger = LoggerFactory.createJSONLogger("JsonLogger");
        jsonLogger.info("This is a JSON formatted message");
        jsonLogger.error("JSON error with data: %s", "sample data");
        System.out.println();
        
        System.out.println("4. Columned Formatter:");
        TBLogger columnLogger = LoggerFactory.createColumnedLogger("ColumnLogger");
        columnLogger.info("This is columned");
        columnLogger.warn("Warning in columns");
        System.out.println();
        
        // Example 4: Class-based loggers
        System.out.println("5. Class-based Logger:");
        TBLogger classLogger = LoggerFactory.getLogger(TrailblazerExample.class);
        classLogger.info("Logger created for class: %s", TrailblazerExample.class.getSimpleName());
        System.out.println();
        
        // Example 5: Custom output stream
        System.out.println("6. Custom Output Stream (to String):");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream customStream = new PrintStream(baos);
        TBLogger streamLogger = LoggerFactory.createLoggerWithStream("StreamLogger", customStream);
        streamLogger.info("This message goes to a custom stream");
        streamLogger.error("Error message to custom stream");
        
        System.out.println("Captured output:");
        System.out.println(baos.toString());
        System.out.println();
        
        // Example 6: Level checking for performance
        System.out.println("7. Efficient Logging with Level Checking:");
        TBLogger perfLogger = LoggerFactory.getLogger("PerfLogger", LogLevel.WARN);
        if (perfLogger.isDebugEnabled()) {
            perfLogger.debug("Expensive debug operation: %s", expensiveOperation());
        }
        perfLogger.warn("This warning will show");
        System.out.println();
        
        // Example 7: Runtime configuration changes
        System.out.println("8. Runtime Configuration Changes:");
        TBLogger configLogger = LoggerFactory.getLogger("ConfigLogger", LogLevel.ERROR);
        configLogger.info("This won't show (ERROR level)");
        configLogger.setLogLevel(LogLevel.INFO);
        configLogger.info("Now this will show!");
        System.out.println();
        
        System.out.println("=== Examples Complete ===");
    }
    
    private static String expensiveOperation() {
        // Simulate an expensive operation
        return "expensive result";
    }
}
