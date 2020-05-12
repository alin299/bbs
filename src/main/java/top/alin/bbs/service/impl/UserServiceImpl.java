package top.alin.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.alin.bbs.entity.User;
import top.alin.bbs.mapper.UserMapper;
import top.alin.bbs.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public boolean save(User user) {
        // 查询是否有相同用户名
        if (findByName(user.getUsername()) != null) {
            return false;
        }
        userMapper.insert(user);
        return true;
    }

    //添加用户
    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    //查询所有用户
    @Override
    public List<User> selectUserList() {
        List<User> userList = userMapper.selectList(null);
        return userList;
    }

}
