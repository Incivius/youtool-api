package com.youtool_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youtool_api.services.PythonScriptRunner;

@RestController
@RequestMapping("/youtube")
public class YouTubeController {

    @GetMapping("/channel")
    public ResponseEntity<String> getChannelData(@RequestParam String url) {
        String resultJson = PythonScriptRunner.runYouTubeScript(url);
        return ResponseEntity.ok(resultJson);
    }

    @GetMapping("/video/comments")
    public ResponseEntity<String> getVideoComments(@RequestParam String videoId) {
        String resultJson = PythonScriptRunner.runGetVideoCommentsScript(videoId);
        return ResponseEntity.ok(resultJson);
    }

    @GetMapping("/video/transcription")
    public ResponseEntity<String> getVideoTranscription(@RequestParam String videoId) {
        String resultJson = PythonScriptRunner.runGetTranscriptionScript(videoId);
        return ResponseEntity.ok(resultJson);
    }

}
