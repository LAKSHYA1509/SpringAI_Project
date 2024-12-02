package com.lakshyabhardwaj.NoteTakerAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {
    private final ChatClient chatClient;
    public PageController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("")
    public String joke() {
        return chatClient.prompt()
        .user("Tell me a funny joke about programmers")
        .call()
        .content();
    }
}
