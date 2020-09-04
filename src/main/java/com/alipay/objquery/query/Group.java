package com.alipay.objquery.query;

import java.util.function.Function;

/**
 * 封装了Group条件
 * @param <T>
 * @author yangwenpeng
 * @version 2020年9月3日17:45:43
 */
public class Group<T> {

    private Function<? super T,?> func;

    public Group(Function<? super T, ?> func) {
        this.func = func;
    }

    public Object getGroupValue(T data){
        return func.apply(data);
    }
}
