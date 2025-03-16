package app.back.spring.file.controller.impl;

import app.back.spring.file.controller.api.FileController;
import app.back.spring.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class FileControllerImpl implements FileController {

    @Autowired
    private FileService fileService;

    @Override
    public ResponseEntity<List<String>> uploadFile(MultipartFile file, int segmentSize) throws IOException {
        List<String> segmentNames = fileService.uploadFile(file, segmentSize);
        return ResponseEntity.ok(segmentNames);
    }

    @Override
    public ResponseEntity<Resource> downloadFile(String fileName) throws IOException {
        Resource downloadFile = fileService.getFileResource(fileName);
        return ResponseEntity.ok(downloadFile);
    }


}
