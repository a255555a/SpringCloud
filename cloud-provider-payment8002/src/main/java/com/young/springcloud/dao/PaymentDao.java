package com.young.springcloud.dao;

import com.young.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author LiuYang
 * @Date 2021/3/10 11:35
 */
@Mapper
public interface PaymentDao {

    /**
     *
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     *
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);



}
