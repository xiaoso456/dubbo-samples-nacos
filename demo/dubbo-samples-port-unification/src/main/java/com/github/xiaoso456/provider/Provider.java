package com.github.xiaoso456.provider;

import com.github.xiaoso456.api.GreetingService;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

public class Provider {
    public static void main(String[] args) {
        ServiceConfig<GreetingService> service = new ServiceConfig<>();
        service.setInterface(GreetingService.class);
        service.setRef(new GreetingServiceImpl());

        // 设置 dubbo 协议 + 额外 tri 协议
        ProtocolConfig protocolConfig = new ProtocolConfig(CommonConstants.DUBBO_PROTOCOL, 52000);
        protocolConfig.setExtProtocol(CommonConstants.TRIPLE + ",");


        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("port-unification-provider"))
                .registry(new RegistryConfig("nacos://127.0.0.1:8848"))
                .protocol(protocolConfig)
                .service(service)
                .start()
                .await();
    }
}
