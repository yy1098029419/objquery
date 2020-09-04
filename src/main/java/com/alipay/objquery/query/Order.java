package com.alipay.objquery.query;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * 用于封装排序条件
 * @param <T>
 * @author yangwenpeng
 * @version 2020年9月3日17:33:52
 */
public class Order<T> implements Comparator<T> {

    /**
     * 排序列表
     */
    private List<Function<? super T, ? extends Comparable>> orderList = new ArrayList<>();

    /**
     * 排序类型列表
     */
    private List<OrderType> orderTypeList = new ArrayList<>();

    /**
     * 添加排序条件
     * @param func 用于获取排序值的方法
     * @param orderType DESC|ASC
     * @return this
     */
    public Order<T> add(Function<? super T, ? extends Comparable> func, OrderType orderType) {
        orderList.add(func);
        orderTypeList.add(orderType);
        return this;
    }

    @Override
    public int compare(T o1, T o2) {
        int ret = 0;
        for (int i = 0; i < orderList.size(); i++) {
            Function<? super T, ? extends Comparable> function = orderList.get(i);
            OrderType type = orderTypeList.get(i);
            ret = function.apply(o1).compareTo( function.apply(o2));
            ret = OrderType.DESC.equals(type) ? -ret : ret;
            if (ret != 0) {
                break;
            }
        }
        return ret;
    }

    /**
     * 排序类型
     */
    public enum OrderType {
        DESC, ASC;

        OrderType() {
        }
    }
}
