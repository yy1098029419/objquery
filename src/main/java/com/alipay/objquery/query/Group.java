package com.alipay.objquery.query;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ��װ��Group����
 * @param <T>
 * @author yangwenpeng
 * @version 2020��9��3��17:45:43
 */
public class Group<T> {

    private List<Function<? super T,?>> functionList = new ArrayList<>();

    public Group(){ }

    public Group<T> addGroup(Function<? super T,?> func){
        functionList.add(func);
        return this;
    }

    public List<Object> getGroupValue(T data){
        return functionList.stream().map(e->e.apply(data)).collect(Collectors.toList());
    }
}
