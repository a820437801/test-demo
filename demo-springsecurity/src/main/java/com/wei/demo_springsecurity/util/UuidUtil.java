package com.wei.demo_springsecurity.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 82043
 */
public class UuidUtil {
 
    private static AtomicLong id;
 
    /**
     * 生成Long 类型唯一ID
     */
    public synchronized static Long getId() {
        //如果需要更长 或者更大冗余空间, 只需要 time * 10^n   即可
        //当前可保证1毫秒 生成 10000条不重复
        long time = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()))*10000;
        if (id == null) {
            id = new AtomicLong(time);
            return id.get();
        }
        if (time <= id.get()) {
            id.addAndGet(1);
        } else {
            id = new AtomicLong(time);
        }
        return id.get();
    }
}