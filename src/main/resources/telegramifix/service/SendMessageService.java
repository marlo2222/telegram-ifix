package com.telegramifix.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@Service
public class SendMessageService {


    String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
    @Value("${apiToken}")
    String apiToken;
    @Value("${chatId}")
    String chatId;
    String text = "📊";

    public void send(){
         urlString= String.format(urlString, apiToken, chatId, text);

        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
