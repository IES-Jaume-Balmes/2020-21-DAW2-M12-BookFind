package com.findbook.demo.utils;

import com.findbook.demo.exception.ErrorSavingFile;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileUploadUtil {

    //TODO: VERIFICAR SI EL ARCHIVO ES UNA IMAGEN
    @SneakyThrows
    public static void saveImage(MultipartFile image) {
        /*Folder in the server*/

        String folderMain = "/home/barbara/";

        byte[] bytes = image.getBytes();
        Path path = Paths.get(folderMain + image.getOriginalFilename());

        if (!Files.exists(path)) {
            try {
                Files.write(path, bytes);
            } catch (Exception e) {
                throw new ErrorSavingFile("Could not save image file: " + image.getName());
            }
        }

    }

}
