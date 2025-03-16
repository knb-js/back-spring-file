package app.back.spring.file.controller.api;

import org.springframework.http.ResponseEntity;

public interface WebSocketController {

    ResponseEntity<String> processFile(String message);

    ResponseEntity<String> notifyCompletion(String message);

}
