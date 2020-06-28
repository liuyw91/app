package com.yunmi.app.service.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunmi.app.mapper.system.MenuMapper;
import com.yunmi.app.mapper.system.MenuRoleMapper;
import com.yunmi.app.model.system.Menu;
import com.yunmi.app.model.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
//@CacheConfig(cacheNames = "menus_cache")
public class MenuService extends ServiceImpl<MenuMapper, Menu>  {

    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Menu> getMenusByUserId() {
        return this.baseMapper.getMenusByUserId(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

//    @Cacheable
    public List<Menu> getAllMenusWithRole() {
        return this.baseMapper.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus() {
        return list();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return this.baseMapper.getMidsByRid(rid);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteByRid(rid);
        if (mids == null || mids.length == 0) {
            return true;
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        return result==mids.length;
    }
}
