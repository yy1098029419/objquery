package com.alipay.objquery.service.impl;

import com.alipay.objquery.query.Limit;
import com.alipay.objquery.query.Query;

import java.util.List;

/**
 * �����ѯ����
 *
 * @author yangwenpeng
 * @version 2020��9��3��17:03:39
 */
public interface ObjectQueryService {

    /**
     * ��ѯ����
     *
     * @param data  װ��ָ������ļ���
     * @param query {@link Query} ��ѯ����������where��group��order
     * @param <T>   ���������
     * @return ����ɸѡ��Ķ��󼯺�
     */
    <T> List<T> query(List<T> data, Query<T> query);

    /**
     * ֧�ַ�ҳ�Ķ����ѯ
     *
     * @param data  װ�ж���Ԫ���ݵļ���
     * @param query {@link Query} ��ѯ����������where��group��order
     * @param limit {@link Limit}��ҳ����
     * @param <T>   ���������
     * @return ����ɸѡ��Ķ��󼯺�
     */
    <T> List<T> query(List<T> data, Query<T> query, Limit limit);
}
