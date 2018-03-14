package com.edu.java.design.mode.chainOfResponseibility;

/**
 * Created by garychen on 2018/3/5.
 */
public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger logger = getChainOfLoggers();

        logger.logMessage(AbstractLogger.INFO, "this is an information.");
        System.out.println("------------------------------------------");
        logger.logMessage(AbstractLogger.DEBUG, "this is an debug information.");
        System.out.println("------------------------------------------");
        logger.logMessage(AbstractLogger.ERROR, "this is an error information.");
        System.out.println("------------------------------------------");
//        logger.logMessage(-1, "this is an error information.");
    }
}
