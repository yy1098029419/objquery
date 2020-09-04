package com.alipay.objquery.service.impl;

import com.alipay.objquery.query.Limit;
import com.alipay.objquery.query.Query;

import java.util.List;

/**
 * 对象查询服务
 *
 * @author yangwenpeng
 * @version 2020年9月3日17:03:39
 */
public interface ObjectQueryService {

    /**
     * 查询对象
     *
     * @param data  装有指定对象的集合
     * @param query {@link Query} 查询条件，包括where、group、order
     * @param <T>   对象的类型
     * @return 经过筛选后的对象集合
     */
    <T> List<T> query(List<T> data, Query<T> query);

    /**
     * 支持分页的对象查询
     *
     * @param data  装有对象元数据的集合
     * @param query {@link Query} 查询条件，包括where、group、order
     * @param limit {@link Limit}分页条件
     * @param <T>   对象的类型
     * @return 经过筛选后的对象集合
     */
    <T> List<T> query(List<T> data, Query<T> query, Limit limit);
}
