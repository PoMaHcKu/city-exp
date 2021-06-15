package com.example.cityexplorer.util;

import java.util.function.Supplier;

public class ExceptionUtils {

    public static <T extends RuntimeException> Supplier<T> createException(Class<T> type, String message) {
        return () -> {
            try {
                return type.getConstructor(message.getClass()).newInstance(message);
            } catch (ReflectiveOperationException e) {
                return (T) new RuntimeException(message);
            }
        };
    }
}