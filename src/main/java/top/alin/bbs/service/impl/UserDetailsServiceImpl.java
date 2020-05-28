package top.alin.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.alin.bbs.entity.Role;
import top.alin.bbs.entity.User;
import top.alin.bbs.mapper.UserRoleMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名获取用户
        User user = userRoleMapper.findUserByUsername(username);
        //判断用户是否存在
        if (user == null) {
            throw new UsernameNotFoundException("登录用户不存在!");
        }
        // 根据用户名获取用户的角色信息
        List<Role> roleList = userRoleMapper.findRolesByUserName(username);
        // 创建权限列表
        List<GrantedAuthority> authorityList = new ArrayList<>();
        // 赋予查询到的角色
        for (Role role : roleList) {
            GrantedAuthority authority
                    = new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
            authorityList.add(authority);
        }
        // 创建UserDetails对象，设置用户名、密码和权限
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorityList);
        //返回UserDetails对象
        return userDetails;
    }
}
