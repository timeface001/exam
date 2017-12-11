package com.fs.ntes.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class LogUtils {

    private static final Logger logger = LoggerFactory.getLogger(LogUtils.class);

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void info(String msg, Objects... objects) {
        logger.info(msg, objects);
    }

    public static void info(String msg, Throwable throwable) {
        logger.info(msg, throwable);
    }

    public static void error(String msg) {
        logger.error(msg);
    }

    public static void error(String msg, Objects... objects) {
        logger.error(msg, objects);
    }

    public static void error(String msg, Throwable throwable) {
        logger.error(msg, throwable);
    }

    public static void debug(String msg) {
        logger.debug(msg);
    }

    public static void debug(String msg, Objects... objects) {
        logger.debug(msg, objects);
    }

    public static void debug(String msg, Throwable throwable) {
        logger.debug(msg, throwable);
    }
}
