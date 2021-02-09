package com.telegramifix.controller;


import com.telegramifix.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SendController {

    @Autowired
    SendMessageService sendMessageService;


    @GetMapping("/enviar")
    public ResponseEntity enviar(){
        sendMessageService.send();
        return new ResponseEntity("Deu Certo", HttpStatus.OK);
    }
}
