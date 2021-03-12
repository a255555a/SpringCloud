package com.young.springcloud.Ib.impl;

import com.young.springcloud.Ib.MyLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author LiuYang
 * @Date 2021/3/12 9:59
 */
@Component
public class MyLb implements MyLoadBalancer {

//    原子操作类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取第几次访问的next次数
     * @return
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
//            获取current的值
            current = this.atomicInteger.get();
            //2147473647是Integer的最大值，防止数值越界
            next = current >= 2147483647 ? 0 : current + 1;
            //不断循环，拿到符合要求的，就是自旋
        } while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        /**
         * serviceInstance.size()是集群服务器的数量
         * getAndIncrement()访问接口的次数
         */
        int index = getAndIncrement() % serviceInstances.size();


        return serviceInstances.get(index);
    }
}
