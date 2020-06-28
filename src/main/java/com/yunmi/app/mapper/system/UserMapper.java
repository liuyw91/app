package com.yunmi.app.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunmi.app.model.system.Role;
import com.yunmi.app.model.system.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    User loadUserByUsername(String username);

    List<Role> getUserRolesById(Integer id);

    List<User> getAllUsers(@Param("userId") Integer userId, @Param("keywords") String keywords);

//    Integer updatePasswd(@Param("userId") Integer userId, @Param("encodePass") String encodePass);

//    Integer updateUserface(@Param("url") String url, @Param("id") Integer id);
}