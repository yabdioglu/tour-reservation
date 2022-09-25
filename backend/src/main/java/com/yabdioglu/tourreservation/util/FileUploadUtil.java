package com.yabdioglu.tourreservation.util;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileUploadUtil {

    public String saveFile(MultipartFile multipartFile) throws IOException {
        Path uploadDirectory = Paths.get("uploads");

        String fileType = multipartFile.getContentType().split("/")[1];

        String fileName = UUID.randomUUID().toString() + "." + fileType;
        long size = multipartFile.getSize();

        try(InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadDirectory.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            throw new IOException("Error saving uploaded file: " + fileName, e);
        }
    }

}
