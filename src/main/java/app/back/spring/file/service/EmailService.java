package app.back.spring.file.service;

import jakarta.mail.MessagingException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmailService {

    void sendEmail(String email, List<MultipartFile> files) throws MessagingException, IOException;

}
