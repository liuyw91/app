package com.yunmi.app.mapper.crm;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yunmi.app.model.crm.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbUserMapper extends BaseMapper<TbUser> {

    /**
     * 用户统计
     * @return
     */
    Map<String, Long> countUser(Map<String, Object> params);

    /**
     * 自定义用户列表 sql 语句分页查询
     * @param page
     * @param queryWrapper
     * @return
     */
    List<TbUser> queryListByPage(IPage page, @Param("ew") QueryWrapper<TbUser> queryWrapper);

    /**
     * 自定义审核列表 sql 语句分页查询
     * @param page
     * @param queryWrapper
     * @return
     */
    List<TbUser> queryApprovalListByPage(IPage page, @Param("ew") QueryWrapper<TbUser> queryWrapper);

    /**
     *
     * @param wrapper
     */
    TbUser querySomeUser(Map<String, Object> wrapper);
}