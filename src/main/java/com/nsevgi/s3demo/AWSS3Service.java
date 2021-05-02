package com.nsevgi.s3demo;
import org.springframework.web.multipart.MultipartFile;

public interface AWSS3Service {
    void uploadFile(MultipartFile multipartFile);
}
