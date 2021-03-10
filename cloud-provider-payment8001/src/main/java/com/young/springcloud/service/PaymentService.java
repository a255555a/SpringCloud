package com.young.springcloud.service;

import com.young.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author LiuYang
 * @Date 2021/3/10 11:49
 */
public interface PaymentService {


    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
