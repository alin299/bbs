package top.alin.bbs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.alin.bbs.entity.Role;
import top.alin.bbs.entity.User;

import java.util.List;

public interface RoleService {

    Role findByName(String rolename);

    boolean save(Role role);

    boolean edit(Role role);

    Role findRoleById(Long id);

    boolean del(Long id);

    boolean delSelected(Long[] ids);

    IPage<Role> selectByPage(int start, int size);//分页显示全部

    IPage<Role> searchByPage(int start, int size, String rolename);//按username分页查询
}
