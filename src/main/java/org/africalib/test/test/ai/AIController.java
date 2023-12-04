package org.africalib.test.test.ai;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AIController {
    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/answer")
    public String createAnswer(@RequestBody Prompt prompt) {
        return aiService.getAnswer(prompt);
    }
}

