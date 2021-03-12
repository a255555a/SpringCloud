package com.young.springcloud.Ib;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author LiuYang
 * @Date 2021/3/12 9:58
 */

public interface MyLoadBalancer {

    /**
     * 获取所有服务，将获得的服务器名放到ServiceInstance实例中
     * @param serviceInstances
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
