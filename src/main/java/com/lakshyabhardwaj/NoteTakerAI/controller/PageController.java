package com.lakshyabhardwaj.NoteTakerAI.controller;

import com.lakshyabhardwaj.NoteTakerAI.entity.Note;
import com.lakshyabhardwaj.NoteTakerAI.service.NoteService;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class PageController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private OllamaChatClient ollamaChatClient;

    @GetMapping("/")
    public String showNotePage(Model model) {
        model.addAttribute("title", "NoteTakerAI");
        return "note";
    }

    @PostMapping("/note")
    @ResponseBody
    public ResponseEntity<?> saveNote(@RequestBody Note note) {
        try {
            note.setCreatedAt(LocalDateTime.now());
            note.setUpdatedAt(LocalDateTime.now());
            Note savedNote = noteService.createNote(note);
            return ResponseEntity.ok(savedNote);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                .body("Failed to save note: " + e.getMessage());
        }
    }

    @PostMapping("/summarize")
    @ResponseBody
    public ResponseEntity<Map<String, String>> summarizeNote(@RequestBody Map<String, String> request) {
        String content = request.get("content");
        try {
            String prompt = String.format(
                "Provide a brief 2-3 sentence summary of the following text. Be direct and concise: %s", 
                content
            );
            String summary = ollamaChatClient.call(prompt);
            return ResponseEntity.ok(Map.of("summary", summary));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                .body(Map.of("error", "Failed to generate summary: " + e.getMessage()));
        }
    }
}
