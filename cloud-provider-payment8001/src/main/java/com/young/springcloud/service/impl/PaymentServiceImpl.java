package com.young.springcloud.service.impl;

import com.young.springcloud.dao.PaymentDao;
import com.young.springcloud.entities.Payment;
import com.young.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author LiuYang
 * @Date 2021/3/10 11:47
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(@Param("id") Long id) {
        return paymentDao.getPaymentById(id);
    }
}
