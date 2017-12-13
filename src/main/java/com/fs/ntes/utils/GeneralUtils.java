package com.fs.ntes.utils;

import org.springframework.util.ClassUtils;

public class GeneralUtils {

    public static String absPath(){
        return ClassUtils.getDefaultClassLoader().getResource("").getPath();
    }
}
