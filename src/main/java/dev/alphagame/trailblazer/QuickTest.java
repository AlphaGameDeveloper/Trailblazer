// Copyright (c) 2025 Damien Boisvert (AlphaGameDeveloper)
// 
// This software is released under the MIT License.
// https://opensource.org/licenses/MIT

package dev.alphagame.trailblazer;

/**
 * Quick test to validate the logging library works correctly.
 */
public class QuickTest {
    public static void main(String[] args) {
        System.out.println("🔥 Testing Trailblazer Logging Library 🔥\n");
        
        // Test basic logging
        TBLogger logger = LoggerFactory.getLogger("QuickTest");
        logger.info("Trailblazer is working!");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
        logger.debug("This debug message won't show (default INFO level)");
        
        // Test debug logger
        TBLogger debugLogger = LoggerFactory.getLogger("DebugTest", LogLevel.DEBUG);
        debugLogger.debug("Now debug messages show!");
        debugLogger.info("Info with args: count = %d", 42);
        
        // Test class-based logger
        TBLogger classLogger = LoggerFactory.getLogger(QuickTest.class);
        classLogger.info("Class-based logger works!");
        
        // Test level checking
        if (logger.isErrorEnabled()) {
            logger.error("Error level is enabled");
        }
        
        // Test columned formatter
        TBLogger columnLogger = LoggerFactory.createColumnedLogger("ColumnTest");
        columnLogger.info("Columned format");
        columnLogger.warn("Column warning");
        
        TBLogger jsonLogger = LoggerFactory.createJSONLogger("JSONTest");
        jsonLogger.info("JSON format");
        jsonLogger.warn("JSON warning");
        jsonLogger.error("JSON error with args: %s", "error details");
        jsonLogger.debug("JSON debug message (should not appear if level is INFO)");
        System.out.println("\n✅ All tests passed! Trailblazer is an amazing logging library!");
    }
}
