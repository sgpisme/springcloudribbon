package com.sgp.ribbonclient.predicate;

import java.util.function.Predicate;

/**
 * @author lipeng
 * @version 1.0
 * @date 2020/5/13 16:10
 */
public class RecordFailurePredicate implements Predicate<Throwable> {
    @Override
    public boolean test(Throwable throwable) {
        //直接返回true所有异常都重试
        return true;
    }
}
