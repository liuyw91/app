package com.yunmi.app.service.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunmi.app.mapper.system.UserMapper;
import com.yunmi.app.mapper.system.UserRoleMapper;
import com.yunmi.app.model.system.User;
import com.yunmi.app.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
@Transactional
public class UserService extends ServiceImpl<UserMapper, User> implements UserDetailsService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.baseMapper.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        user.setRoles(this.baseMapper.getUserRolesById(user.getId()));
        return user;
    }

    public List<User> getAllUsers(String keywords) {
        return this.baseMapper.getAllUsers(UserUtils.getCurrentUser().getId(),keywords);
    }

    public Boolean updateUser(User user) {
        return saveOrUpdate(user);
    }

    public boolean updateUserRole(Integer userId, Integer[] rids) {
        userRoleMapper.deleteByUserId(userId);
        return userRoleMapper.addRole(userId, rids) == rids.length;
    }

    public boolean deleteUserById(Integer id) {
        return removeById(id);
    }

    public List<User> getAllUsersExceptCurrentHr() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.ne("id", UserUtils.getCurrentUser().getId());
        return this.baseMapper.selectList(userQueryWrapper);
    }

    public boolean updateUserById(User user) {
        return saveOrUpdate(user);
    }

//    public boolean updateUserPasswd(String oldpass, String pass, Integer userId) {
//        User user = getById(userId);
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        if (encoder.matches(oldpass, user.getPassword())) {
//            String encodePass = encoder.encode(pass);
//            Integer result = this.baseMapper.updatePasswd(userId, encodePass);
//            if (result == 1) {
//                return true;
//            }
//        }
//        return false;
//    }

//    public Integer updateUserface(String url, Integer id) {
//        return this.baseMapper.updateUserface(url, id);
//    }
}
