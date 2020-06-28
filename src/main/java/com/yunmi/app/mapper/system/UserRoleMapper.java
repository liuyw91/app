package com.yunmi.app.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunmi.app.model.system.UserRole;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper extends BaseMapper<UserRole> {

    void deleteByUserId(Integer userId);

    Integer addRole(@Param("userId") Integer userId, @Param("rids") Integer[] rids);
}