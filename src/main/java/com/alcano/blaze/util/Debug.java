package com.alcano.blaze.util;

public final class Debug {

    private Debug() {}

    public static void log(String text, Level level) {
        String threadName = Thread.currentThread().getName().toUpperCase();
        System.out.println("[" + threadName + ": " + level.label + "] " + text);
    }

    public static void log(String text) {
        log(text, Level.INFO);
    }

    public enum Level {
        INFO("Info"),
        WARNING("Warning"),
        ERROR("Error");

        public final String label;

        Level(String label) {
            this.label = label;
        }
    }

}
