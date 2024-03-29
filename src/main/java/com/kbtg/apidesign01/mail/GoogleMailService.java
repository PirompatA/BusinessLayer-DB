package com.kbtg.apidesign01.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
//@Primary
public class GoogleMailService implements MailService{
    @Value("${mail-provider.google.url}")
    private String url;

    @Value("${mail-provider.google.port}")
    private String port;

    public GoogleMailService() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public void sendEmail(String to, String body){
        System.out.println("sendGoogleMail:\n\t"+to +"\n\t"+body+"\nurl: "+this.getUrl()+"\nurl-port: "+this.getPort());
    }
}
