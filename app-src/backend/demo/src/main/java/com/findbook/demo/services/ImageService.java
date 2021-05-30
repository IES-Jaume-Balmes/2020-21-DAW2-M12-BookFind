package com.findbook.demo.services;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

import org.apache.commons.io.IOUtils;

@Service
public class ImageService {
    public final String storageDirectoryPath = "/home/barbara/Documentos/";

    public ResponseEntity<String> uploadImage(MultipartFile file) {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Path storageDirectory = Paths.get(storageDirectoryPath);

        if (!Files.exists(storageDirectory)) {
            try {
                Files.createDirectories(storageDirectory);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Path destination = Paths.get(storageDirectory.toString() + "/" + fileName);

        try {
            //TODO: CHECK IF IMAGES ALREADY EXISTS
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/admin/books/save/img")
                .path(fileName)
                .toUriString();
        System.out.println(fileDownloadUri);
        return ResponseEntity.ok(fileDownloadUri);
    }

    public byte[] getImageWithMediaType(String imageName) throws IOException {
        Path destination = Paths.get(storageDirectoryPath + "/" + imageName);// retrieve the image by its name

        return IOUtils.toByteArray(destination.toUri());
    }

}
