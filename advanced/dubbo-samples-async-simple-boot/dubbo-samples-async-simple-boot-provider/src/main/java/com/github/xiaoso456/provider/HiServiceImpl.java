package com.github.xiaoso456.provider;

import com.github.xiaoso456.samples.async.boot.HiService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class HiServiceImpl implements HiService {
    @Override
    public String sayHello(String name) {
        System.out.println("call :" + name);
        return "hi, your name is: " + name;
    }
}
