package com.nb.daipengfei.run;

import com.nb.daipengfei.annotation.Retry;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ejb.EJBs;
import java.util.Date;

/*********************************
 *                               *
 Created by daipengfei on 16/9/28.
 *                               *
 ********************************/
@Component
@EnableRetry
public class RetryComponent implements RetryInterface{
    @Resource
    private InitBean initBean;

    public void testRetry(String name){
        System.out.println("--------------------------retry------------" + new Date());
        if(1==1){
            throw new RuntimeException("haha");
        }
        System.out.println("hi" + name + ":" + new Date());
    }


    public void recover(RuntimeException e){
        System.out.println("recover" + e.getMessage());
    }
}
