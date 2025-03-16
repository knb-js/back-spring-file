package app.back.spring.file.service;

public interface WebSocketService {

    void processFile(String message);
    void notifyCompletion(String message);

}
