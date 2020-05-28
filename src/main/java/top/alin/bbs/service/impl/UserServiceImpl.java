package top.alin.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    /**
     * 通过username查询
     * @param username
     * @return
     */
    @Override
    public User findByName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return userMapper.selectOne(wrapper);
    }

    /**
     * 查询所有user
     * @return
     */
    @Override
    public List<User> selectUserList() {
        List<User> userList = userMapper.selectList(null);
        return userList;
    }

    /**
     * 添加user
     * @param user
     * @return
     */
    @Override
    public boolean save(User user) {
        // 查询是否有相同用户名
        if (findByName(user.getUsername()) != null) {
            return false;
        }
        userMapper.insert(user);
//        String username = user.getUsername();
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("username", username);
//        User user2 = userMapper.selectOne(wrapper);

        return true;
    }

    /**
     * 修改user
     * @param user
     * @return
     */
    @Override
    public boolean edit(User user) {
        User oldUser  = findUserById(user.getId());
        if(!user.getUsername().equals(oldUser.getUsername())){
            // 查询是否有相同用户名
            if (findByName(user.getUsername()) != null) {
                return false;
            }
        }
        userMapper.updateById(user);
        return true;
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    public User findUserById(Long id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return userMapper.selectOne(wrapper);
    }

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    @Override
    public boolean del(Long id) {
        userMapper.deleteById(id);
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
            userMapper.deleteById(id);
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
    public IPage<User> selectByPage(int start, int size) {
        Page<User> page=new Page<>(start,size);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        userMapper.selectPage(page, wrapper);
        return page;
    }

    @Override
    public IPage<User> selectByPage2(int start, int size) {
        Page<User> page=new Page<>(start,size);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        userMapper.getUserPage(page, wrapper);
        return page;
    }

    /**
     * 分页查询
     * @param start
     * @param size
     * @param username
     * @return
     */
    @Override
    public IPage<User> searchByPage(int start, int size, String username) {
        Page<User> page=new Page<>(start,size);
        userMapper.selectPage(page, new QueryWrapper<User>().like("username", "%"+username+"%"));
        return page;
    }


}
