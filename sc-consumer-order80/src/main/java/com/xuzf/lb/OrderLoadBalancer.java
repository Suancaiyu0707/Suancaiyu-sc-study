package com.xuzf.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zhifang.xu
 * @CreateTime 2020/5/31 11:01 下午
 * @Version 1.0.0
 * @Desc
 * 自定义一个loadbalancer接口
 */
public interface OrderLoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);


}
