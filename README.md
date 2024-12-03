# AI Note Taker

A Spring Boot application that combines speech-to-text with AI-powered note summarization using Ollama.

## Features

- 🎤 Speech-to-Text note taking
- 🤖 AI-powered note summarization using Ollama
- 💾 PostgreSQL database for note storage
- 🌐 Modern web interface

## Prerequisites

- Java 17
- PostgreSQL database
- [Ollama](https://ollama.ai/) running locally with llama2 model
- Maven

## Configuration

### Database Setup
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ainotes
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Ollama Setup
```properties
spring.ai.ollama.base-url=http://localhost:11434
spring.ai.ollama.model=llama2
spring.ai.ollama.temperature=0.3f
```

## Running Locally

1. Start PostgreSQL database
2. Start Ollama server with llama2 model:
   ```bash
   ollama run llama2
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. Open http://localhost:8080 in your browser

## Deployment

This application is configured for deployment on Railway. The necessary configuration is in `railway.yml`.

### Environment Variables Required for Railway
- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- `SPRING_AI_OLLAMA_BASE_URL`

## Tech Stack

- Spring Boot 3.2.3
- Spring AI 0.8.1
- PostgreSQL
- Thymeleaf
- Bootstrap 5
- Web Speech API

## License

This project is licensed under the MIT License - see the LICENSE file for details.
