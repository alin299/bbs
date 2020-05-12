package top.alin.bbs.service;

import top.alin.bbs.entity.User;

import java.util.List;

public interface UserService {
    User findByName(String username);

    boolean save(User user);

    //添加用户
    void add(User user);

    //查询所有用户
    List<User> selectUserList();
}
