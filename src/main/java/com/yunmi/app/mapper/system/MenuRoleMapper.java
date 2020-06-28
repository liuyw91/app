package com.yunmi.app.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunmi.app.model.system.MenuRole;
import org.apache.ibatis.annotations.Param;

public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    void deleteByRid(Integer rid);

    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}