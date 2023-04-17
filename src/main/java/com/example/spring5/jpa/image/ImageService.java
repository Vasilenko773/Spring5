package com.example.spring5.jpa.image;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Service
@RequiredArgsConstructor
public class ImageService {

    @Value("${app.image.bucket:C:/projects/Spring5/images}")
    private final String bucket;

    @SneakyThrows
    public void upload(String imagePath, InputStream content) {
        Path fullPath = Path.of(bucket, imagePath);
       try (content){
           Files.createDirectories(fullPath.getParent());
           Files.write(fullPath, content.readAllBytes(),
                   StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
       }
    }
}
