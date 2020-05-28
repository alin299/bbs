package top.alin.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.alin.bbs.entity.Role;
import top.alin.bbs.entity.User;
import top.alin.bbs.mapper.RoleMapper;
import top.alin.bbs.mapper.UserMapper;
import top.alin.bbs.service.RoleService;
import top.alin.bbs.service.UserService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 通过rolename查询
     * @param rolename
     * @return
     */
    @Override
    public Role findByName(String rolename) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name", rolename);
        return roleMapper.selectOne(wrapper);
    }
    

    /**
     * 添加role
     * @param role
     * @return
     */
    @Override
    public boolean save(Role role) {
        // 查询是否有相同用户名
        if (findByName(role.getRoleName()) != null) {
            return false;
        }
        roleMapper.insert(role);
        return true;
    }

    /**
     * 修改role
     * @param role
     * @return
     */
    @Override
    public boolean edit(Role role) {
        Role oldRole = findRoleById(role.getId());
        if(!oldRole.getRoleName().equals(role.getRoleName())){
            // 查询是否有相同用户名
            if (findByName(role.getRoleName()) != null) {
                return false;
            }
        }
        roleMapper.updateById(role);
        return true;
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    public Role findRoleById(Long id) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return roleMapper.selectOne(wrapper);
    }

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    @Override
    public boolean del(Long id) {
        roleMapper.deleteById(id);
        return true;
    }

    /**
     * 删除选中（批量删除）
     * @param ids
     * @return
     */
    @Override
    public boolean delSelected(Long[] ids) {
        for(Long id:ids){
            roleMapper.deleteById(id);
        }
        return true;
    }

    /**
     * 分页显示全部
     * @param start
     * @param size
     * @return
     */
    @Override
    public IPage<Role> selectByPage(int start, int size) {
        Page<Role> page=new Page<>(start,size);
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        roleMapper.selectPage(page, wrapper);
        return page;
    }

    /**
     * 分页查询
     * @param start
     * @param size
     * @param rolename
     * @return
     */
    @Override
    public IPage<Role> searchByPage(int start, int size, String rolename) {
        Page<Role> page=new Page<>(start,size);
        roleMapper.selectPage(page, new QueryWrapper<Role>().like("role_name", "%"+rolename+"%"));
        return page;
    }


}
