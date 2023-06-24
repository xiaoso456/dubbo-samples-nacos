package com.github.xiaoso456;

import com.github.xiaoso456.hello.Greeter;
import com.github.xiaoso456.hello.HelloReply;
import com.github.xiaoso456.hello.HelloRequest;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

public class Consumer {
    public static void main(String[] args) {
        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        ReferenceConfig<Greeter> ref = new ReferenceConfig<>();
        ref.setInterface(Greeter.class);
        ref.setProtocol(CommonConstants.TRIPLE);
        ref.setProxy(CommonConstants.NATIVE_STUB);
        ref.setTimeout(3000);
        bootstrap.application(new ApplicationConfig("tri-stub-client"))
                .registry(new RegistryConfig("nacos://127.0.0.1:8848"))
                .reference(ref)
                .start();

        Greeter greeter = ref.get();
        HelloRequest request = HelloRequest.newBuilder().setName("Demo Request App Client").build();
        HelloReply reply = greeter.greet(request);
        System.out.println("Received reply:" + reply);
    }
}
