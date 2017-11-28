package com.qinxiaozhou.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by qxz on 2017/11/27
 * Description:
 */

//@EnableAutoConfiguration
//@ComponentScan
@Controller
@EnableScheduling
@SpringBootApplication
public class ScheduldBootStrap {

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    @RequestMapping("/")
    @ResponseBody
    public String home() {

        return "Hello World!";
    }

    @Scheduled(fixedRate = 3000)
    public void fixedScheduled() {
        System.out.println(dataFormat.format(new Date()));
    }

    @Scheduled(cron = "0/3 * * * * ?")
    public void cronScheduled() {
        System.out.println(dataFormat.format(new Date()));
    }

    public static void main(String[] args) {

        new SpringApplicationBuilder(ScheduldBootStrap.class)
//                .bannerMode(Banner.Mode.CONSOLE)
                .run();
    }
}


