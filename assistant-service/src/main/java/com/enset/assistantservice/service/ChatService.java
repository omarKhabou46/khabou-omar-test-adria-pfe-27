package com.enset.assistantservice.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class ChatService {


    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClient, ChatMemory chatMemory, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = chatClient
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultTools(toolCallbackProvider)
                .defaultSystem("""
                        vous etes un assistant qui se charge de repondre au questions de l'utilisateur 
                        a propos des transactions et des comptes bancaires, en fonction de contexte fourni 
                        si aucun contexte ni fourni repond avec JE NE SAIS PAS
                        """)
                .build();
    }

    public String chat(String message) {
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }


}
