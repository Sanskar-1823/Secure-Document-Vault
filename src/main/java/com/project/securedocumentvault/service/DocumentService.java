package com.project.securedocumentvault.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.securedocumentvault.entity.Document;
import com.project.securedocumentvault.repository.DocumentRepository;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public String uploadFile(MultipartFile file)
            throws IOException {

    	String uploadDir = System.getProperty("user.home") + "/uploads/";

    	File directory = new File(uploadDir);

    	if (!directory.exists()) {
    	    directory.mkdirs();
    	}

    	String filePath =
    	        uploadDir + file.getOriginalFilename();

    	file.transferTo(new File(filePath));

        Document document = new Document();

        document.setFileName(
                file.getOriginalFilename());

        document.setFileType(
                file.getContentType());

        document.setFilePath(filePath);

        document.setUploadTime(
                LocalDateTime.now());

        documentRepository.save(document);

        return "File Uploaded Successfully";
    }
}