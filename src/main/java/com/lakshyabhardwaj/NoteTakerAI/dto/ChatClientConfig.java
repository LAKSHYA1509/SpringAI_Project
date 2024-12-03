package com.lakshyabhardwaj.NoteTakerAI.dto;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Value;
import java.time.Duration;

@Configuration
public class ChatClientConfig {
    
    @Value("${spring.ai.ollama.base-url:http://localhost:11434}")
    private String baseUrl;

    @Value("${spring.ai.ollama.model:llama2}")
    private String model;

    @Value("${spring.ai.timeout:30}")
    private int timeoutSeconds;

    @Bean
    public OllamaApi ollamaApi() {
        return new OllamaApi(baseUrl);
    }

    @Bean
    @Primary
    public OllamaChatClient ollamaChatClient(OllamaApi ollamaApi) {
        return new OllamaChatClient(ollamaApi)
            .withModel(model);
    }
}
