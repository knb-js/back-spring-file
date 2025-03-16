package app.back.spring.file.service.impl;

import app.back.spring.file.service.FileService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class FileServiceImpl implements FileService {

    private static final String UPLOAD_DIR = "uploads/";

    @Override
    public List<String> uploadFile(MultipartFile file, int segmentSize) throws IOException {
        if (file.isEmpty() || segmentSize <= 0) {
            throw new IllegalArgumentException("Invalid file or segment size");
        }

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        String fileName = file.getOriginalFilename();
        byte[] fileBytes = file.getBytes();

        List<String> segmentNames = new ArrayList<>();
        int totalSegments = (int) Math.ceil((double) fileBytes.length / segmentSize);

        for (int i = 0; i < totalSegments; i++) {
            int start = i * segmentSize;
            int end = Math.min(start + segmentSize, fileBytes.length);

            byte[] segment = Arrays.copyOfRange(fileBytes, start, end);
            String segmentName = String.format("%s.%d", fileName, i);

            Path segmentPath = Paths.get(UPLOAD_DIR + segmentName);
            Files.write(segmentPath, segment);
            segmentNames.add(segmentName);
        }

        return segmentNames;
    }

    public Resource getFileResource(String fileName) throws IOException {
        File file = new File(UPLOAD_DIR + File.separator + fileName);

        if (!file.exists()) {
            throw new IOException("Archivo no encontrado: " + fileName);
        }

        Path path = file.toPath();
        return new ByteArrayResource(Files.readAllBytes(path));
    }

    @Scheduled(fixedRate = 3600000)
    public void deleteOldFiles() {
        File directory = new File(UPLOAD_DIR);
        if (!directory.exists()) return;

        File[] files = directory.listFiles();
        if (files == null) return;

        long oneHourAgo = Instant.now().minusMillis(TimeUnit.HOURS.toMillis(1)).toEpochMilli();

        for (File file : files) {
            if (file.lastModified() < oneHourAgo) {
                boolean deleted = file.delete();
                if (deleted) {
                    System.out.println("Archivo eliminado: " + file.getName());
                } else {
                    System.err.println("No se pudo eliminar: " + file.getName());
                }
            }
        }
    }
}