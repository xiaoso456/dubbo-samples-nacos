package com.github.xiaoso456.consumer;

import com.github.xiaoso456.api.GreetingService;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

public class TripleConsumer {
    public static void main(String[] args) {
        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        ReferenceConfig<GreetingService> ref = new ReferenceConfig<>();
        ref.setInterface(GreetingService.class);
        ref.setProtocol(CommonConstants.TRIPLE);

        bootstrap.application(new ApplicationConfig("triple-consumer"))
                .registry(new RegistryConfig("nacos://127.0.0.1:8848"))
                .reference(ref)
                .start();

        GreetingService greetingService = ref.get();

        String result = greetingService.sayHello("triple consumer");
        System.out.println(result);

    }
}
