package com.kbtg.apidesign01;

import com.kbtg.apidesign01.mail.GoogleMailService;
import com.kbtg.apidesign01.mail.MailService;
import com.kbtg.apidesign01.mail.OutlookMailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class ApiDesign01Application {
    public static void main(String[] args) {

        SpringApplication.run(ApiDesign01Application.class, args);
//        ConfigurableApplicationContext ctx = SpringApplication.run(ApiDesign01Application.class, args);
//        for (String beanDefinitionName : ctx.getBeanDefinitionNames()){
//            System.out.println(beanDefinitionName);
//        }
    }

    @Bean
    @Primary
    public MailService outlookMail(){
        return new OutlookMailService();
    }

    @Bean
    public MailService googleMail(){
        return new GoogleMailService();
    }
}
