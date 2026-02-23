package com.tejait.batch15.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/file")
public class FileController {

    private static final String uploadDir = "C:\\";
    
    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        try {
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }
 
            String filePath = uploadDir + file.getOriginalFilename();
            file.transferTo(new File(filePath));
 
            return "File uploaded successfully: " + file.getOriginalFilename();
        } catch (IOException e) {
            return "File upload failed: " + e.getMessage();
        }
    }
}