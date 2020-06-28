package com.yunmi.app.common;

import com.yunmi.app.constant.Constant;
import com.yunmi.app.service.FileOperationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/file/")
@Slf4j
public class FileOperationController {

    @Autowired
    private FileOperationService fileOperationService;

    /**
     * 上传头像
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("uploadPic")
    public Map<String, Object> uploadFile(@RequestBody MultipartFile file){
        Map<String, Object> result = new HashMap<>();
        result.put("code", Constant.RESULT_FLAG_FAIL);
        try {
            String fileId = fileOperationService.uploadPic(file);
            if(!StringUtils.isBlank(fileId)){
                result.put("code", Constant.RESULT_FLAG_SUCCESS);
                result.put("data", fileId);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            result.put("data", e.getMessage());
        }
        return result;
    }

}
