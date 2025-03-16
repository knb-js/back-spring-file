package app.back.spring.file.controller.impl;

import app.back.spring.file.controller.api.WebSocketController;
import app.back.spring.file.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketControllerImpl implements WebSocketController {

    @Autowired
    private WebSocketService webSocketService;

    @Override
    @MessageMapping("/processFile")
    public ResponseEntity<String> processFile(String message) {
        webSocketService.processFile(message);
        return new ResponseEntity<>("File processing started", HttpStatus.OK);
    }

    @Override
    @MessageMapping("/fileProcessed")
    public ResponseEntity<String> notifyCompletion(String message) {
        webSocketService.notifyCompletion(message);
        return new ResponseEntity<>("File processing complete", HttpStatus.OK);
    }

}
