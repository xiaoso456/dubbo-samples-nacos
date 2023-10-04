/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.xiaoso456.async.boot.consumer;

import com.github.xiaoso456.samples.async.boot.HiService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;


@Component
public class Task implements CommandLineRunner {
    @DubboReference
    private HiService hiService;

    @Override
    public void run(String... args) throws Exception {
        // 1. 异步调用方式1 回调函数
        hiService.sayHello("world");

        CompletableFuture<String> helloFuture = RpcContext.getContext().getCompletableFuture();
        helloFuture.whenComplete((retValue, exception) -> {
            if (exception == null) {
                System.out.println("return value: " + retValue);
            } else {
                exception.printStackTrace();
            }
        });

        // 2. 异步调用方式2，返回 completableFuture
        CompletableFuture<String> f = RpcContext.getContext().asyncCall(() -> hiService.sayHello("async call request"));
        System.out.println("async call returned: " + f.get());

        // 3. 异步调用方式3，无回调
        RpcContext.getContext().asyncCall(() -> {
            hiService.sayHello("one way call request1");
        });
    }
}
