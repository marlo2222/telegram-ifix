package com.telegramifix.service;



import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
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
    String text;

    public void send(){
        Unirest.setTimeouts(0, 0);
        try {
            HttpResponse<String> response = Unirest.get("https://api.bitcointrade.com.br/v3/public/BRLBTC/ticker")
                    .header("Content-Type", "application/json")
                    .asString();
            text = response.getBody().toString();
            System.out.println(text);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
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
