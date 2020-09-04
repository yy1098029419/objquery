package com.alipay.objquery.query.check;

import java.util.function.Function;

/**
 * 验证相等条件
 * @param <T>
 * @author yangwenpeng
 * @version 2020-9-3 17:46:572
 */
public class CheckEquals<T> implements Checkable<T> {

    private Object value;

    private Function<? super T, ?> mapper;

    public CheckEquals(Object value, Function<? super T, ?> mapper) {
        this.value = value;
        this.mapper = mapper;
    }

    public boolean check(T data) {
        return value.equals(mapper.apply(data));
    }
}
