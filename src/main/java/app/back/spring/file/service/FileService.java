package app.back.spring.file.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    List<String> uploadFile(MultipartFile file, int segmentSize) throws IOException;

    Resource getFileResource(String fileName) throws IOException;

}

