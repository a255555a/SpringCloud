package com.young.springcloud.service.Imlp;

import com.young.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author LiuYang
 * @Date 2021/3/12 15:00
 */
@Service
public class PaymentServiceImpl implements IPaymentService {


    @Override
    public String paymentInfo_OK(Integer id) {

        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {

        int timeNumber =5;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOut,id:"+id+"\t"+"O(∩_∩)O哈哈~"+"耗时（秒）"+timeNumber;
    }
}
