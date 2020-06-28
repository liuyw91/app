package com.yunmi.app.controller.crm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunmi.app.common.BaseController;
import com.yunmi.app.constant.Constant;
import com.yunmi.app.model.crm.TbUser;
import com.yunmi.app.service.crm.TbUserService;
import com.yunmi.app.utils.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/user/")
@Slf4j
public class TbUserController extends BaseController {

    @Autowired
    TbUserService tbUserService;

    /**
     * 用户统计echarts图
     * @param params
     * @return
     */
    @PostMapping("statistics")
    public Map<String, Object> statistics(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        Map<String,Object> resultMap = new HashMap<>();
        Object start = params.get("startDate");
        if(null != start && !StringUtils.isBlank(start.toString())){
            params.put("startDate", start.toString()+" 00:00:00");
        }
        Object end = params.get("endDate");
        if(null != end && !StringUtils.isBlank(end.toString())){
            params.put("endDate", end.toString()+" 23:59:59");
        }
        //所有用户
        Map<String, Long> tbUserInfo = tbUserService.countUser(params);
        long all = Long.parseLong(tbUserInfo.get("sum").toString());
        long male = Long.parseLong(tbUserInfo.get("male").toString());
        long female = Long.parseLong(tbUserInfo.get("female").toString());
        long other = Long.parseLong(tbUserInfo.get("other").toString());
        long[] line = {all, male, female, other};
        resultMap.put("line", line);

        Map<String,Object> maleMap = new HashMap<>();
        Map<String,Object> femaleMap = new HashMap<>();
        Map<String,Object> otherMap = new HashMap<>();
        maleMap.put("name", "男性");
        maleMap.put("value", male);
        femaleMap.put("name", "女性");
        femaleMap.put("value", female);
        otherMap.put("name", "其他");
        otherMap.put("value", other);
        Map[] pie = {maleMap, femaleMap, otherMap};
        resultMap.put("pie", pie);

        result.put("code", Constant.RESULT_FLAG_SUCCESS);
        result.put("data", resultMap);
        return result;
    }

    @PostMapping("add")
    public Map<String, Object> add(@RequestBody TbUser tbUser){
        Map<String, Object> result = new HashMap<>();
        try {
            tbUserService.saveUser(tbUser);
            result.put("code", Constant.RESULT_FLAG_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", Constant.RESULT_FLAG_FAIL);
            result.put("msg", e.getMessage());
        }
        return result;

    }

    /**
     * 用户头像审核列表
     * @param params
     * @return
     */
    @PostMapping("listApprove")
    public Map<String, Object> listApprove(@RequestBody Map<String, Object> params){
        super.initPageParams(params);
        IPage page = new Page<>(getCurrent(), getPageSize());
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        // 通用查询条件format
        commonQuery(params, queryWrapper);
        queryWrapper.eq("h.CHECK_STATUS", Constant.NUM_0);
        Map<String, Object> map = new HashMap<>();
        map.put(Constant.TABLE_DATA, tbUserService.queryApprovalListByPage(page, queryWrapper));
        map.put(Constant.TABLE_TOTAL, page.getTotal());
        return map;

    }

    /**
     * 获取指定条件下第几个用户
     * @param params
     * @return
     */
    @PostMapping("getSomeUser")
    public TbUser getSomeUser(@RequestBody Map<String, Object> params){
        Map<String, Object> wrapper = new HashMap<>();
        String startDate = MapUtil.getValueStr(params, "startDate");
        String endDae = MapUtil.getValueStr(params, "endDate");
        if(!StringUtils.isBlank(startDate)){
            wrapper.put("startDate", startDate + " 00:00:00");
        }
        if(!StringUtils.isBlank(endDae)){
            wrapper.put("endDate", endDae + " 23:59:59");
        }
        int currentIndex = MapUtil.getValueInt(params, "currentIndex");
        wrapper.put("currentIndex", currentIndex);
        return tbUserService.getSomeUser(wrapper);

    }

    /**
     * 用户列表
     * @param params
     * @return
     */
    @PostMapping("list")
    public Map<String, Object> list(@RequestBody Map<String, Object> params) {
        super.initPageParams(params);
        IPage page = new Page<>(getCurrent(), getPageSize());
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        String phone = MapUtil.getValueStr(params, "phone");
        if (!StringUtils.isBlank(phone)) {
            queryWrapper.like("u.PHONE", phone);
        }
        // 通用查询条件format
        commonQuery(params, queryWrapper);
        Map<String, Object> result = new HashMap<>();
        result.put(Constant.TABLE_DATA, tbUserService.queryListByPage(page, queryWrapper));
        result.put(Constant.TABLE_TOTAL, page.getTotal());
        return result;
    }

    /**
     * 审核
     * @param params
     * @return
     */
    @PostMapping("approval")
    public Map<String, Object> approval(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        try {
            tbUserService.approval(params);
            result.put("code", Constant.RESULT_FLAG_SUCCESS);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            result.put("code", Constant.RESULT_FLAG_FAIL);
            result.put("message", e.getMessage());
        }
        return result;

    }

    /**
     * 通用查询条件format
     * @param params
     * @param queryWrapper
     */
    private void commonQuery(Map<String, Object> params, QueryWrapper<TbUser> queryWrapper){
        String startDate = MapUtil.getValueStr(params, "startDate");
        String endDae = MapUtil.getValueStr(params, "endDate");
        if(!StringUtils.isBlank(startDate)){
            queryWrapper.ge("u.CREATE_DATE", startDate + " 00:00:00");
        }
        if(!StringUtils.isBlank(endDae)){
            queryWrapper.le("u.CREATE_DATE", endDae + " 23:59:59");
        }
        queryWrapper.orderByDesc("u.CREATE_DATE");
    }

}