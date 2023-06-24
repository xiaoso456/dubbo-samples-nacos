package com.github.xiaoso456;

import com.github.xiaoso456.service.GreeterImpl;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        ServiceConfig<com.github.xiaoso456.hello.Greeter> service = new ServiceConfig<>();
        service.setInterface(com.github.xiaoso456.hello.Greeter.class);
        service.setRef(new GreeterImpl());

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("tri-stub-server"))
                .registry(new RegistryConfig("nacos://127.0.0.1:8848"))
                .protocol(new ProtocolConfig(CommonConstants.TRIPLE, 50051))
                .service(service)
                .start()
                .await();
    }
}