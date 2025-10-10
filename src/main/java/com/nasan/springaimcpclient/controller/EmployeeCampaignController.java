package com.nasan.springaimcpclient.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.chat.client.ChatClient;


@RestController
@RequestMapping("/api/campaign")
public class EmployeeCampaignController {


    private final ChatClient chat;


    public EmployeeCampaignController(ChatClient chat) { this.chat = chat; }


    @GetMapping
    public ResponseEntity<String> generate() {
        String system = "Görevin: mevcut MCP araçlarını kullanarak employee listesi içerisinden, YALNIZCA yaşı 18 olan kullanıcılar için çıktı üret." +
                " Şablon şu şekilde: 'sayın (employee adı) 18. yaşınza özel 3gb hediyemizi almak için tıklayın.'" ;

        String user = "Çalışanları kontrol et ve uygun mesajları yaz.";

        var out = chat.prompt()
                .system(system)
                .user(user)
                .call()
                .content();

        return ResponseEntity.ok(out);
    }
}