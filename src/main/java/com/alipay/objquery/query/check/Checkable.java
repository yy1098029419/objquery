package com.alipay.objquery.query.check;

import com.alipay.objquery.query.Where;

/**
 * �ýӿ����ڱ�ʾ�ɼ��Ķ���{@link Where}�� {@link CheckEquals} ��Ϊ�ýӿڵ�ʵ��
 *
 * @param <T>
 * @author yangwenepng
 * @version 2020��9��3��17:11:01
 */
public interface Checkable<T> {

    /**
     * ������
     *
     * @param data �����Ķ���ʵ��
     * @return true/false
     */
    boolean check(T data);
}
