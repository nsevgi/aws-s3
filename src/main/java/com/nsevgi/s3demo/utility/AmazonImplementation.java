package com.nsevgi.s3demo.utility;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AmazonImplementation implements AWSS3Service {

    @Autowired
    private AmazonS3 amazonS3;
    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Override
    public Bucket createBucket(String bucketName) {
        Bucket bucket =  amazonS3.createBucket(bucketName);
        return bucket;
    }

    @Override
    public List<Bucket> getBucketList() {
        List<Bucket> buckets=  amazonS3.listBuckets();
            return buckets;
    }

    @Override
    public ObjectListing getRecordList(String bucketName) {
        ObjectListing objects=   amazonS3.listObjects(bucketName);
        return objects;
    }

    @Override
    public PutObjectResult sendMessage(String bucketName,String key,String message) {

        PutObjectResult result = amazonS3.putObject(bucketName,key,message);

        return result;
    }

    @Override
    public PutObjectResult sendFile(String bucketName,String key,String filePath) {

        File file = new File(filePath);
        PutObjectResult result = amazonS3.putObject(bucketName,key,file);
        return result;
    }


}
