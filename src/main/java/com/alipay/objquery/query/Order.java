package com.alipay.objquery.query;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * ���ڷ�װ��������
 * @param <T>
 * @author yangwenpeng
 * @version 2020��9��3��17:33:52
 */
public class Order<T> implements Comparator<T> {

    /**
     * �����б�
     */
    private List<Function<? super T, ? extends Comparable>> orderList = new ArrayList<>();

    /**
     * ���������б�
     */
    private List<OrderType> orderTypeList = new ArrayList<>();

    /**
     * �����������
     * @param func ���ڻ�ȡ����ֵ�ķ���
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
     * ��������
     */
    public enum OrderType {
        DESC, ASC;

        OrderType() {
        }
    }
}
