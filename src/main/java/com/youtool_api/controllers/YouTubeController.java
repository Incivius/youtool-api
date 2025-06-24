package com.youtool_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtool_api.model.ChannelData;
import com.youtool_api.model.VideoComments;
import com.youtool_api.service.DatabaseService;
import com.youtool_api.services.PythonScriptRunner;

@RestController
@RequestMapping("/youtube")
public class YouTubeController {

    @Autowired
    private DatabaseService service;

    @GetMapping("/channel")
    public ResponseEntity<?> getChannelData(@RequestParam String url) {
        String resultJson = PythonScriptRunner.runYouTubeScript(url);
        if (resultJson == null || resultJson.isEmpty()) {
            return ResponseEntity.status(500).body("{\"error\": \"Erro ao executar o script Python.\"}");
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            ChannelData channelData = mapper.readValue(resultJson, ChannelData.class);
            service.salvar(channelData);

            return ResponseEntity.ok(channelData); // retorna objeto, Spring faz o JSON
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Erro ao converter JSON: " + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/video-comments")
    public ResponseEntity<?> getVideoComments(@RequestParam String videoId) {
        String resultJson = PythonScriptRunner.runGetVideoCommentsScript(videoId);

        if (resultJson == null || resultJson.isEmpty()) {
            return ResponseEntity.status(500).body("Erro ao executar o script Python.");
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(resultJson);
            JsonNode comments = root.get("comments");

            for (JsonNode node : comments) {
                VideoComments comment = mapper.treeToValue(node, VideoComments.class);
                comment.setVideoId(videoId);
                service.salvarComentario(comment);
            }

            return ResponseEntity.ok(comments);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\": \"Erro ao converter JSON: " + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/video/transcription")
    public ResponseEntity<String> getVideoTranscription(@RequestParam String videoId) {
        String resultJson = PythonScriptRunner.runGetTranscriptionScript(videoId);
        return ResponseEntity.ok(resultJson);
    }

}
