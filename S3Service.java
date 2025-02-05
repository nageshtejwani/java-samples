package com.example.s3localstack.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
    String uploadFile(MultipartFile file);
    byte[] downloadFile(String key);
    String createBucket();
}
