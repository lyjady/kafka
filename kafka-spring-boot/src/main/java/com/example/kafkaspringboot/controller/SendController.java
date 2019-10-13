package com.example.kafkaspringboot.controller;

import com.example.kafkaspringboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LinYongJin
 * @date 2019/10/13 17:03
 */
@RestController
public class SendController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/send")
    public void sendMessage() {
        messageService.sendMessage();
    }
}
