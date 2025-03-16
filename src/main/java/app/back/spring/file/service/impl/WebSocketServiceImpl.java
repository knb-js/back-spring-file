package app.back.spring.file.service.impl;

import app.back.spring.file.service.WebSocketService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketServiceImpl implements WebSocketService {
    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketServiceImpl(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void processFile(String message) {
        messagingTemplate.convertAndSend("/topic/processing", "Processing file...");
    }

    @Override
    public void notifyCompletion(String message) {
        messagingTemplate.convertAndSend("/topic/processing", "File processing complete!");
    }
}
