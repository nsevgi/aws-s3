package com.nsevgi.s3demo.utility;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AWSS3Service {
    Bucket createBucket(String bucketName);
    List<Bucket> getBucketList();
    ObjectListing getRecordList(String bucketName);
    PutObjectResult sendMessage(String bucketName,String key,String message);
    PutObjectResult sendFile(String bucketName,String key,String filePath);
}
