package com.alipay.objquery.query.check;

import com.alipay.objquery.query.Where;

/**
 * 该接口用于表示可检测的对象。{@link Where}和 {@link CheckEquals} 均为该接口的实现
 *
 * @param <T>
 * @author yangwenepng
 * @version 2020年9月3日17:11:01
 */
public interface Checkable<T> {

    /**
     * 检测对象
     *
     * @param data 被检查的对象实例
     * @return true/false
     */
    boolean check(T data);
}
