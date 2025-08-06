package org.example.utils;

import java.util.Collection;

public class CollectionUtils {


    public static boolean isEmpty(Collection<?> collections) {
        return collections ==null||collections.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collections) {
        return !isEmpty(collections);
    }
}
