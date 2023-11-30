package org.africalib.test.test.ai;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.chat.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.*;

import com.theokanning.openai.service.OpenAiService;
import com.theokanning.openai.service.FunctionExecutor;


@Slf4j
@Service
public class AIService {
    private String apiKey;
    private OpenAiService service;
    private static final String ENDPOINT = "https://api.openai.com/v1/chat/completions";
    public AIService() {
        // 생성자에서 API키 로드 수행
        Properties properties = new Properties();

        try (InputStream input = AIService.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.err.println("Sorry, unable to find config.properties");
            }

            // 로드된 프로퍼티 파일에서 API 키 가져오기
            properties.load(input);
            this.apiKey = properties.getProperty("api.key");

            if (apiKey != null) {
                System.out.println("API Key: " + apiKey);
                service = new OpenAiService(apiKey, Duration.ofSeconds(30));
            } else {
                System.err.println("API Key not found in config.properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static class Weather {
        @JsonPropertyDescription("City and state, for example: León, Guanajuato")
        public String location;

        @JsonPropertyDescription("The temperature unit, can be 'celsius' or 'fahrenheit'")
        @JsonProperty(required = true)
        public WeatherUnit unit;
    }

    public enum WeatherUnit {
        CELSIUS, FAHRENHEIT;
    }

    public static class WeatherResponse {
        public String location;
        public WeatherUnit unit;
        public int temperature;
        public String description;

        public WeatherResponse(String location, WeatherUnit unit, int temperature, String description) {
            this.location = location;
            this.unit = unit;
            this.temperature = temperature;
            this.description = description;
        }
    }
    public String getAnswer(Prompt prompt) {
        String promptText = "너와 %s 관계인 %s에게 %s 상황에서의 편지를 작성해줘".formatted(
                prompt.getRelation(),
                prompt.getToName(),
                prompt.getSituation(),
                prompt.getPolite()
        );
        System.out.println("질문: " + promptText);

        // 무슨역할인질 모르겠는데 없으면 오류남
        FunctionExecutor functionExecutor = new FunctionExecutor(Collections.singletonList(ChatFunction.builder()
                .name("get_weather")
                .description("Get the current weather of a location")
                .executor(Weather.class, w -> new WeatherResponse(w.location, w.unit, new Random().nextInt(50), "sunny"))
                .build()));

        // 시스템 규칙 추가
        List<ChatMessage> messages = new ArrayList<>();
        ChatMessage systemRole1 = new ChatMessage(ChatMessageRole.SYSTEM.value(), "너는 편지작성자 이고, 이름은 '"+prompt.getFromName()+"' 이야");
        messages.add(systemRole1);
        ChatMessage systemRole2 = new ChatMessage(ChatMessageRole.SYSTEM.value(), "편지 내용은 반드시 150자 이하, 1~2줄 정도로 작성하고, 편지 내용만을 작성할 것");
        messages.add(systemRole2);
        ChatMessage systemRole3 = new ChatMessage(ChatMessageRole.SYSTEM.value(), "편지의 말투는 " + prompt.getPolite() + "로 작성해야 해");
        messages.add(systemRole3);

        // 유저 규칠(prompt) 추가
        ChatMessage userRole = new ChatMessage(ChatMessageRole.USER.value(), promptText);
        messages.add(userRole);


        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo-0613")
                .messages(messages)
                .functions(functionExecutor.getFunctions())
                .functionCall(ChatCompletionRequest.ChatCompletionRequestFunctionCall.of("auto"))
                .n(1)
                .maxTokens(256)
                .logitBias(new HashMap<>())
                .build();
        ChatMessage responseMessage = service.createChatCompletion(chatCompletionRequest).getChoices().get(0).getMessage();

        System.out.println("Response: " + responseMessage.getContent());

        return responseMessage.getContent();
    }
}
