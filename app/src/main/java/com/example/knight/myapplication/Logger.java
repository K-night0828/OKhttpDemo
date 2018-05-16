package com.example.knight.myapplication;


import android.util.Log;

public final class Logger {

    //if you don't designate a tag,using the DEFAULT_TAG;
    private static final String DEFAULT_TAG = "ScreenshotEx";

    static void log(String message) {
        String traceMessage = getTraceMessage();
        Log.d(DEFAULT_TAG,traceMessage + message);
    }

    static void log ( String tag, String message) {
        if (tag == null) {
            tag = DEFAULT_TAG;
        }
        String traceMessage = getTraceMessage();
        Log.d(tag,traceMessage + message);
    }

    private static String getSimpleClassName( String name) {
        if (name == null) return " ";
        int lastIndex = name.lastIndexOf(".");
        return name.substring(lastIndex + 1);
    }

    private static String  getTraceMessage() {
        StackTraceElement[] traces = Thread.currentThread().getStackTrace();
        //the index of Array is 4: It can be determined by printing all the StackTraceElement.
        StackTraceElement trace = traces[4];
        StringBuilder builder = new StringBuilder();
        builder.append(getSimpleClassName(trace.getClassName()))
                .append(".")
                .append(trace.getMethodName())
                .append(" ")
                .append(" (")
                .append(trace.getFileName())
                .append(":")
                .append(trace.getLineNumber())
                .append(")")
                .append(" : ");

        return builder.toString();
    }



}
