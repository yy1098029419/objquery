package com.alipay.objquery.service.impl;

import com.alipay.objquery.query.Group;
import com.alipay.objquery.query.Limit;
import com.alipay.objquery.query.Query;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 对象查询服务实现类
 *
 * @author yangwenpeng
 * @version 2020年9月3日17:03:39
 */
public class ObjectQueryServiceImpl implements ObjectQueryService {

    @Override
    public <T> List<T> query(List<T> data, Query<T> query) {
        Stream<T> stream = data.stream();
        if (query.getWhere() != null) {
            stream = stream.filter(e -> query.getWhere().check(e));
        }
        if (query.getGroup() != null) {
            stream = groupData(query.getGroup(), stream);
        }
        if (query.getOrder() != null) {
            stream = stream.sorted(query.getOrder());
        }
        return stream.collect(Collectors.toList());
    }

    @Override
    public <T> List<T> query(List<T> data, Query<T> query, Limit limit) {
        List<T> list = query(data, query);
        if (limit != null) {
            int start = limit.getPage() * limit.getPageSize();
            if (start >= list.size()) {
                return new ArrayList<>();
            }
            int end = Math.min(list.size(), start + limit.getPageSize());
            list = list.subList(start, end);
        }
        return list;
    }

    /**
     * 对stream进行类似于sql的group by 操作
     *
     * @param group  group条件
     * @param stream 数据流
     * @param <T>    对象数据类型
     * @return 经过group后的流
     */
    private <T> Stream<T> groupData(Group<T> group, Stream<T> stream) {
        List<List<Object>> groupList = new LinkedList<>();
        return stream.filter(e -> {
            List<Object> groupValue = group.getGroupValue(e);
            A:
            for (List<Object> list : groupList) {
                for (int i = 0; i < list.size(); i++) {
                    if (!groupValue.get(i).equals(list.get(i))) {
                        continue A;
                    }
                }
                return false;
            }
            groupList.add(groupValue);
            return true;
        });
    }
}
