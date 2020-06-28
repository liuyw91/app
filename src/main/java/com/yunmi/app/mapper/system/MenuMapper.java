package com.yunmi.app.mapper.system;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunmi.app.model.system.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据用户Id获取所有菜单
     * @param userId
     * @return
     */
    List<Menu> getMenusByUserId(Integer userId);

    /**
     * 根据用户角色获取所有菜单
     * @return
     */
    List<Menu> getAllMenusWithRole();

    /**
     * 根据角色id获取所有菜单id
     * @param rid
     * @return
     */
    List<Integer> getMidsByRid(Integer rid);
}