package com.youtool_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/channel")
    public ResponseEntity<String> getChannelData(@RequestParam String url) {
        String resultJson = PythonScriptRunner.runYouTubeScript(url);
        if (resultJson == null || resultJson.isEmpty()) {
            return ResponseEntity.status(500).body("{\"error\": \"Erro ao executar o script Python.\"}");
        }
        try {
            ChannelData channelData = mapper.readValue(resultJson, ChannelData.class);
            service.salvar(channelData);

            return ResponseEntity.ok(resultJson); // retorna objeto, Spring faz o JSON
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Erro ao converter JSON: " + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/video-comments")
    public ResponseEntity<String> getVideoComments(@RequestParam String videoId) {
        String resultJson = PythonScriptRunner.runGetVideoCommentsScript(videoId);
        if (resultJson == null || resultJson.isEmpty()) {
            return ResponseEntity.status(500).body("{\"error\": \"Erro ao executar o script Python.\"}");
        }
        try {
            VideoComments videoComments = mapper.readValue(resultJson, VideoComments.class);
            service.salvarComentario(videoComments);

            return ResponseEntity.ok(resultJson);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Erro ao converter JSON: " + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/video/transcription")
    public ResponseEntity<String> getVideoTranscription(@RequestParam String videoId) {
        String resultJson = PythonScriptRunner.runGetTranscriptionScript(videoId);
        return ResponseEntity.ok(resultJson);
    }

}
