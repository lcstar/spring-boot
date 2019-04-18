package com.lc.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by lc
 * createTime 2018/6/8.
 */

@Component
public class DemoTest {

    @Async
    public void testOne() throws Exception{
        System.out.println("当前时间戳------》》》" + System.currentTimeMillis());
        Thread.sleep(500);
        System.out.println("当前时间戳2------》》》" + System.currentTimeMillis());
    }
}
