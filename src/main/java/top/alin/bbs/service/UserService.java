package top.alin.bbs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.alin.bbs.entity.User;

import java.util.List;

public interface UserService {

    User findByName(String username);

    List<User> selectUserList();

    boolean save(User user);

    boolean edit(User user);

    boolean editUserRole(Long id, Long roleId);

    User findUserById(Long id);

    boolean del(Long id);

    boolean delSelected(Long[] ids);

    IPage<User> selectByPage(int start, int size);//分页显示全部

    IPage<User> searchByPage(int start, int size, String username);//按username分页查询


}
