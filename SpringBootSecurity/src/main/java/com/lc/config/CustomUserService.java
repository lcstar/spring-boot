package com.lc.config;

import com.lc.mapper.PermissionMapper;
import com.lc.mapper.UserMapper;
import com.lc.model.Permission;
import com.lc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lc
 * createTime 2019/4/29.
 */
@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username",username);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() != 0 && !users.isEmpty()){
            List<Permission> permissions = permissionMapper.findByAdminUserId(users.get(0).getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission: permissions) {
                if (permission != null && permission.getName() != null){
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new org.springframework.security.core.userdetails.User(users.get(0).getUsername(),users.get(0).getPassword(),grantedAuthorities);
        }else{
           throw  new UsernameNotFoundException("admin: " + username + "don't exist");
        }
    }
}
