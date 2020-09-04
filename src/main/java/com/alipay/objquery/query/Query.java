package com.alipay.objquery.query;

/**
 * 查询对象，封装了组合了{@link Order}、{@link Where}、{@link Group}
 * @param <T>
 * @author yangwenpeng
 * @version 2020年9月3日17:23:31
 */
public class Query<T> {

    private Where<T> where;

    private Order<T> order;

    private Group<T> group;

    /**
     * Gets the value of group.
     *
     * @return the value of group
     */
    public Group<T> getGroup() {
        return group;
    }

    /**
     * Sets the value of group.
     */
    public void setGroup(Group<T> group) {
        this.group = group;
    }

    /**
     * Gets the value of order.
     *
     * @return the value of order
     */
    public Order<T> getOrder() {
        return order;
    }

    /**
     * Sets the value of order.
     */
    public void setOrder(Order<T> order) {
        this.order = order;
    }

    /**
     * Gets the value of where.
     *
     * @return the value of where
     */
    public Where<T> getWhere() {
        return where;
    }

    /**
     * Sets the value of where.
     */
    public void setWhere(Where<T> where) {
        this.where = where;
    }
}
