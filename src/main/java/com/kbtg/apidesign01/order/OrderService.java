package com.kbtg.apidesign01.order;

import com.kbtg.apidesign01.mail.GoogleMailService;
import com.kbtg.apidesign01.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
//    @Qualifier("googleMail")
    private MailService mailService;


    public void createOrder(){
        mailService.sendEmail("user@gmail.com", "Order created");
    }
}
