package com.example.textsummarizer.service;

import lombok.extern.slf4j.Slf4j;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@Slf4j
public class TextSummarizerService {

    private final SentenceDetectorME sentenceDetector;

    public TextSummarizerService() {
        try {
            // Load the pre-trained sentence detection model
            InputStream modelStream = getClass().getResourceAsStream("/models/en-sent.bin");
            if (modelStream == null) {
                throw new RuntimeException("Sentence detection model not found!");
            }
            SentenceModel model = new SentenceModel(modelStream);
            sentenceDetector = new SentenceDetectorME(model);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize sentence detector", e);
        }
    }

    /**
     * Summarizes the input text by extracting the first few sentences.
     *
     * @param text The input text to summarize.
     * @return A summarized version of the text.
     */
    public String summarize(String text) {
        
        String[] sentences = sentenceDetector.sentDetect(text);

        // Extract the first 3 sentences as the summary (basic summarization)
        StringBuilder summary = new StringBuilder();
        int maxSentences = Math.min(3, sentences.length); // Limit to 3 sentences
        for (int i = 0; i < maxSentences; i++) {
            summary.append(sentences[i]).append(" ");
        }

        return summary.toString().trim();
    }
}