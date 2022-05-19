package com.itheima.raggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author : Dpeng
 * @Date : 2022/4/24  21:32
 */
@Slf4j
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class RaggieApplication {
    public static void main(String[] args) {
        SpringApplication.run(RaggieApplication.class,args);
        log.info("启动成功....");
    }
}
