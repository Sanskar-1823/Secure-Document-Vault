package com.project.securedocumentvault.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.project.securedocumentvault.service.DocumentService;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public String uploadDocument(
            @RequestParam("file") MultipartFile file)
            throws IOException {

        return documentService.uploadFile(file);
    }
}