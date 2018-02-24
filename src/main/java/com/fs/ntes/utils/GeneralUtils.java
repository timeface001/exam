package com.fs.ntes.utils;

import com.fs.ntes.domain.Point;
import com.fs.ntes.dto.exchange.ExchangeUtils;
import org.springframework.util.ClassUtils;

import java.util.*;

public class GeneralUtils {

    public static String absPath(){
        return ClassUtils.getDefaultClassLoader().getResource("").getPath();
    }

    public static Integer questionTypeCount(Point point, Integer type) {
        if (Objects.isNull(point)) {
            return 0;
        }
        switch (type) {
            case 0:
                return point.getJudgeCount();
            case 1:
                return point.getRadioCount();
            case 2:
                return point.getCheckboxCount();
            case 3:
                return point.getShortCount();
            default:
                return 0;
        }
    }

    public static boolean isNullOrEmpty(Collection collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }

    public static boolean isNotNullOrEmpty(Collection collection) {
        return !isNullOrEmpty(collection);
    }

    public static List<Integer> spilt(String questionIds) {

        List<Integer> list = new ArrayList<>();
        if (org.apache.commons.lang3.StringUtils.isNotBlank(questionIds) && questionIds.split(",").length > 0) {
            return ExchangeUtils.getList(Arrays.asList(questionIds.split(",")), org.apache.commons.lang3.math.NumberUtils::toInt);
        }
        return list;

    }
}
