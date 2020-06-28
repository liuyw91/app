package com.yunmi.app.service.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunmi.app.mapper.system.RoleMapper;
import com.yunmi.app.model.system.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {

    public List<Role> getAllRoles() {
        return list();
    }

    public boolean addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        return save(role);
    }

}
