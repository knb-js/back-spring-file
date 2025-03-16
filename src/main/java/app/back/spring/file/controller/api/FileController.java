package app.back.spring.file.controller.api;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/files")
public interface FileController {

    @PostMapping("/upload")
    ResponseEntity<List<String>> uploadFile(@RequestParam("file") MultipartFile file,
                                            @RequestParam("segmentSize") int segmentSize) throws IOException;

    @GetMapping("/download/{fileName}")
    ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws IOException;

}
