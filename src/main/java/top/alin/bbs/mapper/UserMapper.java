package top.alin.bbs.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.alin.bbs.entity.User;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    IPage<User> getUserPage(IPage<User> page, @Param("ew") QueryWrapper<User> queryWrapper);

    IPage<User> searchUserPage(IPage<User> page, @Param("ew") QueryWrapper<User> queryWrapper);

    User findUserById(@Param("ew") QueryWrapper<User> queryWrapper);
}
