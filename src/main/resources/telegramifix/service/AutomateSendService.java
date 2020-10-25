package com.telegramifix.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AutomateSendService {

    @Autowired
    SendMessageService sendMessageService;

    @Scheduled(zone = "GMT-3:00", cron = "0 32 11 * * ?")
    public void send(){
        sendMessageService.send();
    }
}
