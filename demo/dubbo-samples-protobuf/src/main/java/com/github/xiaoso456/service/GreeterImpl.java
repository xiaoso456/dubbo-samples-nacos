package com.github.xiaoso456.service;

import com.github.xiaoso456.hello.HelloReply;
import com.github.xiaoso456.hello.HelloRequest;

public class GreeterImpl extends com.github.xiaoso456.hello.DubboGreeterTriple.GreeterImplBase {
    @Override
    public HelloReply greet(HelloRequest request) {
        HelloReply helloReply = HelloReply.newBuilder()
                .setMessage("hello :" + request.getName())
                .build();
        return helloReply;
    }
}
