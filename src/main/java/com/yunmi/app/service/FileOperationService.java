package com.yunmi.app.service;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Service
@Slf4j
public class FileOperationService{

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    @Value("${qiniu.domain}")
    private String domain;
    /**
     * 上传文件
     *
     * @param file
     * @return
     * @throws Exception
     */
    public String uploadPic(MultipartFile file) throws Exception {
    	String fileId = UUID.randomUUID().toString().replace("-", "");
        Configuration cfg = new Configuration(Zone.huanan());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            InputStream inputStream = file.getInputStream();
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[600]; //buff用于存放循环读取的临时数据
            int rc = 0;
            while ((rc = inputStream.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            byte[] uploadBytes = swapStream.toByteArray();
            try {
                Response response = uploadManager.put(uploadBytes, fileId, upToken);
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                log.info(putRet.key);
                log.info(putRet.hash);
                log.info(fileId);
                Map<String, Object> map = new HashMap<>();
                return fileId;

            } catch (QiniuException ex) {
                Response r = ex.response;
                log.error(r.toString());
                try {
                    log.error(r.bodyString());
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 批量上传文件
     *
     * @param files
     * @return
     * @throws Exception
     */
    public List<String> uploadPics(MultipartFile[] files) throws Exception {
        //循环取出图片
        List<String> imgUrls = new ArrayList();
//        for (MultipartFile file : files) {
////            //获取文件全名
////            String fileName = file.getOriginalFilename();
////             获取的扩展名 jpg
////            String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
////            新的图片名称(时间戳.文件拓展名)
////            String newFileName = System.currentTimeMillis() + "." + extensionName;
//            imgUrls.add(this.uploadPic(file));
//        }
        return imgUrls;
    }
}