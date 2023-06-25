package com.github.xiaoso456.provider;

import com.github.xiaoso456.api.GreetingService;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHello(String name) {
        return "hello : "+ name;
    }
}
