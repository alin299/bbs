package top.alin.bbs.service;

import top.alin.bbs.entity.User;

public interface UserService {
    User findByName(String username);

    boolean save(User user);
}
