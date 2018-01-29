package com.fs.ntes.dto.exchange;

import com.fs.ntes.dto.PageList;
import com.fs.ntes.utils.GeneralUtils;
import com.github.pagehelper.Page;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExchangeUtils {

    public static <F, T> T getDto(F dto, Function<F, T> event) {
        return event.apply(dto);
    }

    public static <K, V> Map<K, V> getMap(List<V> list, java.util.function.Function<V, K> keyMapper) {
        return (Map) (CollectionUtils.isNotEmpty(list) ? (Map) list.stream().collect(Collectors.toMap(keyMapper, (v) -> {
            return v;
        })) : MapUtils.EMPTY_MAP);
    }

    public static <F, K, V> Map<K, V> getMap(List<F> list, java.util.function.Function<F, K> keyMapper, java.util.function.Function<F, V> valueMapper) {
        return (Map<K, V>) (CollectionUtils.isNotEmpty(list) ? (Map<K, V>) list.stream().collect(Collectors.toMap(keyMapper, valueMapper)) : MapUtils.EMPTY_MAP);
    }

    public static <F, T> List<T> getList(List<F> list, Function<F, T> event) {
        if (CollectionUtils.isNotEmpty(list)) {
            Stream<F> var10000 = list.stream();
            return (List<T>) var10000.map(event::apply).filter(Objects::nonNull).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public static <F, T> PageList<T> getPageList(Page<F> list, Function<F, T> event) {
        PageList<T> pageList = new PageList<>();
        pageList.setTotalSize(list.getTotal());
        pageList.setTotalPages(list.getPages());
        pageList.setList(getList(list.getResult(), event));
        return pageList;
    }

    public static <F, T> PageList<T> getPageList(List<F> list, Function<F, T> event) {
        PageList<T> pageList = new PageList<>();
        pageList.setList(getList(list, event));
        if (list != null && list.size() > 0 && list instanceof Page) {
            pageList.setTotalPages(((Page) list).getPages());
            pageList.setTotalSize(((Page) list).getTotal());
        } else {
            pageList.setTotalPages(0);
            pageList.setTotalSize(0L);
        }

        return pageList;
    }

    public static <F, T> List<T> getList(List<T> oList, List<F> list, Function<F, T> event) {
        if (oList == null) {
            oList = Collections.emptyList();
        }

        if (CollectionUtils.isNotEmpty(list)) {
            Stream<F> var10001 = list.stream();
            event.getClass();
            oList.addAll((Collection) var10001.map(event::apply).filter(Objects::nonNull).collect(Collectors.toList()));
        }

        return (List) oList;
    }
}
