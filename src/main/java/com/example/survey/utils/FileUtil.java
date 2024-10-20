package com.example.survey.utils;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileUtil {

    private static final String UPLOAD_DIR = "data";

    @SneakyThrows
    public String saveUploadedFile(MultipartFile file, String subDir, Long postId) {
        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = postId +  "-" + LocalDate.now() + uuidFile + file.getOriginalFilename();
        return saveFile(resultFileName, subDir, file);
    }

    @SneakyThrows
    public String saveDocument(MultipartFile file, String subDir) {
        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = LocalDate.now() + uuidFile + file.getOriginalFilename();
        return saveFile(resultFileName, subDir, file);
    }

    public ResponseEntity<?> getOutputFile(String fileName) {
        try {
            Path filePath = Paths.get(fileName);
            if (! Files.exists(filePath)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null);
            }

            InputStreamResource resource = new InputStreamResource(Files.newInputStream(filePath));
            MediaType mediaType = MediaType.parseMediaType(Files.probeContentType(filePath));
            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .body(new InputStreamResource(resource.getInputStream()));
        } catch (IOException e) {
            log.error("No file found:", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @SneakyThrows
    private String saveFile(String resultFileName, String subDir, MultipartFile file) {
        Path pathDir = Paths.get(UPLOAD_DIR + "/" + subDir);
        Files.createDirectories(pathDir);

        Path filePath = Paths.get(pathDir + "/" + resultFileName);
        if(!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        try(OutputStream os = Files.newOutputStream(filePath)) {
            os.write(file.getBytes());
        } catch (IOException e){
            log.error(e.getMessage());
        }

        return resultFileName;
    }

}

