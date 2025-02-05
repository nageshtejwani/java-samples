package com.example.s3localstack.service.impl;

import com.example.s3localstack.service.S3Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.charset.StandardCharsets;

@Service
public class S3ServiceImpl implements S3Service {

    private final S3Client s3Client;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    public S3ServiceImpl(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public String uploadJsonAsFile(String jsonData, String fileName) {
        byte[] fileContent = jsonData.getBytes(StandardCharsets.UTF_8);

        s3Client.putObject(
                PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(fileName)
                        .contentType("application/json")
                        .build(),
                RequestBody.fromBytes(fileContent)
        );

        return "JSON file uploaded: " + fileName;
    }

    // Other methods (uploadFile, downloadFile, createBucket) remain unchanged...
}
