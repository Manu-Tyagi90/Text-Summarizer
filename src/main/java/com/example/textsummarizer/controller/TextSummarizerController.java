package com.example.textsummarizer.controller;

import com.example.textsummarizer.service.TextSummarizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/summarize")
public class TextSummarizerController {

    @Autowired
    private TextSummarizerService textSummarizerService;

    @PostMapping
    public String summarizeText(@RequestBody String text) {
        return textSummarizerService.summarize(text);
    }
}