package com.alipay.objquery.query;

import java.util.function.Function;

/**
 * ��װ��Group����
 * @param <T>
 * @author yangwenpeng
 * @version 2020��9��3��17:45:43
 */
public class Group<T> {

    private Function<? super T,?> func;

    public Group() {
    }

    public Group(Function<? super T, ?> func) {
        this.func = func;
    }

    public Object getGroupValue(T data){
        return func.apply(data);
    }

    /**
     * Gets the value of func.
     *
     * @return the value of func
     */
    public Function<? super T, ?> getFunc() {
        return func;
    }

    /**
     * Sets the value of func.
     */
    public void setFunc(Function<? super T, ?> func) {
        this.func = func;
    }
}
