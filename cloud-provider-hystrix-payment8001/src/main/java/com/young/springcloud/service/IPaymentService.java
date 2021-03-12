package com.young.springcloud.service;

/**
 * @Author LiuYang
 * @Date 2021/3/12 15:00
 */
public interface IPaymentService {

    /**
     * 正常访问，ok！
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id);

    /**
     * 超时访问
     * @param id
     * @return
     */
    public String paymentInfo_Timeout(Integer id);
}
