package com.young.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.young.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author LiuYang
 * @Date 2021/3/12 16:13
 */
@RestController
@Slf4j
@DefaultProperties( defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {

        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }


//    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
//
//        String result = paymentHystrixService.paymentInfo_TimeOut(id);
//        return result;
//    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut( @PathVariable("id") Integer id) {

        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfoTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80，对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己，o(╥﹏╥)o";

    }

    /**
     * 全局fallback方法
     *  <p>
     *      需要注释一些属性,没有特别指明,就用统一的方法
     *      //    @HystrixCommand(fallbackMethod = "PaymentTimeOutFallbackMethod", commandProperties = {
     *      //            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
     *      //    })
     *      <p>
     *      替换成@HystrixCommand一个注解
     * @return
     */
    public String payment_Global_FallbackMethod(){

        return "Global异常处理信息，请稍后在尝试！";
    }
}
