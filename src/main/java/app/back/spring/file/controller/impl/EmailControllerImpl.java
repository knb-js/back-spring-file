package app.back.spring.file.controller.impl;

import app.back.spring.file.controller.api.EmailController;
import app.back.spring.file.service.EmailService;
import app.back.spring.file.util.ResponseUtil;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class EmailControllerImpl implements EmailController {

    @Autowired
    private EmailService emailService;

    @Override
    public ResponseEntity<Map<String, String>> sendEmail(String email, List<MultipartFile> files) throws MessagingException, IOException {
        emailService.sendEmail(email, files);
        return ResponseUtil.success("Email sent successfully");
    }
}