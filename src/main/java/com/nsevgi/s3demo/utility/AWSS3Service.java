package com.nsevgi.s3demo.utility;
import org.springframework.web.multipart.MultipartFile;

public interface AWSS3Service {
    void uploadFile(MultipartFile multipartFile);
}
