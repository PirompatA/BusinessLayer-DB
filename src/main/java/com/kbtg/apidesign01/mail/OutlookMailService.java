package com.kbtg.apidesign01.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "mail-provider.outlook")
public class OutlookMailService implements MailService{
    private String url;

    private String port;

    public OutlookMailService() {
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
        System.out.println("sendOutlookMail:\n\t"+to +"\n\t"+body+"\nurl: "+this.getUrl()+"\nurl-port: "+this.getPort());
    }
}
