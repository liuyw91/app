package com.yunmi.app.common;

import com.yunmi.app.constant.Constant;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

/**
 * @author liuyw
 */
@Data
public abstract class BaseController {

    @Autowired
    private RedisTemplate redisTemplate;

    private long current;
    private long pageSize;
    private String orderBy;
    private String orderM;

    /**
     * 初始化分页参数
     * @param paramsMap
     */
    protected void initPageParams(Map<String,Object> paramsMap) {
        if (paramsMap.containsKey(Constant.PAGE_CURRENT)) {
            this.current = Long.parseLong(String.valueOf(paramsMap.get(Constant.PAGE_CURRENT)));
        } else {
            this.current = 1;
        }
        if (paramsMap.containsKey(Constant.PAGE_PAGE_SIZE)) {
            this.pageSize = Long.parseLong(String.valueOf(paramsMap.get(Constant.PAGE_PAGE_SIZE)));
        } else {
            this.pageSize = 100;
        }
        if (paramsMap.containsKey(Constant.PAGE_ORDER_BY)) {
            this.orderBy = String.valueOf(paramsMap.get(Constant.PAGE_ORDER_BY));
        }
        if (paramsMap.containsKey(Constant.PAGE_ORDER_M)) {
            this.orderM = String.valueOf((paramsMap.get(Constant.PAGE_ORDER_M)));
        }
    }

}
