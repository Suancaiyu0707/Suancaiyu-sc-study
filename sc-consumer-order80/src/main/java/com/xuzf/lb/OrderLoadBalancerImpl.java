package com.xuzf.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhifang.xu
 * @CreateTime 2020/5/31 11:02 下午
 * @Version 1.0.0
 * @Desc
 */
@Component
public class OrderLoadBalancerImpl implements OrderLoadBalancer{
    /**
     * 定义一个用来计数的变量
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncr(){
        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE?1: current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*******next: "+next);
        return next;
    }

    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncr()%serviceInstances.size();

        return serviceInstances.get(index);
    }
}
