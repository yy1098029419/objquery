package com.alipay.objquery.query;


import com.alipay.objquery.query.check.CheckEquals;
import com.alipay.objquery.query.check.Checkable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * ��װWhere������֧��and��or��������֧��Ƕ���κ�Checkable��ʵ���࣬��Ȼ����Where����
 * <br>Ŀǰֻ֧��Equals�жϣ����Բ���{@link CheckEquals}ͨ��ʵ��{@link Checkable}�ӿڽ�����չ
 *
 * @param <T> �����������������
 * @author yangwenpeng
 * @version 2020��9��3��17:09:22
 */
public class Where<T> implements Checkable<T> {

    private List<Checkable<T>> andChecks = new ArrayList<>();

    private List<Checkable<T>> orChecks = new ArrayList<>();

    public boolean check(T data) {
        if (checkOr(data)) {
            return true;
        }
        return checkAnd(data);
    }

    private boolean checkAnd(T data) {
        if (andChecks.isEmpty()) {
            return false;
        }
        for (Checkable<T> andCheck : andChecks) {
            if (!andCheck.check(data)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkOr(T data) {
        for (Checkable<T> orCheck : orChecks) {
            if (orCheck.check(data)) {
                return true;
            }
        }
        return false;
    }

    public final <R> Where<T> andEquals(Function<? super T, ? extends R> mapper, R value) {
        CheckEquals<T> checkEquals = new CheckEquals<>(value, mapper);
        this.andChecks.add(checkEquals);
        return this;
    }

    public <R> Where<T> orEquals(Function<? super T, ? extends R> mapper, R value) {
        CheckEquals<T> checkEquals = new CheckEquals<>(value, mapper);
        this.orChecks.add(checkEquals);
        return this;
    }

    public Where<T> and(Checkable<T> checkable) {
        this.andChecks.add(checkable);
        return this;
    }

    public Where<T> or(Checkable<T> checkable) {
        this.andChecks.add(checkable);
        return this;
    }
}
