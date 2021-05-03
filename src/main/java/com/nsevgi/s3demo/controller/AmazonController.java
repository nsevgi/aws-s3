package com.nsevgi.s3demo.controller;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.nsevgi.s3demo.model.SendFileRequestBody;
import com.nsevgi.s3demo.model.SendMessageRequestBody;
import com.nsevgi.s3demo.utility.AWSS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value="/s3")
public class AmazonController {


    @Autowired
    private AWSS3Service service;

    @PostMapping("/bucket/file/v1")
    public ResponseEntity<PutObjectResult> sendFile(@RequestBody SendFileRequestBody request)
    {
        PutObjectResult response = service.sendFile(request.getBucketName(),request.getKey(),request.getFilePath());
        return new ResponseEntity<PutObjectResult>(response,HttpStatus.OK);
    }
    @PostMapping("/bucket/message/v1")
    public ResponseEntity<PutObjectResult> sendMessage(@RequestBody SendMessageRequestBody request)
    {
        PutObjectResult response =service.sendMessage(request.getBucketName(),request.getKey(),request.getMessage());
        return new ResponseEntity<PutObjectResult>(response,HttpStatus.OK);
    }

    @GetMapping(value="/buckets/v1")
    public ResponseEntity<List<Bucket>> getBuckets()
    {
        List<Bucket> response =  service.getBucketList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/bucket/{bucketName}/v1")
    public ResponseEntity<ObjectListing> getRecord(@PathVariable String bucketName)
    {
         ObjectListing response= service.getRecordList(bucketName);
         return new ResponseEntity<ObjectListing>(response,HttpStatus.OK);
    }

    @PostMapping("/bucket/v1")
    public ResponseEntity<Bucket> createBucket(@RequestBody Bucket bucketName)
    {
        Bucket response = service.createBucket(bucketName.getName());
        return new ResponseEntity<Bucket>(response,HttpStatus.OK);
    }


}
